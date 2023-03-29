package TestPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    static EdgeDriver edgeDriver;
    public static WebDriverWait wait;

    public EdgeDriver setUp(String url) {

        WebDriverManager.chromedriver().setup();
        edgeDriver = new EdgeDriver();
        wait = new WebDriverWait(edgeDriver, Duration.ofMillis(60));
        edgeDriver.get(url);
        edgeDriver.manage().deleteAllCookies();
        edgeDriver.manage().window().maximize();
        return edgeDriver;
    }

    public void next1Btn() {
    WebElement nextBtn = edgeDriver.findElement(By.xpath("//*[@id='step-one-form']/div[2]/button"));
       nextBtn.click();
    }
    public void next2Btn() {
        WebElement nextBtn = edgeDriver.findElement(By.xpath("//*[@id='step-two-form']/div/div[6]/div/button[2]"));
        nextBtn.click();
    }
    public void previous1Btn() {
        WebElement previous1Btn = edgeDriver.findElement(By.xpath("//*[@id='step-two-form']/div/div[6]/div/button[1]"));
        previous1Btn.click();
    }
    public void previous2Btn() {
        WebElement previousBtn = edgeDriver.findElement(By.xpath("//*[@id='my-form']/div[3]/div[2]/button[1]"));
        previousBtn.click();
    }
}
