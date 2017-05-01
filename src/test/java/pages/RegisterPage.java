package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends Page{
    public RegisterPage(WebDriver driver) {
        super(driver, "BBC – Register");
    }

    @FindBy(id = "day-input")
    private WebElement day_dateofbirth;

    @FindBy(id = "month-input")
    private WebElement month_dateofbirth;

    @FindBy(id = "year-input")
    private WebElement year_dateofbirth;

    @FindBy(id = "submit-button")
    private WebElement nextButton;

    public void enterDayofDateOfBirth(String day){
        enterText(day_dateofbirth,day);
    }

    public void enterMonthofDateOfBirth(String month){
        enterText(month_dateofbirth,month);
    }

    public void enterYearofDateOfBirth(String year){
        enterText(year_dateofbirth,year);
    }

    public NextRegisterPage clickOnNextButton(){
        clickOn(nextButton);
        return PageFactory.initElements(driver,NextRegisterPage.class);
    }
}
