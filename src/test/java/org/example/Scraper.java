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
        WebElement tableData = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.tagName("table")));

//        System.out.println(tableData.getText());

//        List<WebElement> row = tableData.findElements(By.tagName("td"));
//        for (WebElement e : row) {
//            if (e.getText().length() != 0) {
//                System.out.println(e.getText());
//
//            }
//        }

        // Isolate Table

        WebElement scrapeTable = driver.findElement(By.tagName("tbody"));

        // Isolate Rows in Table

        List<WebElement> scrapeRows = scrapeTable.findElements(By.className("simpTblRow"));

        for (WebElement row : scrapeRows) {

            System.out.println(row.getText());
            System.out.println("----");

        }

    }

    // Quit Driver

    public void quitDriver() {
        driver.quit();
    }

}


