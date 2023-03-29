package TestPackage;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CartTest {
    EdgeDriver driver;
    BaseTest baseTest= new BaseTest();

    @BeforeClass
    public void setUp(){
        driver=  baseTest.setUp("https://sgs.dcetest.com/en");

    }

    @Test(priority = 1)
    public void VerifyClickOnTheCartIconToViewCart() {

        WebElement cartIcon = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/a"));
        cartIcon.isDisplayed();
        cartIcon.click();


    }
    @Test(priority = 2)
    public void VerifyIncreaseOrDecreaseQuantityCart() {

        WebElement increaseQtyButton = driver.findElement(By.xpath("//*[@id='product_67']/div[2]/div[2]/div/form/button[2]"));
        increaseQtyButton.click();
        WebElement qtyInput = driver.findElement(By.xpath("//*[@id='product_67']/div[2]/div[2]/div/form/input"));
        assertEquals(qtyInput.getAttribute("value"), "2");

        WebElement decreaseQtyButton = driver.findElement(By.xpath("//*[@id='product_67']/div[2]/div[2]/div/form/button[1]"));
        decreaseQtyButton.click();
        assertEquals(qtyInput.getAttribute("value"), "1");

    }
    @Test(priority = 3)
    public void VerifyCancelRemoveProductCart() {

        WebElement removeProductIcon = driver.findElement(By.xpath("//*[@id='product_67']/div[2]/button"));
        removeProductIcon.click();
        WebElement AlertToRemove = driver.findElement(By.xpath("//*[@id='swal2-html-container']"));
        assertEquals(AlertToRemove.getText(), "You are about to delete this item, are you sure?");
        WebElement Cancel = driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[3]"));
        Cancel.click();
    }
    @Test(priority = 4)
    public void VerifyDeleteProductCart() {

        WebElement removeProductIcon = driver.findElement(By.xpath("//*[@id='product_67']/div[2]/button"));
        removeProductIcon.click();
        WebElement AlertToRemove = driver.findElement(By.xpath("//*[@id='swal2-html-container']"));
        assertEquals(AlertToRemove.getText(), "You are about to delete this item, are you sure?");
        WebElement Delete = driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]"));
        Delete.click();
    }
    @Test(priority = 5)
    public void VerifyThatTheCartIsNowEmpty() {

        WebElement emptyCartMessage = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/h2"));
        assertEquals(emptyCartMessage.getText(), "No items in the cart");
    }
    @Test(priority = 6)
    public void VerifyClickCheckoutButtonOnCart() {
        WebElement checkoutButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[4]/a"));
        checkoutButton.click();
    } @Test(priority = 7)
    public void VerifyClickContinueShippingLink() {
        String xpath="/html/body/div[1]/div[2]/div/div/div[5]/a";
        String nextUrl="https://sgs.dcetest.com/en/products";

        WebElement continueShippingLink = driver.findElement(By.xpath(xpath));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        assertTrue(continueShippingLink.isDisplayed());
        continueShippingLink.click();
        assertEquals(driver.getCurrentUrl(),nextUrl);

    }

}
