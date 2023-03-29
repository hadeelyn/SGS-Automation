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

public class CompanyRegTest extends TestData{
    EdgeDriver driver;
    BaseTest baseTest= new BaseTest();

    @BeforeClass
    public void setUp(){
        driver=  baseTest.setUp("https://sgs.dcetest.com/en");

    }

    @Test(description = "register as Company",priority = 3)
    public void testCompanyRegistration() {
        WebElement SigninBtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/ul/li/a"));
        SigninBtn.click();
        WebElement CreateAccountBtn = driver.findElement(By.xpath("//*[@id='loginForm']/div/div[2]/a"));
        CreateAccountBtn.click();

        JoinFormIGC.company.getAccountType().click();
        JoinFormIGC.company.getNameField().sendKeys(NewCompanyData.Companyname);
        JoinFormIGC.company.getCommercialRegisterField().sendKeys(NewCompanyData.CompanyCommercialRegister);
        baseTest.next1Btn();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        JoinFormIGC.company.getEmailField().sendKeys(NewCompanyData.Emailaddress);
        JoinFormIGC.company.getCommissionerResponsibleField().sendKeys(NewCompanyData.Commissionerresponsible);
        JoinFormIGC.company.getActivityField().sendKeys(NewCompanyData.Companyactivity);
        JoinFormIGC.company.getMobileField().sendKeys(NewCompanyData.mobile);
        JoinFormIGC.company.getPasswordField().sendKeys(NewCompanyData.Password);
        JoinFormIGC.company.getPasswordConfirmField().sendKeys(NewCompanyData.ConPassword);
        baseTest.next2Btn();

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
        JoinFormIGC.company.getAddressField().sendKeys(NewCompanyData.Address);
        JoinFormIGC.company.getCreateAccount().click();
    }

}

