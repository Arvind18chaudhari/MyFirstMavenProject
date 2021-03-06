package seleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstSeleniumTestCase {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.out.println("********** initiating selenium test case **********");
        System.setProperty("webdriver.chrome.driver","./src/test/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().fullscreen();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testSearchGoogle(){
        System.out.println("********** In Test Method **********");
        driver.findElement(By.name("q")).sendKeys("Selenium Testing tutorial");
        System.out.println("********** Searched Selenium Testing tutorial **********");
        driver.findElement(By.name("q")).submit();
        String actual = driver.getTitle();
        Assert.assertEquals(actual,"Selenium Testing tutorial - Google Search");
        System.out.println("********** title verified **********");
        List<WebElement> list = driver.findElements(By.partialLinkText("Selenium Tutorial - javatpoint"));
        list.get(0).click();
        actual = driver.getTitle();
        Assert.assertEquals(actual,"Selenium Tutorial - javatpoint");
        System.out.println("********** second title verified **********");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        System.out.println("********** Exiting selenium test **********");
    }
}
