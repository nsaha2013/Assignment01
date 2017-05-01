package steps;

import cucumber.api.java.en.Given;
import org.junit.Assert;

public class RegistrationSteps extends Step{
    String email = null;

    @Given("^I enter date of birth as \"([^\"]*)\"$")
    public void i_enter_date_of_birth_as(String dob) throws Throwable {
        String[] dobArray = dob.split("-");
        registerPage.enterDayofDateOfBirth(dobArray[0]);
        registerPage.enterMonthofDateOfBirth(dobArray[1]);
        registerPage.enterYearofDateOfBirth(dobArray[2]);
    }

    @Given("^I click on Next button$")
    public void i_click_on_Next_button() throws Throwable {
       nextRegisterPage = registerPage.clickOnNextButton();
    }

    @Given("^I enter Email as a valid random email$")
    public void i_enter_email_as_a_valid_random_email() throws Throwable {
        email = getRandomEmail();
        nextRegisterPage.enterEmail(email);
    }

    @Given("^I enter password as \"([^\"]*)\"$")
    public void i_enter_password_as(String password) throws Throwable {
        nextRegisterPage.enterPassword(password);
    }

    @Given("^I enter postcode as \"([^\"]*)\"$")
    public void i_enter_postcode_as(String postcode) throws Throwable {
        nextRegisterPage.enterPostcode(postcode);
    }

    @Given("^I select gender as \"([^\"]*)\"$")
    public void i_select_gender_as(String gender) throws Throwable {
        nextRegisterPage.selectGenderFromDropdown(gender);
    }

    @Given("^I choose marketing preference as \"([^\"]*)\"$")
    public void i_choose_marketing_preference_as(String marketing) throws Throwable {
        nextRegisterPage.chooseMarketingPreference(marketing);
    }

    @Given("^I click on Register button$")
    public void i_click_on_Register_button() throws Throwable {
        registrationConfirmationPage = nextRegisterPage.clickOnRegisterButton();
    }

    @Given("^I see the registered email address is displayed on the confirmation page$")
    public void i_see_the_registered_email_address_is_displayed_on_the_confirmation_page() throws Throwable {
        Assert.assertTrue(registrationConfirmationPage.isEmailAddressDisplayed(email));
    }

    @Given("^I click on continue button on confirmation page$")
    public void i_click_on_continue_button_on_confirmation_page() throws Throwable {
        registrationMoreInfoPage = registrationConfirmationPage.clickOnContinueButton();
    }

    @Given("^I enter display name as \"([^\"]*)\"$")
    public void i_enter_display_name_as(String displayname) throws Throwable {
        registrationMoreInfoPage.enterDisplayName(displayname);
    }

    @Given("^I click on continue button on more info page$")
    public void i_click_on_continue_button_on_more_info_page() throws Throwable {
        accountConfirmationPage = registrationMoreInfoPage.clickOnContinueButton();
    }

    @Given("^I click on continue button on Account confirmation page$")
    public void i_click_on_continue_button_on_Account_confirmation_page() throws Throwable {
        blogPage = accountConfirmationPage.clickOnContinueButton();
    }



}

