package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.util.List;

public class Scraper {

    // Instance Variables

    String webDriver;
    String webDriverPath;
    WebDriver driver;
    Connection conn = null;

    // Constructor

    public Scraper() {
        this.webDriver = "webdriver.chrome.driver";
        this.webDriverPath = "\"/Users/mtartaglia/Desktop/Java/Assets/chromedriver";
        this.driver = new ChromeDriver();

        // Connect to DB

//        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crypto", "admin", "admin");
//            System.out.println("SQL Connection to database established!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    // Login Method

    public void login() {
        String loginURL = "https://login.yahoo.com";
        String email = "matt.tester24";
        String password = "112233aabbcc";

        driver.get(loginURL);
        driver.manage().window().maximize();

        WebElement userEntry = driver.findElement(By.id("login-username"));
        userEntry.sendKeys(email + Keys.RETURN);

//        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebElement passEntry = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.id("login-passwd")));
        passEntry.sendKeys(password + Keys.RETURN);

    }

    // Scrape Method

    public void scrapePage() {

        // Navigate to Yahoo Finance

        driver.get("https://finance.yahoo.com/portfolio/p_1/view");

        // Isolate Table within My Portfolio

        WebElement scrapeTable = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.tagName("tbody")));

        // Locate Rows of Table and populate List

        List<WebElement> scrapeRows = scrapeTable.findElements(By.className("simpTblRow"));

        // Iterate over each row in list / clean up the raw scrape

        for (WebElement row : scrapeRows) {

            String[] soloStock = row.getText().replaceAll("\\R+", " ").split(" ");

            // Create Stock Object

            StockFactory stock = new StockFactory();
            stock.setSymbol(soloStock[0]);
            stock.setLastPrice(soloStock[1]);
            stock.setCurrency(soloStock[4]);
            stock.setChangeDollars(soloStock[2]);
            stock.setChangePercent(soloStock[3]);
            stock.setVolume(soloStock[7]);
            stock.setAverageVolume(soloStock[9]);
            stock.setMarketCap(soloStock[10]);

            // Method to Print Stocks to Console (Debugging)

            stock.stockReport();

            // Save to database

            archiveScrape(stock);

        }

    }

    // Method to Send Stock Info to MySQL DB

    public void archiveScrape(StockFactory stock)  {

    }


    // Quit Driver

    public void quitDriver() {
        driver.quit();
    }

}

