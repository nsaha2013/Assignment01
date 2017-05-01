package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationMoreInfoPage extends Page{
    public RegistrationMoreInfoPage(WebDriver driver) {
        super(driver, "BBC – Sign in - we need some more details");
    }

    @FindBy(id = "displayName-input")
    private WebElement displayNameField;

    @FindBy(id = "submit-button")
    private WebElement continueButton;

    public void enterDisplayName(String displayName){
        enterText(displayNameField,displayName);
    }

    public AccountConfirmationPage clickOnContinueButton(){
        clickOn(continueButton);
        return PageFactory.initElements(driver,AccountConfirmationPage.class);
    }
}
