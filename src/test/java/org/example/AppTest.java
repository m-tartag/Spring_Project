package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test1() {

        // Init WebDriver + load URL + Maximize Window

        System.setProperty("webdriver.chrome.driver", "/Users/mtartaglia/Desktop/Java/Assets/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.yahoo.com/");
        driver.manage().window().maximize();


        // Username Input

        WebElement userEntry = driver.findElement(By.id("login-username"));
        userEntry.sendKeys("matt.tester24" + Keys.ENTER);
//        userEntry.sendKeys(Keys.ENTER);

        // Password Input

        WebElement passEntry = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.id("login-passwd")));
        passEntry.sendKeys("112233aabbcc" + Keys.ENTER);
//        passEntry.sendKeys(Keys.ENTER);

        // Navigate to Finance -> My Portfolio

        driver.get("https://finance.yahoo.com/portfolio/p_1/view");

        // Target Table via "tbody" + Get Raw Text

        WebElement tableData = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.tagName("table")));

//        System.out.println(tableData.getText());

//        WebElement table = driver.findElement(By.tagName("table"));

        String[] data;
        List<WebElement> row = tableData.findElements(By.tagName("td"));
        for (WebElement e : row) {
            if (e.getText().length() != 0) {
                System.out.println(e.getText());

            }
        }

    }
}




