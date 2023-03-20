package TestPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
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



    public void tearDown() {
        edgeDriver.quit();
    }
}
