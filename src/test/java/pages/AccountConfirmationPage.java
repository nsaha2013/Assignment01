package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountConfirmationPage extends Page{
    public AccountConfirmationPage(WebDriver driver) {
        super(driver, "BBC – Account - thank you");
    }

    @FindBy(css = ".button.button--full-width.button--big-top")
    private WebElement continueButton;

    public BlogPage clickOnContinueButton(){
        clickOn(continueButton);
        return PageFactory.initElements(driver,BlogPage.class);
    }
}
