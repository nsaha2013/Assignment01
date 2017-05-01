package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationConfirmationPage extends Page{
    public RegistrationConfirmationPage(WebDriver driver) {
        super(driver, "BBC – Register – thank you");
    }

    @FindBy(css = ".text.text--heading")
    private WebElement displayedEmailText;

    @FindBy(css = ".button.button--full-width.button--big-top")
    private WebElement continueButton;

    public boolean isEmailAddressDisplayed(String expectedEmail){
        return displayedEmailText.getText().toLowerCase().contains(expectedEmail.toLowerCase());
    }

    public RegistrationMoreInfoPage clickOnContinueButton(){
        clickOn(continueButton);
        return PageFactory.initElements(driver,RegistrationMoreInfoPage.class);
    }
}
