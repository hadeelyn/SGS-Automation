package TestPackage;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest {
    EdgeDriver driver;
    BaseTest baseTest= new BaseTest();

    @BeforeClass
    public void setUp(){
        driver=  baseTest.setUp("https://sgs.dcetest.com/en/products");

    }
    @Test(priority = 1)
    public void VerifyClickReportFromLeftListProductListPage (){
        WebElement Report = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div[2]/div/a"));
        Report.click();
     }
    @Test(priority = 2)
    public void VerifyClickMapsFromLeftListProductListPage (){

        WebElement map = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div[3]/div/a"));
        map.click();
    }
    @Test(priority = 3)
    public void VerifyClickTopographicMapsFromLeftListProductListPage (){
        WebElement maplist = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div[3]/div/span"));
        maplist.click();
        WebElement Topographicmap  = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div[3]/ul/li[2]/a"));
        Topographicmap.click();
    }
    @Test(priority = 4)
    public void VerifyClickMiscellaneousMapsFromLeftListProductListPage (){
        WebElement maplist = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div[3]/div/span"));
        maplist.click();
        WebElement miscemap  = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div[3]/ul/li[3]/a"));
        miscemap.click();
    }
    @Test(priority = 5)
    public void VerifyClickGeologicalMapsFromLeftListProductListPage (){
        WebElement maplist = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div[3]/div/span"));
        maplist.click();
        WebElement Geologicalcmap  = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div[3]/ul/li[1]/a"));
        Geologicalcmap.click();
    }
    @Test(priority = 6)
    public void VerifyClickBookFromLeftListProductListPage (){
        WebElement book = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div[4]/div/a"));
        book.click();
        WebElement bookitem = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div[2]"));
bookitem.isDisplayed();
    }
    @Test(priority = 7)
    public void VerifyClickAllProductFromLeftListProductListPage (){
        WebElement allpro = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div[1]/div/a"));
        allpro.click();
    }

    @Test(priority = 8)
    public void VerifySortLowestPriceInProductListPage (){

        // Sort by lowest price
        WebElement sortDropdown = driver.findElement(By.id("type"));
        Select sortSelect = new Select(sortDropdown);
        sortSelect.selectByValue("order_by=price&order_method=asc");

        // Verify that the products are sorted by lowest price
        List<WebElement> productPrices = driver.findElements(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div[2]"));
        assertTrue(isSortedByPrice(productPrices, true));


    }
    @Test(priority = 9)
    public void VerifySortHighestPriceInProductListPage (){

        // Sort by lowest price
        WebElement sortDropdown = driver.findElement(By.id("type"));
        Select sortSelect = new Select(sortDropdown);
        sortSelect.selectByValue("order_by=price&order_method=desc");

        List<WebElement> productPrices = driver.findElements(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div[2]"));

        assertTrue(isSortedByPrice(productPrices, false));
    }

    private boolean isSortedByPrice(List<WebElement> prices, boolean ascending) {
        List<Double> sortedPrices = new ArrayList<Double>();
        for (WebElement price : prices) {
            try {
                sortedPrices.add(Double.parseDouble(price.getText().replace(" SAR", "")));
            } catch (NumberFormatException e) {
                return false; // Invalid price format, cannot be sorted
            }
        }
        List<Double> expectedPrices = new ArrayList<Double>(sortedPrices);
        if (ascending) {
            Collections.sort(expectedPrices);
        } else {
            Collections.sort(expectedPrices, Collections.reverseOrder());
        }
        return sortedPrices.equals(expectedPrices);
    }


    @Test(priority = 10)
    public void testProductDetailPage() {

        WebElement addProduct = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div[2]/a[2]"));
        addProduct.click();

        // Verify that the product name and price are displayed correctly
        WebElement productName = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[2]/h2"));
        assertEquals(productName.getText(), "The Geologic Evolution of Saudi Arabia");
        WebElement productPrice = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[2]/span"));
        assertEquals(productPrice.getText(), "250.00 SAR");
        WebElement fullDisc = driver.findElement(By.xpath("//*[@id='product-details-form']/div/div[1]/div"));
        fullDisc.isDisplayed();



    }

    @Test(priority = 11)
    public void VerifyAddProductToCart() {

        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id='add_to_cart']/button"));
        addToCartButton.isDisplayed();
        addToCartButton.click();

    }
    @Test(priority = 12)
    public void VerifyRemoveProductFromCart() {

        WebElement RemoveFromCartButton = driver.findElement(By.xpath("//*[@id='add_to_cart']/button"));
        assertEquals(RemoveFromCartButton.getText(), "Remove from cart");

        RemoveFromCartButton.isDisplayed();
        RemoveFromCartButton.click();

    }


}
