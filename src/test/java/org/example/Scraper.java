package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Scraper {

    // Instance Variables

    String webDriver;
    String webDriverPath;
    WebDriver driver;

    // Constructor

    public Scraper() {
        this.webDriver = "webdriver.chrome.driver";
        this.webDriverPath = "\"/Users/mtartaglia/Desktop/Java/Assets/chromedriver";
        this.driver = new ChromeDriver();
    }

    // Login Method

    public void login() {
        String loginURL = "https://login.yahoo.com";
        String email = "matt.tester24";
        String password = "112233aabbcc";

        driver.get(loginURL);
        driver.manage().window().maximize();

        WebElement userEntry = driver.findElement(By.id("login-username"));
        userEntry.sendKeys(email + Keys.ENTER);

        WebElement passEntry = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.id("login-passwd")));
        passEntry.sendKeys(password + Keys.ENTER);
    }

    // Scrape Method

    public void scrapeData() {

        // Navigate to Yahoo Finance

        driver.get("https://finance.yahoo.com/portfolio/p_1/view");

        // Isolate Table

        WebElement scrapeTable = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.tagName("tbody")));

        // Isolate Rows in Table

        List<WebElement> scrapeRows = scrapeTable.findElements(By.className("simpTblRow"));

        for (WebElement row : scrapeRows) {

            // Isolate Stock and Fields

            String[] soloStock = row.getText().split(" ");
            String[] splitStock = soloStock[0].split("\\r?\\n");
            String[] splitCap = soloStock[9].split("\\r?\\n");

            StockFactory stock = new StockFactory();
            stock.setSymbol(splitStock[0]);
            stock.setLastPrice(splitStock[1]);
            stock.setCurrency(soloStock[3]);
            stock.setChangeDollars(soloStock[1]);
            stock.setChangePercent(soloStock[2]);
            stock.setVolume(soloStock[6]);
            stock.setAverageVolume(soloStock[8]);
            stock.setMarketCap(splitCap[0]);

            System.out.println(stock.symbol);
            System.out.println(stock.lastPrice);
            System.out.println(stock.currency);
            System.out.println(stock.changeDollars);
            System.out.println(stock.changePercent);
            System.out.println(stock.volume);
            System.out.println(stock.averageVolume);
            System.out.println(stock.marketCap);
            System.out.println("--------------------");

        }

    }

    // Quit Driver

    public void quitDriver() {
        driver.quit();
    }

}

