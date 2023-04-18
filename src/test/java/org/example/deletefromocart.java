package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class deletefromocart {


    WebDriver driver;
    @BeforeMethod
    void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-notifications");
        driver= new ChromeDriver(options);
    }
    @Test(description="User can able to delete product from the cart")

    void check_delete() throws InterruptedException {

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
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='GO TO BAG']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='testRemoveCart']")).click();

        System.out.println("Test cases passed");
        System.out.println("product is deleted successfully");

    }

    @AfterMethod
    void tearDown()
    {
        driver.close();
    }
}