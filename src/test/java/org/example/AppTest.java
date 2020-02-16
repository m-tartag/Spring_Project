package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void test1()
    {
        System.setProperty("webdriver.chrome.driver","/Users/mtartaglia/Desktop/Java/Assets/chromedriver");
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new FirefoxDriver();
        driver.get("https://login.yahoo.com/");
        driver.manage().window().maximize();
//        driver.close();
//        driver.quit();
        WebElement TB_Username = driver.findElement(By.id("login-username"));
        TB_Username.sendKeys("matt.tester24");

        WebElement BTN_Login = driver.findElement(By.id("login-signin"));
        BTN_Login.submit();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        WebElement TB_Password = driver.findElement(By.id("login-passwd"));
        TB_Password.sendKeys("112233aabbcc");

        WebElement BTN2_Login = driver.findElement(By.id("login-signin"));
        BTN2_Login.click();

    }
}
