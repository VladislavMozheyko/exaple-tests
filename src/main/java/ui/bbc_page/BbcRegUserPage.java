package ui.bbc_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

import java.time.Duration;

import static ui.constants.Constant.Values.*;

public class BbcRegUserPage extends BaseSeleniumPage {
    @FindBy(xpath = "//input[@id='user-identifier-input']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='password-input']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@id='submit-button']")
    private WebElement regBtn;
    Actions actions = new Actions(driver);

    public BbcRegUserPage() {
        PageFactory.initElements(driver, this);
    }

    public BbcRegUserPage fillUserData(String email, String password) {
        actions
                .moveToElement(emailField)
                .click()
                .sendKeys(email)
                .moveToElement(passwordField)
                .click()
                .sendKeys(password)
                .moveToElement(regBtn)
                .click()
                .pause(Duration.ofSeconds(PAUSE))
                .build().perform();
        return this;
    }

    public String getConfirmRegTitle() {
        return driver.getTitle();
    }
}
