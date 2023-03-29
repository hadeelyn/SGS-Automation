package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JoinFormIGC {
    public class individal {
        public static WebElement getCreateAccount() {
            return BaseTest.edgeDriver.findElement(new By.ById("submitRegister"));}

        public static WebElement getAccountType() {
            return BaseTest.edgeDriver.findElement(new By.ById("individual-account"));
        }

        public static WebElement getFullNameField() {
            return BaseTest.edgeDriver.findElement(new By.ById("full_name"));
        }

        public static WebElement getIDField() {
            return BaseTest.edgeDriver.findElement(new By.ById("id_number"));

        }

        public static WebElement getEmailField() {
            return BaseTest.edgeDriver.findElement(new By.ById("email"));

        }

        public static WebElement getPasswordField() {
            return BaseTest.edgeDriver.findElement(new By.ById("password"));

        }
        public static WebElement getPasswordConfirmField() {
            return BaseTest.edgeDriver.findElement(new By.ById("password_confirm"));

        }
        public static WebElement getMobileField() {
            return BaseTest.edgeDriver.findElement(new By.ById("mobile"));
        }

        public static WebElement getImageField() {
            return BaseTest.edgeDriver.findElement(By.xpath("//*[@id='step-two-form']/div/div[5]/div/div[1]/div/div/div/label/span"));

        }

        public static WebElement getCountryField() {
            return BaseTest.edgeDriver.findElement(new By.ById("country_id"));
        }

        public static WebElement getRegionField() {
            return BaseTest.edgeDriver.findElement(new By.ById("region_id"));
        }

        public static WebElement getCityField() {
            return BaseTest.edgeDriver.findElement(new By.ById("city_id"));
        }

        public static WebElement getAddressField() {
            return BaseTest.edgeDriver.findElement(new By.ById("address"));
        }

        public static WebElement getPostalField() {
            return BaseTest.edgeDriver.findElement(new By.ById("postal_code"));
        }


    }

    public class company {
        public static WebElement getAccountType() {
            return BaseTest.edgeDriver.findElement(new By.ById("company-account"));
        }

        public static WebElement getCreateAccount() {
            return BaseTest.edgeDriver.findElement(new By.ById("submitRegister"));}

        public static WebElement getNameField() {
            return BaseTest.edgeDriver.findElement(new By.ById("name"));
        }

        public static WebElement getCommercialRegisterField() {
            return BaseTest.edgeDriver.findElement(new By.ById("commercial_register"));

        }

        public static WebElement getCommissionerResponsibleField() {
            return BaseTest.edgeDriver.findElement(new By.ById("commissioner_responsible"));

        }

        public static WebElement getActivityField() {
            return BaseTest.edgeDriver.findElement(new By.ById("activity"));

        }

        public static WebElement getPasswordField() {
            return BaseTest.edgeDriver.findElement(new By.ById("password"));

        }

        public static WebElement getPasswordConfirmField() {
            return BaseTest.edgeDriver.findElement(new By.ById("password_confirm"));

        }

        public static WebElement getEmailField() {
            return BaseTest.edgeDriver.findElement(new By.ById("email"));

        }

        public static WebElement getMobileField() {
            return BaseTest.edgeDriver.findElement(new By.ById("mobile"));
        }

        public static WebElement getImageField() {
            return BaseTest.edgeDriver.findElement(By.xpath("//*[@id='step-two-form']/div/div[7]/div/div[1]/div/div/div/label/span"));

        }

        public static WebElement getCountryField() {
            return BaseTest.edgeDriver.findElement(new By.ById("country_id"));
        }

        public static WebElement getRegionField() {
            return BaseTest.edgeDriver.findElement(new By.ById("region_id"));
        }

        public static WebElement getCityField() {
            return BaseTest.edgeDriver.findElement(new By.ById("city_id"));
        }

        public static WebElement getAddressField() {
            return BaseTest.edgeDriver.findElement(new By.ById("address"));
        }

        public static WebElement getPostalField() {
            return BaseTest.edgeDriver.findElement(new By.ById("postal_code"));
        }


    }


    public class Government {
        public static WebElement getAccountType() {
            return BaseTest.edgeDriver.findElement(new By.ById("government-account"));
        }
        public static WebElement getCreateAccount() {
            return BaseTest.edgeDriver.findElement(new By.ById("submitRegister"));}
        public static WebElement getNameField() {
            return BaseTest.edgeDriver.findElement(new By.ById("name"));
        }

        public static WebElement getGovernmentTypeField() {
            return BaseTest.edgeDriver.findElement(new By.ById("government_type"));

        }

        public static WebElement getCommissionerResponsibleField() {
            return BaseTest.edgeDriver.findElement(new By.ById("commissioner_responsible"));

        }

        public static WebElement getPasswordField() {
            return BaseTest.edgeDriver.findElement(new By.ById("password"));

        }

        public static WebElement getPasswordConfirmField() {
            return BaseTest.edgeDriver.findElement(new By.ById("password_confirm"));

        }

        public static WebElement getEmailField() {
            return BaseTest.edgeDriver.findElement(new By.ById("email"));

        }

        public static WebElement getMobileField() {
            return BaseTest.edgeDriver.findElement(new By.ById("mobile"));
        }

        public static WebElement getImageField() {
            return BaseTest.edgeDriver.findElement(By.xpath("//*[@id='step-two-form']/div/div[7]/div/div[1]/div/div/div/label/span"));

        }

        public static WebElement getCountryField() {
            return BaseTest.edgeDriver.findElement(new By.ById("country_id"));
        }

        public static WebElement getRegionField() {
            return BaseTest.edgeDriver.findElement(new By.ById("region_id"));
        }

        public static WebElement getCityField() {
            return BaseTest.edgeDriver.findElement(new By.ById("city_id"));
        }

        public static WebElement getAddressField() {
            return BaseTest.edgeDriver.findElement(new By.ById("address"));
        }

        public static WebElement getPostalField() {
            return BaseTest.edgeDriver.findElement(new By.ById("postal_code"));
        }


    }

    public class Trainee {
        public static WebElement getname() {
            return BaseTest.edgeDriver.findElement(new By.ById("text_684476300"));
        }
        public static WebElement getemail() {
            return BaseTest.edgeDriver.findElement(new By.ById("text_444542093"));}
        public static WebElement getmobile() {
            return BaseTest.edgeDriver.findElement(new By.ById("text_157961976"));
        }

        public static WebElement getUniversity() {
            return BaseTest.edgeDriver.findElement(new By.ById("text_806930612"));

        }
        public static WebElement getNoteField() {
            return BaseTest.edgeDriver.findElement(new By.ById("textarea_827510687"));

        }

        public static WebElement getSpecializationField() {
            return BaseTest.edgeDriver.findElement(new By.ById("text_202754835"));

        }}
    public class Trainer {
        public static WebElement getname() {
            return BaseTest.edgeDriver.findElement(new By.ById("text_767514679"));
        }
        public static WebElement getemail() {
            return BaseTest.edgeDriver.findElement(new By.ById("text_965267350"));}
        public static WebElement getmobile() {
            return BaseTest.edgeDriver.findElement(new By.ById("text_308002439"));
        }

        public static WebElement getTrainingField() {
            return BaseTest.edgeDriver.findElement(new By.ById("text_419527629"));

        }
        public static WebElement getDate() {
            return BaseTest.edgeDriver.findElement(new By.ById("_zm9fdx5z5"));

        }

        public static WebElement note() {
            return BaseTest.edgeDriver.findElement(new By.ById("textarea_504968341"));

        }}
}



