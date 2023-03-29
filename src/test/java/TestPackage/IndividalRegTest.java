package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class IndividalRegTest extends TestData{
    EdgeDriver driver;
    BaseTest baseTest= new BaseTest();

    @BeforeClass
    public void setUp(){
        driver=  baseTest.setUp("https://sgs.dcetest.com/en");

    }

    @Test(description = "register as individal",priority = 1)
    public void testindividalRegistration() {
         WebElement SigninBtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/ul/li/a"));
        SigninBtn.click();
        WebElement CreateAccountBtn = driver.findElement(By.xpath("//*[@id='loginForm']/div/div[2]/a"));
          CreateAccountBtn.click();

        JoinFormIGC.individal.getAccountType().click();
        JoinFormIGC.individal.getFullNameField().sendKeys(TestData.NewIndividalUData.Fullname);
        JoinFormIGC.individal.getIDField().sendKeys(TestData.NewIndividalUData.IDnumber);
       baseTest.next1Btn();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        JoinFormIGC.individal.getEmailField().sendKeys(NewIndividalUData.Emailaddress);
        JoinFormIGC.individal.getMobileField().sendKeys(NewIndividalUData.mobile);
        JoinFormIGC.individal.getPasswordField().sendKeys(NewIndividalUData.Password);
        JoinFormIGC.individal.getPasswordConfirmField().sendKeys(NewIndividalUData.ConPassword);
        baseTest.next2Btn();

            }
    @Test(priority = 2)
    public void VerifyAddressPlaceholderIsDisplayed() {

        JoinFormIGC.individal.getCountryField().isDisplayed();
        JoinFormIGC.individal.getRegionField().isDisplayed();
        JoinFormIGC.individal.getCityField().isDisplayed();
        JoinFormIGC.individal.getAddressField().isDisplayed();

    }
    @Test(priority = 3)
    public void testCountryCitySelectionAndRegister() {

        Select countrySelect = new Select(JoinFormIGC.individal.getCountryField());
        countrySelect.selectByVisibleText("Saudi Arabia");
        WebElement selectedCountry = countrySelect.getFirstSelectedOption();
        assertEquals(selectedCountry.getText(), "Saudi Arabia");

        // Select the city from the dropdown menu

        Select RegionSelect = new Select(JoinFormIGC.individal.getRegionField());
        RegionSelect.selectByVisibleText("Al-Qassim");

        // Verify that the selected city is displayed
        WebElement selectedRigion = RegionSelect.getFirstSelectedOption();
        assertEquals(selectedRigion.getText(), "Al-Qassim");

        Select CitySelect = new Select(JoinFormIGC.individal.getCityField());
        CitySelect.selectByVisibleText("الرس");
        WebElement selectedCity = CitySelect.getFirstSelectedOption();
        assertEquals(selectedCity.getText(), "الرس");
        JoinFormIGC.individal.getAddressField().sendKeys(NewIndividalUData.Address);
        JoinFormIGC.individal.getCreateAccount().click();
    }

}
