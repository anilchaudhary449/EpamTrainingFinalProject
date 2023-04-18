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

public class newuser {

    WebDriver driver;

    @BeforeMethod
    void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-notifications");
        driver= new ChromeDriver(options);
    }

    @Test(description="New user registration to bewakoof webpage")
    void validate_Newuser() throws InterruptedException
    {
        driver.get("https://www.bewakoof.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("loginLink")).click();
        WebElement element = driver.findElement(By.id("web_google_login"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        driver.findElement(By.id("web_google_login")).click();
        driver.findElement(By.cssSelector("#identifierId")).sendKeys("yogirambandaru");
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
        driver.findElement(By.tagName("input")).sendKeys("Bandaru");
        driver.findElement(By.tagName("span")).click();
        driver.findElement(By.cssSelector(".xgroup:nth-child(2)")).click();
        driver.findElement(By.id("mob_missing_info_fullanme")).click();
        driver.findElement(By.id("mob_missing_info_fullanme")).sendKeys("yogiramu bandaru");
        driver.findElement(By.id("mob_missing_info_mobile")).click();
        driver.findElement(By.id("mob_missing_info_mobile")).sendKeys("8428964074");
        WebElement element2 = driver.findElement(By.cssSelector(".btn:nth-child(1) input"));
        Actions builder2 = new Actions(driver);
        builder2.moveToElement(element2).perform();
        driver.findElement(By.cssSelector(".btn:nth-child(1) input")).click();
        driver.findElement(By.id("mob_missing_info_save")).click();
        Thread.sleep(2000);
        System.out.println("Test Case Passed");
        System.out.println("You have successfully Registered");
    }


    @AfterMethod
    void tearDown()
    {
        //driver.close();
    }
}

