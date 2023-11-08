package ui.bbc_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

import java.time.Duration;

import static ui.constants.Constant.Values.*;

public class BbcFillAgePage extends BaseSeleniumPage {
    @FindBy(xpath = "//input[@id='day-input']")
    private WebElement fillDay;
    @FindBy(xpath = "//input[@id='month-input']")
    private WebElement fillMonth;
    @FindBy(xpath = "//input[@id='year-input']")
    private WebElement fillYear;
    @FindBy(xpath = "//button[@id='submit-button']")
    private WebElement continueBtn;
    Actions actions = new Actions(driver);

    public BbcFillAgePage() {
        PageFactory.initElements(driver, this);
    }

    public BbcFillAgePage fillData() {
        actions.pause(Duration.ofSeconds(PAUSE))
                .moveToElement(fillDay)
                .click()
                .sendKeys(DAY)
                .moveToElement(fillMonth)
                .click()
                .sendKeys(MONTH)
                .moveToElement(fillYear)
                .click()
                .sendKeys(YEAR)
                .moveToElement(continueBtn)
                .click().pause(Duration.ofSeconds(PAUSE))
                .build().perform();
        return this;
    }
    public String getUserDataTitle(){
        return driver.getTitle();
    }
}
