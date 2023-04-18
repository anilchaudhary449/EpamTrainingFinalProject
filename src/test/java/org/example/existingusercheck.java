package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class existingusercheck{

    WebDriver driver;

    @BeforeMethod
    void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-notifications");
        driver=new ChromeDriver(options);
    }
    @Test(description="Login")
    void valid_details() throws InterruptedException
    {
        Actions action=new Actions(driver);
        driver.get("https://www.bewakoof.com/login/email");
        driver.findElement(By.cssSelector("#web_email_login")).click();
        driver.findElement(By.xpath("//input[@id='email_input']")).sendKeys("anil.bhumal@gmail.com");
        driver.findElement(By.xpath("//input[@id='mob_password']")).sendKeys("EpamTest");
        WebElement element = driver.findElement(By.cssSelector("#mob_login_password_submit"));
        action.doubleClick(element).perform();
        WebElement element2 = driver.findElement(By.tagName("body"));
        Actions builder = new Actions(driver);
        Assertion softAssert = new Assertion();
        builder.moveToElement(element2, 0, 0).perform();
        WebElement icon=driver.findElement(By.xpath("//*[@id=\"testHeaderAcc\"]/i"));
        action.doubleClick(icon).perform();
        driver.findElement(By.id("web_menu_myaccount")).click();
        String currenturl=driver.getCurrentUrl();
        String expectedurl="https://www.bewakoof.com/myaccount";
        softAssert.assertEquals(currenturl, expectedurl);
        System.out.println("login sucessful");
    }

    @AfterMethod
    void tearDown()
    {
        driver.close();
    }
}