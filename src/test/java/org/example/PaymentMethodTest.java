package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;


public class PaymentMethodTest {


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
    @Test(description="User can able to click Add to button successful.")

    void click_AddToCart() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.bewakoof.com/login/");
        driver.findElement(By.cssSelector("#web_email_login")).click();

        ResourceBundle r=ResourceBundle.getBundle("Confidential");
        String id=r.getString("email");
        String pass=r.getString("password");
        driver.findElement(By.xpath("//input[@id='email_input']")).sendKeys(id);
        driver.findElement(By.xpath("//input[@id='mob_password']")).sendKeys(pass);
        WebElement element = driver.findElement(By.cssSelector("#mob_login_password_submit"));
        Actions action=new Actions(driver);
        action.doubleClick(element).perform();

        Thread.sleep(2000);
        WebElement selectShirt= driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/header/div[2]/div/div[3]/div[2]/div/form/input"));
        selectShirt.sendKeys("shirts");
        selectShirt.sendKeys(Keys.ENTER);


        WebElement shirt=driver.findElement(By.xpath("//img[@title=\"Women's Purple Be Rad Graphic Printed Oversized T-shirt-Front Bewakoof\"]"));
        shirt.click();

        driver.findElement(By.xpath("//div[@id='testSizes_L']")).click();


        driver.findElement(By.xpath("//span[normalize-space()='ADD TO BAG']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='GO TO BAG']")).click();


        driver.findElement(By.xpath("//button[@id='os_payNow_btn']")).click();

        driver.findElement(By.xpath("//span[normalize-space()='Cash On Delivery']")).click();

        Thread.sleep(2000);
        WebElement pay= driver.findElement(By.cssSelector("button[type='button']"));
        pay.click();


        String currentUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.bewakoof.com/ordersuccess?detail=eyJvcmRlcl9pZCI6NDQyNDQ4NDgsImNhc2hiYWNrIjowfQ==";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(currentUrl, expectedUrl);
        System.out.println("Order Placed Successfully.");






    }
    @AfterMethod
    void tearDown()
    {
        //driver.close();
    }
}
