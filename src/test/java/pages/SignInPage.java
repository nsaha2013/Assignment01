package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Page{
    public SignInPage(WebDriver driver) {
        super(driver, "BBC – Sign in");
    }

    @FindBy(id = "username-input")
    private WebElement usernameField;

    @FindBy(id = "password-input")
    private WebElement passwordField;

    @FindBy(id = "submit-button")
    private WebElement signinButton;


    public void enterUsername(String username){
        enterText(usernameField,username);
    }

    public void enterPassword(String password){
        enterText(passwordField,password);
    }

    public BlogPage clickOnSignin(){
        clickOn(signinButton);
        return PageFactory.initElements(driver,BlogPage.class);
    }
}
