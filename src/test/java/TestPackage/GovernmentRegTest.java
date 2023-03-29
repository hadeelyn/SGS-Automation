package TestPackage;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.*;


import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class GovernmentRegTest extends TestData {


    EdgeDriver driver;
    BaseTest baseTest= new BaseTest();

    @BeforeClass
    public void setUp(){
        driver=  baseTest.setUp("https://sgs.dcetest.com/en");

    }



    @Test(description = "register as Government",priority = 2)
    public void testGovernmentRegistration() {

        WebElement SigninBtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/ul/li/a"));
        SigninBtn.click();
        WebElement CreateAccountBtn = driver.findElement(By.xpath("//*[@id='loginForm']/div/div[2]/a"));
        CreateAccountBtn.click();

        JoinFormIGC.Government.getAccountType().click();
        JoinFormIGC.Government.getNameField().sendKeys(NewGovermentData.Governmentname);
        JoinFormIGC.Government.getGovernmentTypeField().sendKeys(NewGovermentData.Governmenttype);

        baseTest.next1Btn();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        baseTest.previous1Btn();



    }



}
