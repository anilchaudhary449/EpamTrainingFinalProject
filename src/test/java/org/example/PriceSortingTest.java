package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

public class PriceSortingTest {
    WebDriver driver;
    @BeforeMethod
    void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-notifications");
        driver= new ChromeDriver(options);
    }
    @Test(description="displaying low to high price")

    void priceSorting() throws InterruptedException
    {
        driver.get("https://www.bewakoof.com/");
        driver.findElement(By.cssSelector("#testMenuSelect-shop-men > .menuSelect > span")).click();
        driver.findElement(By.cssSelector(".accordionBox:nth-child(1) .filterHeader")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class='sortbyButton'] span")).click();
        driver.findElement(By.linkText("Price : Low to High")).click();
        Thread.sleep(200);
        String currentURL = driver.getCurrentUrl();
        if(Objects.equals(currentURL, "https://www.bewakoof.com/men-clothing?sort=low"))
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Failed.");
        }
    }


    @AfterMethod
    void tearDown()
    {
        //driver.close();
    }
}
