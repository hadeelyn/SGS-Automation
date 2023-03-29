package TestPackage;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class RequestTest {
    EdgeDriver driver;
    BaseTest baseTest= new BaseTest();

    @BeforeClass
    public void setUp(){
        driver=  baseTest.setUp("https://sgs.dcetest.com/en");

    }
    @Test(priority = 1)
    public void testlogin() {
        WebElement SigninBtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/ul/li/a"));
        SigninBtn.click();
        JoinFormIGC.individal.getEmailField().sendKeys(TestData.NewIndividalUData.Emailaddress);
        JoinFormIGC.individal.getPasswordField().sendKeys(TestData.NewIndividalUData.Password);
        WebElement submitBtn = driver.findElement(By.id("btn_submit"));
        submitBtn.click();
    }
    @Test(priority = 2)
    public void verifyLinkeGoToRequestSataliteForm(){

        String nextUrl="https://sgs.dcetest.com/en/services/digital-data-and-information/types";
        WebElement service=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/ul/li[3]/a"));
        service.click();
        WebElement digital=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/ul/li[3]/div/div/a[2]"));
        digital.click();
        assertEquals(driver.getCurrentUrl(),nextUrl);
    }
}
