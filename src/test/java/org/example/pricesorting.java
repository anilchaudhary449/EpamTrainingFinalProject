package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class pricesorting
{
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

    void pricesorting() throws InterruptedException
    {
        driver.get("https://www.bewakoof.com/");
        driver.findElement(By.cssSelector("#testMenuSelect-shop-men > .menuSelect > span")).click();
        driver.findElement(By.cssSelector(".accordionBox:nth-child(1) .filterHeader")).click();
        driver.findElement(By.cssSelector(".sortbyButton > span")).click();
        driver.findElement(By.linkText("Price : Low to High")).click();
        Thread.sleep(200);
        String currentURL = driver.getCurrentUrl();
        if(currentURL=="https://www.bewakoof.com/men-clothing?sort=low")
        {
            System.out.println("Failed");
        }
        else
        {
            System.out.println("Passed");
        }
    }

    //}

    @AfterMethod
    void tearDown()
    {
        //driver.close();
    }
}
