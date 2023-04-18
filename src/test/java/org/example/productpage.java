package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class productpage
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
    @Test(description="Product page is visible to user")

    void checkProduct(){
        driver.get("https://www.bewakoof.com/");
        WebElement accessoriestab=driver.findElement(By.xpath("//a[contains(text(),'Accessories')]"));
        Boolean b_productElement= accessoriestab.isDisplayed();
        if(b_productElement)
        {
            System.out.println("Test cases passed");
            System.out.println("menstab is visible");
        }
        else
        {
            System.out.println("test is failed");
        }

    }

    @AfterMethod
    void tearDown()
    {
        driver.close();
    }
}