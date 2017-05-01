package steps;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pages.*;

public class Step {
    static WebDriver driver;
    static BlogPage blogPage;
    static SignInPage signInPage;
    static RegisterPage registerPage;
    static NextRegisterPage nextRegisterPage;
    static RegistrationConfirmationPage registrationConfirmationPage;
    static RegistrationMoreInfoPage registrationMoreInfoPage;
    static AccountConfirmationPage accountConfirmationPage;


    protected String getRandomEmail(){
        return RandomStringUtils.randomAlphanumeric(12) + "@mailinator.com";
    }
}
