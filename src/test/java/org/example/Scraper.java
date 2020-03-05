package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Scraper {

    // Instance Variables

    String webDriver;
    String webDriverPath;
    WebDriver driver;

    // Constructor

    public Scraper() {
        this.webDriver = "webdriver.chrome.driver";
        this.webDriverPath = "/Users/mtartaglia/Desktop/Java/Assets/chromedriver";
        this.driver = new ChromeDriver();
    }

    // Login Method

    public void login() {
        final String URL = "https://login.yahoo.com";
        final String EMAIL = "matt.tester24";
        final String PASSWORD = "112233aabbcc";
        WebElement userEntry;
        WebElement passEntry;


        driver.get(URL);
        driver.manage().window().maximize();

        userEntry = driver.findElement(By.id("login-username"));
        userEntry.sendKeys(EMAIL + Keys.RETURN);

        passEntry = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.id("login-passwd")));
        passEntry.sendKeys(PASSWORD + Keys.RETURN);
    }

    // Scrape Method - Yahoo Finance Portfolio

    public void scrapePage() {
        driver.get("https://finance.yahoo.com/portfolio/p_1/view");

        // Find Table

        WebElement scrapeTable = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.tagName("tbody")));

        // Make List of Rows in Table

        List<WebElement> scrapeRows = scrapeTable.findElements(By.className("simpTblRow"));

        // Iterate over each row in list / clean up the raw scrape

        for (WebElement row : scrapeRows) {

            String[] soloStock = row.getText().replaceAll("\\R+", " ").split(" ");

            // Format Date

            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);

            // Create Stock Object

            StockFactory stock = new StockFactory();
            stock.setSymbol(soloStock[0]);
            stock.setLastPrice(soloStock[1]);
            stock.setChangeDollars(soloStock[2]);
            stock.setChangePercent(soloStock[3]);
            stock.setVolume(soloStock[7]);
            stock.setAverageVolume(soloStock[9]);
            stock.setMarketCap(soloStock[10]);
            stock.setScrapeDate(date.toString());

            // Method to Print Stocks to Console (Debugging)

            stock.stockReport();

            // Save to database

            archiveScrape(stock);

        }

    }

    // Method to Send Stock Info to MySQL DB

    public void archiveScrape(StockFactory stock)  {

        try {
                Connection conn = DBConnection.getConnection();
                String query = "insert into stocks (symbol, last_price, change_dollars, change_percent, volume, average_volume, market_cap, scrape_date)"
                        + "values (?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement preparedStmt = conn.prepareStatement(query);

                preparedStmt.setString(1, stock.getSymbol());
                preparedStmt.setString(2, stock.getLastPrice());
                preparedStmt.setString(3, stock.getChangeDollars());
                preparedStmt.setString(4, stock.getChangePercent());
                preparedStmt.setString(5, stock.getVolume());
                preparedStmt.setString(6, stock.getAverageVolume());
                preparedStmt.setString(7, stock.getMarketCap());
                preparedStmt.setString(8, stock.getScrapeDate());

                System.out.println("Saved to Database Successfully!");

                preparedStmt.execute();
                conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    // Quit Driver

    public void quitDriver() {
        driver.quit();
    }

}

