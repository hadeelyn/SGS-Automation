package TestPackage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Keys;

import static org.testng.AssertJUnit.assertTrue;

public class hometest {
    EdgeDriver edgeDriver;
    BaseTest baseTest= new BaseTest();

    @BeforeClass
    public void setUp(){
        edgeDriver=  baseTest.setUp("https://sgs.dcetest.com/en");

    }

    @Test
    public void verifyLoginButtonIsDisplayed(){
        String xpath="/html/body/div[1]/div[1]/div/h1/a";
        WebElement LoginButton=edgeDriver.findElement(By.xpath(xpath));
        assertTrue(LoginButton.isDisplayed());

    }
}
