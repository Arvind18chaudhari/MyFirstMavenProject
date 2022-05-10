package seleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTestCase {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.out.println("********** initiating selenium test case **********");
        System.setProperty("webdriver.chrome.driver","./src/test/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testSearchGoogle(){
        driver.findElement(By.name("q")).sendKeys("Selenium Testing");
        driver.findElement(By.name("q")).submit();
        String actual = driver.getTitle();
        Assert.assertEquals(actual,"Selenium testing - Google Search");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        System.out.println("********** Exiting selenium test **********");
    }
}
