package ui.bbc_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

import java.time.Duration;

import static ui.constants.Constant.Values.PAUSE;

public class BbcFinishRegPage extends BaseSeleniumPage {
    @FindBy(xpath = "//label[@for='optOut']")
    private WebElement noBtn;
    @FindBy(xpath = "//button[@id='submit-button']")
    private WebElement finishBtn;
    Actions actions = new Actions(driver);
    public BbcFinishRegPage (){
        PageFactory.initElements(driver,this);
    }
    public BbcFinishRegPage finishReg(){
        actions
                .moveToElement(noBtn)
                .click()
                .moveToElement(finishBtn)
                .click()
                .pause(Duration.ofSeconds(PAUSE))
                .build()
                .perform();
        return this;
    }
    public String getMainPageTitle(){
        return driver.getTitle();
    }
}
