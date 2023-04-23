package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class AddItemsToFavouriteTest {
    WebDriver driver;
    @BeforeMethod
    void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-notifications");
        driver= new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    void addToFavourite()throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

        Thread.sleep(2000);
        WebElement search=driver.findElement(By.xpath("//input[@placeholder='Search by product, category or collection']"));
        search.sendKeys("shirt");
        search.sendKeys(Keys.ENTER);

        WebElement selectShirt= driver.findElement(By.xpath("//*[@id=\"testProductcard_1\"]/a/div"));
        selectShirt.click();

        Thread.sleep(3000);
        WebElement icon=driver.findElement(By.xpath("//i[@class='icon_user']"));
        action.doubleClick(icon).perform();

        driver.findElement(By.id("web_menu_mywishlist")).click();
        String CurrentUrl=driver.getCurrentUrl();
        String ExpectedUrl="https://www.bewakoof.com/wishlist";

        assertEquals(CurrentUrl, ExpectedUrl);
    }
    @AfterMethod
    void tearPage(){
        driver.quit();
    }
}