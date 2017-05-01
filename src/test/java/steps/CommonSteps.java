package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BlogPage;

public class CommonSteps extends Step {

    @Before
    public void setup(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
        driver=null;
    }


    @Given("^I am on BBC blogpage and I am not signed in$")
    public void i_am_on_BBC_blogpage_and_I_am_not_signed_in() throws Throwable {
        driver.get("http://www.bbc.co.uk/blogs/test/entries/f5f3031a-1a29-44ee-b2f8-86e78bfd57b0");
        blogPage = PageFactory.initElements(driver, BlogPage.class);
    }

    @Given("^I am on BBC blogpage and I am already signed in as \"([^\"]*)\":\"([^\"]*)\"$")
    public void i_am_on_BBC_blogpage_and_I_am_already_signed_in_as(String username, String password) throws Throwable {
        driver.get("http://www.bbc.co.uk/blogs/test/entries/f5f3031a-1a29-44ee-b2f8-86e78bfd57b0");
        blogPage = PageFactory.initElements(driver, BlogPage.class);
        signInPage = blogPage.clickOnGlobalSigninButton();
        signInPage.enterUsername(username);
        signInPage.enterPassword(password);
        blogPage = signInPage.clickOnSignin();
    }
}
