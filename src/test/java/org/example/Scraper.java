package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void login() {
        String URL = "https://finance.yahoo.com/portfolio/p_1/view";
        String email = "matt.tester24";
        String password = "112233aabbcc";

        driver.get(URL);
        driver.manage().window().maximize();

        WebElement userEntry = driver.findElement(By.id("login-username"));
        userEntry.sendKeys(email + Keys.ENTER);

        WebElement passEntry = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.id("login-passwd")));
        passEntry.sendKeys(password + Keys.ENTER);
    }

}


