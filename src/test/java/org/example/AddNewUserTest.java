package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class AddNewUserTest {

    WebDriver driver;

    @BeforeMethod
    void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-notifications");
        driver= new ChromeDriver(options);
    }

    @Test(description="New user registration to Bewakoof webpage")
    void validate_NewUser() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bewakoof.com/signup");
        driver.manage().window().maximize();


        ResourceBundle r=ResourceBundle.getBundle("UData");
        String Uname=r.getString("name");
        String id=r.getString("email");
        String mobile=r.getString("ph");
        String Upass=r.getString("passkey");
        driver.findElement(By.xpath("//input[@name='fullname']")).sendKeys(Uname);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='mobile-field']")).sendKeys(mobile);
        //Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(id);
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Upass);
        // Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();


        System.out.println("Test Case Passed");
        System.out.println("You have successfully Registered");
    }


    @AfterMethod
    void tearDown()
    {
        driver.close();
    }
}

