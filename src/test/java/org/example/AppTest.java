package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "/Users/mtartaglia/Desktop/Java/Assets/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.yahoo.com/");
        driver.manage().window().maximize();

        // Locate Login + Submit Username + Click Next
        try {

            driver.findElement(By.id("login-username")).sendKeys("matt.tester24");
            driver.findElement(By.id("login-signin")).submit();


            //send password
            WebElement passwordButton = driver.findElement(By.id("login-passwd"));
            WebDriverWait WAIT = new WebDriverWait(driver, 30);
            WAIT.until(ExpectedConditions.elementToBeClickable(passwordButton));
            passwordButton.sendKeys("112233aabbcc");
            driver.findElement(By.xpath("login-signin")).click();

//            driver.findElement(By.id("login-passwd")).sendKeys("112233aabbcc");
//            driver.findElement(By.id("login-signin")).click();

        } finally {

            System.out.println(driver.getTitle());
        }

    }
}

