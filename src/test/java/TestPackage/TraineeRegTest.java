package TestPackage;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class TraineeRegTest {
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
    public void verifyLinkeGoToTrainingPage(){

        String nextUrl="https://sgs.dcetest.com/en/pages/training-63749275aff76";
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[1]/ul/li[4]/a")));
        WebElement trLink=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/ul/li[4]/a"));
        trLink.click();
        WebElement training=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/ul/li[4]/div/div/a"));
        training.click();
        assertEquals(driver.getCurrentUrl(),nextUrl);
    }
    @Test(priority = 3)
    public void VerifyClickTraineeRegistrationButton(){
        String nextUrl="https://sgs.dcetest.com/en/form/trainee";

        WebElement trLink=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div/div[1]/a"));
        trLink.click();
        assertEquals(driver.getCurrentUrl(),nextUrl);
    }
    @Test(priority = 3)
    public void VerifySubmitFormOfTraineeRegistrationWithoutCaptcha(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("text_684476300")));
        JoinFormIGC.Trainee.getname().sendKeys(TestData.Trainee.Traineename);
        JoinFormIGC.Trainee.getemail().sendKeys(TestData.Trainee.email);
        JoinFormIGC.Trainee.getmobile().sendKeys(TestData.Trainee.mobile);
        JoinFormIGC.Trainee.getUniversity().sendKeys(TestData.Trainee.University);
        JoinFormIGC.Trainee.getSpecializationField().sendKeys(TestData.Trainee.Specialization);
        JoinFormIGC.Trainee.getNoteField().sendKeys(TestData.Trainee.Note);
        WebElement submit=driver.findElement(By.xpath("//*[@id='app']/div/div/form/div/div/div[9]/button"));
        submit.click();
        WebElement errormsg=driver.findElement(By.xpath("//*[@id='app']/div/div/form/div/div/div[8]/span"));
           assertEquals(errormsg,"The h-captcha-response field is required.");

    }
}
