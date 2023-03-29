package TestPackage;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.*;

import static org.testng.Assert.assertEquals;



public class LoginTest {
    EdgeDriver driver;
    BaseTest baseTest = new BaseTest();

    @BeforeClass
    public void setUp() {
        driver = baseTest.setUp("https://sgs.dcetest.com/en");

    }
    @Test(priority = 1)
    public void testLoginWithInvalidEmailAndEmptyPassword() {
        WebElement SigninBtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/ul/li/a"));
        SigninBtn.click();

        JoinFormIGC.individal.getEmailField().sendKeys("h222@gmail.com");
        JoinFormIGC.individal.getPasswordField().sendKeys("");
        WebElement submitBtn = driver.findElement(By.id("btn_submit"));
        submitBtn.click();
        WebElement errmsgpass = driver.findElement(By.xpath("//*[@id='loginForm']/div/div[1]/div/div[2]/span"));
        assertEquals(errmsgpass.getText(), "The password field is required.");
        WebElement errmsg = driver.findElement(By.xpath("//*[@id='loginForm']/div/div[1]/div/div[1]/span"));
        assertEquals(errmsg.getText(), "These credentials do not match our records.");

    }
    @Test(priority = 2)
    public void testLoginWithEmailAndRememberMe() {

        JoinFormIGC.individal.getEmailField().clear();
        JoinFormIGC.individal.getEmailField().sendKeys(TestData.NewIndividalUData.Emailaddress);
        JoinFormIGC.individal.getPasswordField().clear();
        JoinFormIGC.individal.getPasswordField().sendKeys(TestData.NewIndividalUData.Password);
        WebElement rememberMeCheckbox = driver.findElement(By.id("comments"));
        rememberMeCheckbox.click();
        WebElement submitBtn = driver.findElement(By.id("btn_submit"));
        submitBtn.click();


    }

}
