package TestPackage;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class UserProfileTest {
    EdgeDriver driver;
    BaseTest baseTest = new BaseTest();
    @BeforeClass
    public void setUp()  {
        driver = baseTest.setUp("https://sgs.dcetest.com/en");

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
    public void Verifythatthepagehasloaded(){
        String xpath="/html/body/div[1]/div[1]/div/div[2]/div/div[1]/button/img";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement icon=driver.findElement(By.xpath(xpath));
        icon.isDisplayed();
         icon.click();
        WebElement profile=driver.findElement(By.id("user-menu-item-0"));
        profile.click();
        String pageTitle = driver.getTitle();
        assertEquals("Profile - SGS", pageTitle);
    }
    @Test(priority = 3)
    public void VerifyChangingTheData() {

        // Find and click the "Change Photo" button
        WebElement changePhotoBtn = driver.findElement(By.xpath("//*[@id='profileForm']/div/div[1]/div[2]/div/label"));
        changePhotoBtn.isDisplayed();
        //changePhotoBtn.sendKeys("C:/Users/Global/Downloads/R (1)..jfif");

        // Find and fill in the name field
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.clear();
        nameField.sendKeys("Hadeel QA");

        // Find and fill in the email field
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.clear();
        emailField.sendKeys("Testh@gmail.com");

        // Find and fill in the mobile field
        WebElement mobileField = driver.findElement(By.id("mobile_number"));
        mobileField.clear();
        mobileField.sendKeys("5555551234");

        // Find and fill in the phone number field
        WebElement phoneField = driver.findElement(By.xpath("//*[@id='phone_number']"));
        phoneField.clear();
        phoneField.sendKeys("5555555678");

        // Find and fill in the address field
        WebElement addressField = driver.findElement(By.id("address"));
        addressField.clear();
        addressField.sendKeys("123 Gaza St.");

        // Find and fill in the postal code field
        WebElement postalCodeField = driver.findElement(By.id("postal_code"));
        postalCodeField.clear();
        postalCodeField.sendKeys("90210");}
        @Test(priority = 4)
        public void VerifyClickingSaveData() {

        WebElement saveBtn = driver.findElement(By.xpath("//*[@id='profileForm']/div/div[2]/button"));
        saveBtn.click();}

    @Test(priority = 5)
    public void VerifyNavigateToChangePasswordPage() {

        String xpath="/html/body/div[1]/div[2]/div/div/div/aside/nav/a[2]";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Actions actions = new Actions(driver);
        WebElement pass=driver.findElement(By.xpath(xpath));
        actions.moveToElement(pass).click().perform();

    }
        @Test(priority = 6)
        public void VerifyLoadedChangePasswordPage() {
        // Verify that the page has loaded
        String pageTitle = driver.getTitle();
        assertEquals("Change Password - SGS", pageTitle);
    }

        @Test(priority = 7)
        public void testChangePasswordPage() {

        WebElement currentPasswordField = driver.findElement(By.id("current_password"));
        currentPasswordField.sendKeys(TestData.NewIndividalUData.Password);

        WebElement newPasswordField = driver.findElement(By.id("new_password"));
        newPasswordField.sendKeys(TestData.NewIndividalUData.newPassword);

        WebElement confirmPasswordField = driver.findElement(By.id("new_password_confirmation"));
        confirmPasswordField.sendKeys(TestData.NewIndividalUData.ConPassword);

        // Click the Change Password button
        WebElement changePasswordBtn = driver.findElement(By.xpath("//*[@id='passwordForm']/div/div[2]/button"));
        changePasswordBtn.click();

    }
    @Test(priority = 7)
    public void VerifyNavigateToRequestPage() {

        String xpath="/html/body/div[1]/div[2]/div/div/div/aside/nav/a[3]";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Actions actions = new Actions(driver);
        WebElement pass=driver.findElement(By.xpath(xpath));
        actions.moveToElement(pass).click().perform();

    }
    @Test(priority = 8)
    public void VerifyNavigateToOrderPage() {

        String xpath="/html/body/div[1]/div[2]/div/div/div/aside/nav/a[4]";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Actions actions = new Actions(driver);
        WebElement pass=driver.findElement(By.xpath(xpath));
        actions.moveToElement(pass).click().perform();

    }
    @Test(priority = 9)
    public void VerifyLogout() {
        WebElement logoutBtn = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/aside/nav/a[5]"));
        logoutBtn.click();
    }
}