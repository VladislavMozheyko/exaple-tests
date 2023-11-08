package ui.bbc_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

import java.time.Duration;

import static ui.constants.Constant.Values.PAUSE;

public class BbcCheckRegUser extends BaseSeleniumPage {
    @FindBy(xpath = "//a[@id='idcta-link']")
    private WebElement yourAccountBtn;
    @FindBy(xpath = "//a[@href='/account/settings'][@class='link link--primary primary-nav__link']")
            private WebElement settingsBtn;
    @FindBy(xpath = "//div[@class='field__input'][1]")
            private WebElement userEmail;
    Actions actions= new Actions(driver);
    public BbcCheckRegUser(){
        PageFactory.initElements(driver,this);
    }
    public BbcCheckRegUser checkUserReg(){
        actions
                .pause(Duration.ofSeconds(PAUSE))
                .moveToElement(yourAccountBtn)
                .click()
                .build().perform();
        actions
                .pause(Duration.ofSeconds(PAUSE))
                .moveToElement(settingsBtn)
                .click()
                .pause(Duration.ofSeconds(PAUSE))
                .build().perform();
        return this;
    }
    public String getUserEmail(){
        return userEmail.getText();
    }
}
