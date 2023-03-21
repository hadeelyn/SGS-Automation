package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JoinFormIGC {

    public static WebElement getJoinForm(){
        return BaseTest.edgeDriver.findElement(By.id("joinUsModal"));
    }
    public static WebElement getNameField(){
      return  BaseTest.edgeDriver.findElement(By.xpath("//*[@id='wpcf7-f1890-o2']/form/div[2]/input"));
    }

    public static WebElement getMobileField(){
      return  BaseTest.edgeDriver.findElement(By.xpath("//*[@id='wpcf7-f1890-o2']/form/div[3]/input"));
    }

    public static WebElement getAcademicDegreeField(){
      return  BaseTest.edgeDriver.findElement(By.xpath("//*[@id='wpcf7-f1890-o2']/form/div[4]/input"));
    }

    public static WebElement getSpecialityField(){
      return  BaseTest.edgeDriver.findElement(By.xpath("//*[@id='wpcf7-f1890-o2']/form/div[5]/input"));
    }

    public static WebElement getYearsOfExperienceField(){
      return  BaseTest.edgeDriver.findElement(By.xpath("//*[@id='wpcf7-f1890-o2']/form/div[6]/input"));
    }
    public static WebElement getSocialAccountField(){
      return  BaseTest.edgeDriver.findElement(By.xpath("//*[@id='wpcf7-f1890-o2']/form/div[7]/input"));
    }

    public static WebElement getSendFormButtontField(){
      return  BaseTest.edgeDriver.findElement(By.xpath("//*[@id='wpcf7-f1890-o2']/form/input"));
    }
    public static WebElement getSuccessLabel(){
      return  BaseTest.edgeDriver.findElement(By.xpath("//*[@id='wpcf7-f1890-o2']/form/div[8]"));
    }

}
