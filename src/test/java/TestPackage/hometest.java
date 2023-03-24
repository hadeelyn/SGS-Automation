package TestPackage;
import io.cucumber.java.AfterAll;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class hometest {
    EdgeDriver driver;
    BaseTest baseTest= new BaseTest();

    @BeforeClass
    public void setUp(){
        driver=  baseTest.setUp("https://sgs.dcetest.com/en");

    }

    @Test(priority = 1)
    public void verifyLoginButtonIsDisplayed(){
        String xpath="/html/body/div[1]/div[1]/div/h1/a";
        WebElement LoginButton=driver.findElement(By.xpath(xpath));
        assertTrue(LoginButton.isDisplayed());

    }

        @Test(priority = 2)
        public void verifyThatTheHomepageAppearProperly() {
            driver.manage().window().setSize(new Dimension(1552, 840));
            driver.findElement(By.linkText("Home")).click();
            driver.findElement(By.cssSelector(".w-\\[116px\\]")).click();
            {
                WebElement element = driver.findElement(By.linkText("Training"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element).perform();
            }
            {
                WebElement element = driver.findElement(By.tagName("body"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element, 0, 0).perform();
            }


        }

    @Test(priority = 3)
    public void verifyThatClickingLangauageIconChangesTheLanguageWebsite() {
        WebElement lanButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/div/a"));
        Assert.assertTrue(lanButton.isDisplayed());
      lanButton.click();

    }

}
