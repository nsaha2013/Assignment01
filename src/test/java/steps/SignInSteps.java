package steps;

import cucumber.api.java.en.Given;

public class SignInSteps extends Step{

    @Given("^I enter username to signin as \"([^\"]*)\"$")
    public void i_enter_username_to_signin_as(String username) throws Throwable {
        signInPage.enterUsername(username);
    }

    @Given("^I enter password to signin as \"([^\"]*)\"$")
    public void i_enter_password_to_signin_as(String password) throws Throwable {
        signInPage.enterPassword(password);
    }

    @Given("^I click on sign in button$")
    public void i_click_on_sign_in_button() throws Throwable {
        signInPage.clickOnSignin();
    }

}
