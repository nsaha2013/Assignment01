package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NextRegisterPage extends Page{
    public NextRegisterPage(WebDriver driver) {
        super(driver, "BBC – Register – how old are you?");
    }

    @FindBy(id = "email-input")
    private WebElement emailField;

    @FindBy(id = "password-input")
    private  WebElement passwordField;

    @FindBy(id = "postcode-input")
    private WebElement postcodeField;

    @FindBy(id = "gender-input")
    private WebElement genderDropdown;

    @FindBy(xpath = ".//*[@id='marketingOptIn']/div[1]/div[1]/label/div")
    private WebElement marekitingOptin;

    @FindBy(xpath = ".//*[@id='marketingOptIn']/div[1]/div[2]/label/div")
    private WebElement marketingOptout;

    @FindBy(id = "submit-button")
    private WebElement registerButton;

    public void enterEmail(String email){
        enterText(emailField,email);
    }

    public void enterPassword(String password){
        enterText(passwordField,password);
    }

    public void enterPostcode(String postcode){
        enterText(postcodeField,postcode);
    }

    public void selectGenderFromDropdown(String gender){
        selectFromDropDown(new Select(genderDropdown),gender);
    }

    public void chooseMarketingPreference(String marketingpref){
        if(marketingpref.equalsIgnoreCase("optin")){
            clickOn(marekitingOptin);
        }else{
            clickOn(marketingOptout);
        }
    }

    public RegistrationConfirmationPage clickOnRegisterButton(){
        clickOn(registerButton);
        return PageFactory.initElements(driver,RegistrationConfirmationPage.class);
    }


}
