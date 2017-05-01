package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver, String pagetitle) {
        this.driver=driver;
        FluentWait wait = new FluentWait(driver)
                .withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.titleIs(pagetitle));
    }

    protected void waitForElementVisible(WebElement element, int duration){
        FluentWait wait = new FluentWait(driver)
                .withTimeout(duration,TimeUnit.SECONDS)
                .pollingEvery(2,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementVisibleText(WebElement element, int duration, String text){
        FluentWait wait = new FluentWait(driver)
                .withTimeout(duration,TimeUnit.SECONDS)
                .pollingEvery(2,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    protected void waitForElementClickable(WebElement element, int duration){
        FluentWait wait = new FluentWait(driver)
                .withTimeout(duration,TimeUnit.SECONDS)
                .pollingEvery(2,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForFrameAvailableAndSwitch(WebElement element, int duration){
        FluentWait wait = new FluentWait(driver)
                .withTimeout(duration,TimeUnit.SECONDS)
                .pollingEvery(2,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    protected void enterText(WebElement element, String text){
        element.sendKeys(text);
    }

    protected void clickOn(WebElement element){
        element.click();
    }

    protected void selectFromDropDown(Select element, String visibleText){
        element.selectByVisibleText(visibleText);
    }


    public String getPageTitle(){
        return driver.getTitle();
    }
}
