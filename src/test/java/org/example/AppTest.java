package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

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


        // Username Input

        WebElement userEntry = driver.findElement(By.id("login-username"));

        userEntry.sendKeys("matt.tester24");
        userEntry.submit();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Password Input

        WebElement passEntry = driver.findElement(By.id("login-passwd"));

        passEntry.sendKeys("112233aabbcc");
        passEntry.sendKeys(Keys.ENTER);

        // Navigate to Finance -> My Portfolio

        driver.get("https://finance.yahoo.com/portfolio/p_1/view");

        // Target Table via "tbody" + Get Raw Text

        WebElement tableData = driver.findElement(By.tagName("tbody"));
        System.out.println(tableData.getText());


    }

}




