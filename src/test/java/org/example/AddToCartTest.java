package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddToCartTest {

    WebDriver driver;
    @BeforeMethod
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    @Test(description="User can able to click Add to button successful.")

    void click_AddToCart() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.bewakoof.com/");

        WebElement search=driver.findElement(By.xpath("//input[@placeholder='Search by product, category or collection']"));
        search.sendKeys("shirt");
        search.sendKeys(Keys.ENTER);

        WebElement selectShirt= driver.findElement(By.xpath("//*[@id=\"testProductcard_3\"]/a/div"));
        selectShirt.click();

        JavascriptExecutor jp = (JavascriptExecutor) driver;
        jp.executeScript("window.scrollBy(0,280)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='testSizes_L']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='ADD TO BAG']")).click();

        System.out.println("Test cases passed");
        System.out.println("AddToCart button clicked successfully");

    }

    @AfterMethod
    void tearDown()
    {
        //driver.close();
    }
}