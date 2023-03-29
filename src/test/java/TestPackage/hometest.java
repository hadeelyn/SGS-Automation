package TestPackage;
import io.cucumber.java.AfterAll;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
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
    public void verifyFavouritTitleIsDisplayed(){

        String pageTitle = driver.getTitle();
        Assert.assertEquals("Home - SGS", pageTitle);


    }
        @Test(priority = 3)
        public void verifyThatTheHomepageAppearProperly() {
            driver.manage().window().setSize(new Dimension(1552, 840));
            driver.findElement(By.linkText("Home")).click();
            driver.findElement(By.cssSelector(".w-[116px]")).click();
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

    @Test(priority = 4)
    public void verifyThatClickingLangauageIconChangesTheLanguageWebsite() {
        WebElement lanButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/div/a"));
        Assert.assertTrue(lanButton.isDisplayed());
      lanButton.click();

    }
    @Test(priority = 5)
    public void verifyLinkeGoToDigitalDataAndInformation(){

        String nextUrl="https://sgs.dcetest.com/en/services/digital-data-and-information/types";
        WebElement service=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/ul/li[3]/a"));
        service.click();
        WebElement digital=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/ul/li[3]/div/div/a[2]"));
       digital.click();
       assertEquals(driver.getCurrentUrl(),nextUrl);
    }
    @Test(priority = 6)
    public void verifyLinkeGoToContactUs(){
        String nextUrl="https://sgs.dcetest.com/en/contactus";
        WebElement contact=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/ul/li[6]/a"));
        contact.click();
        assertEquals(driver.getCurrentUrl(),nextUrl);
    }
    @Test(priority = 7)
    public void verifyLinkeGoToAoun(){
        String nextUrl="https://ownprd.sgs.gov.sa/sap/bc/ui5_ui5/ui2/ushell/shells/abap/FioriLaunchpad.html";
        WebElement aoun=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/ul/li[8]/a"));
        aoun.click();
        assertEquals(driver.getCurrentUrl(),nextUrl);
    }
    @Test(priority = 8)
    public void verifyLinkeGoToAlbum(){

        String nextUrl="https://sgs.dcetest.com/en/albums";
        WebElement media=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/ul/li[5]/a"));
        media.click();
        WebElement album=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/ul/li[5]/div/div/a[4]"));
        album.click();
        assertEquals(driver.getCurrentUrl(),nextUrl);
    }
    @Test(priority = 10)
    public void verifyLinkeGoToAboutUsVision(){

        String nextUrl="https://sgs.dcetest.com/en/pages/vision-and-mission";
        WebElement about=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/ul/li[2]/a"));
        about.click();
        WebElement vision=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/ul/li[2]/div/div/a[1]"));
        vision.click();
        assertEquals(driver.getCurrentUrl(),nextUrl);
    }
}
