package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    }
    @Test(description="User can able to click Add to button successful.")

    void click_AddToCart() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.bewakoof.com/login/");
        driver.findElement(By.cssSelector("#web_email_login")).click();

        ResourceBundle r=ResourceBundle.getBundle("confidentials");
        String id=r.getString("email");
        String pass=r.getString("password");
        driver.findElement(By.xpath("//input[@id='email_input']")).sendKeys(id);
        driver.findElement(By.xpath("//input[@id='mob_password']")).sendKeys(pass);
        WebElement element = driver.findElement(By.cssSelector("#mob_login_password_submit"));
        Actions action=new Actions(driver);
        action.doubleClick(element).perform();

//            WebElement search=driver.findElement(By.xpath("//input[@placeholder='Search by product, category or collection']"));
//            search.sendKeys("shirts");
//            search.sendKeys(Keys.ENTER);
//
//            driver.findElement(By.xpath("//*[@id=\"testProductcard_3\"]/a/div")).click();
//            WebElement size=driver.findElement(By.xpath("//div[@id='testSizes_L']"));
//            Actions action1=new Actions(driver);
//            action.moveToElement(size).click().perform();
//            driver.findElement(By.cssSelector("#addToCart > span")).click();
//            WebElement bad=driver.findElement(By.xpath("//span[contains(text(),'GO TO BAG')]"));
//            action.doubleClick(bad).perform();

        WebElement search=driver.findElement(By.xpath("//input[@placeholder='Search by product, category or collection']"));
        search.sendKeys("shirt");
        search.sendKeys(Keys.ENTER);

//            WebElement price=driver.findElement((By.tagName("p")));
//            price.getText();
//            driver.findElement(By.id("os_payNow_btn")).click();
//            //confirming the address
//            WebElement address=driver.findElement(By.id("os_payNow_btn"));
//
//            //payment method
//            WebElement upi=driver.findElement(By.id("testPaymentGateway-UPI"));
//            action.moveToElement(address).moveToElement(upi).click().perform();
//            WebElement typeupi=driver.findElement(By.id("pay_upi_input"));
//            typeupi.sendKeys("6303739413@apl");
//            driver.findElement(By.id("pay_upiPayNow_button")).click();
//            //after verifying the user going to pay the amount
//            WebElement pay=driver.findElement(By.id("pay_upiPayNow_button"));
//            action.moveToElement(pay).click().perform();
//            String currenturl=driver.getCurrentUrl();
//            String expectedurl="https://www.bewakoof.com/ordersuccess?detail=eyJvcmRlcl9pZCI6NDQyNDQ4NDgsImNhc2hiYWNrIjowfQ==";
//            SoftAssert softAssert = new SoftAssert();
//            softAssert.assertEquals(currenturl, expectedurl);
//            System.out.println("order sucessfull");






    }
    @AfterMethod
    void tearDown()
    {
        //driver.close();
    }
}
