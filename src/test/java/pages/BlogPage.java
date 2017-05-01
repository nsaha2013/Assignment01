package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BlogPage extends Page{
    public BlogPage(WebDriver driver) {
        super(driver, "BBC Blogs - Test Blog - Lorem Ipsum dolar mit");
    }

    @FindBy(css = ".blogs-comments-link")
    private WebElement commentsLink;

    @FindBy(id = "bbc-blogs-comments-iframe")
    private WebElement blogIframe;

    @FindBy(css = ".cmt-title")
    private WebElement commentHeader;

    @FindBy(css = ".id4-cta-signin.id4-cta-button")
    private WebElement signInButton;

    @FindBy(id = "idcta-link")
    private WebElement globalSignInButton;

    @FindBy(css = ".id4-cta-register")
    private WebElement registerButton;

    @FindBy(id = "id4-cta-1")
    private WebElement welcomeMessage;

    @FindBy(css = ".cmts-post-box")
    private WebElement commentsBox;

    @FindBy(css = ".cmts-submit.cmts-button")
    private WebElement postCommentButton;

    @FindBy(css = ".cmts-message.cmts-message-success")
    private WebElement postSuccessMessage;

    @FindBy(css = ".comments-post-comment")
    private WebElement commentPostSection;


    public void clickOnCommentslink() throws InterruptedException {
        clickOn(commentsLink);
        waitForElementVisible(blogIframe,60);
        driver.switchTo().frame(blogIframe);
        waitForElementVisible(commentHeader,60);
    }

    public boolean isSignInButtonDisplayed(){
        return signInButton.isDisplayed();
    }

    public boolean isRegisterButtonDisplayed(){
        return registerButton.isDisplayed();
    }

    public SignInPage clickOnSigninButton() throws InterruptedException {
        waitForElementClickable(signInButton,60);
        clickOn(signInButton);
        driver.switchTo().defaultContent();
        return PageFactory.initElements(driver,SignInPage.class);
    }

    public RegisterPage clickOnRegisterButton() throws InterruptedException {
        waitForElementClickable(registerButton,60);
        clickOn(registerButton);
        driver.switchTo().defaultContent();
        return PageFactory.initElements(driver,RegisterPage.class);
    }

    public boolean isWelcomeMessageDisplayedWith(String message){
        return welcomeMessage.getText().contains(message);
    }

    public void enterComments(String comment){
        enterText(commentsBox,comment);
    }

    public BlogPage clickOnPostComment(){
        waitForElementClickable(postCommentButton,60);
        clickOn(postCommentButton);
        driver.switchTo().defaultContent();
        return PageFactory.initElements(driver,BlogPage.class);
    }

    public boolean isCommentPostSuccessMessageDisplayed(){
        waitForFrameAvailableAndSwitch(blogIframe,120);
        waitForElementVisible(commentHeader,60);
        return (postSuccessMessage.isDisplayed() && postSuccessMessage.getText().equalsIgnoreCase("Thanks, your comment has been posted."));
    }

    public SignInPage clickOnGlobalSigninButton() throws InterruptedException {
        clickOn(globalSignInButton);
        return PageFactory.initElements(driver,SignInPage.class);
    }
}
