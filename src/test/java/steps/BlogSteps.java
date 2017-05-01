package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class BlogSteps extends Step {

    @Given("^I click on comments link$")
    public void i_click_on_comments_link() throws Throwable {
        blogPage.clickOnCommentslink();
    }

    @Given("^I see the signin and register options are displayed$")
    public void i_see_the_signin_and_register_options_are_displayed() throws Throwable {
        Assert.assertTrue(blogPage.isSignInButtonDisplayed());
        Assert.assertTrue(blogPage.isRegisterButtonDisplayed());
    }

    @Given("^I choose the option to signin$")
    public void i_choose_the_option_to_signin() throws Throwable {
       signInPage = blogPage.clickOnSigninButton();
    }

    @Given("^I choose the option to register$")
    public void i_choose_the_option_to_register() throws Throwable {
        registerPage = blogPage.clickOnRegisterButton();
    }

    @Given("^I see the welcome message \"([^\"]*)\"$")
    public void i_see_the_welcome_message(String message) throws Throwable {
        Assert.assertTrue(blogPage.isWelcomeMessageDisplayedWith(message));
    }

    @Given("^I enter the comment as \"([^\"]*)\"$")
    public void i_enter_the_comment_as(String comment) throws Throwable {
        blogPage.enterComments(comment);
    }

    @Given("^I click on Post Comment button$")
    public void i_click_on_Post_Comment_button() throws Throwable {
        blogPage = blogPage.clickOnPostComment();
    }

    @Then("^I see the Post comment success message is displayed$")
    public void i_see_the_Post_comment_success_message_is_displayed() throws Throwable {
        Assert.assertTrue(blogPage.isCommentPostSuccessMessageDisplayed());
    }

    @Then("^I see the Post comment error message is displayed$")
    public void i_see_the_Post_comment_error_message_is_displayed() throws Throwable {
        Assert.assertTrue(blogPage.isCommentPostErrorMessageDisplayed());
    }

    @Then("^I see the message \"([^\"]*)\"$")
    public void i_see_the_message(String message) throws Throwable {
        Assert.assertTrue(blogPage.isWelcomeMessageDisplayedWith(message));
    }


}
