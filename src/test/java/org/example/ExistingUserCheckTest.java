package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.ResourceBundle;

public class ExistingUserCheckTest {

    WebDriver driver;

    @BeforeMethod
    void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(description="Login")
    void valid_details() throws InterruptedException
    {
        Actions action=new Actions(driver);
        driver.get("https://www.bewakoof.com/login/email");
        driver.findElement(By.cssSelector("#web_email_login")).click();
        ResourceBundle r=ResourceBundle.getBundle("Confidential");
        String id=r.getString("email");
        String pass=r.getString("password");
        driver.findElement(By.xpath("//input[@id='email_input']")).sendKeys(id);
        driver.findElement(By.xpath("//input[@id='mob_password']")).sendKeys(pass);
        WebElement element = driver.findElement(By.cssSelector("#mob_login_password_submit"));
        action.doubleClick(element).perform();

        WebElement element2 = driver.findElement(By.tagName("body"));
        Actions builder = new Actions(driver);
        Assertion softAssert = new Assertion();
        builder.moveToElement(element2, 0, 0).perform();

        Thread.sleep(3000);
        WebElement icon=driver.findElement(By.xpath("//i[@class='icon_user']"));
        action.doubleClick(icon).perform();

        driver.findElement(By.id("web_menu_myaccount")).click();
        String CurrentUrl=driver.getCurrentUrl();
        String ExpectedUrl="https://www.bewakoof.com/myaccount";
        softAssert.assertEquals(CurrentUrl, ExpectedUrl);
        System.out.println("login Successful");
    }

    @AfterMethod
    void tearDown()
    {
        //driver.close();
    }
}