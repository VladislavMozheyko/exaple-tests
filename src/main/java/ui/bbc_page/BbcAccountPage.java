package ui.bbc_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

import java.time.Duration;

import static ui.constants.Constant.Values.PAUSE;

public class BbcAccountPage extends BaseSeleniumPage {
    @FindBy(xpath = "//a[@data-bbc-result='/register']")
    private WebElement registerNowBtn;
    Actions actions=new Actions(driver);
    public BbcAccountPage(){
        PageFactory.initElements(driver,this);
    }
    public BbcAccountPage clickRegisterNow(){
        actions.moveToElement(registerNowBtn)
                .pause(Duration.ofSeconds(PAUSE))
                .click()
                .pause(Duration.ofSeconds(PAUSE))
                .build().perform();
        return this;
    }
    public String getOver16Title(){
        return driver.getTitle();
    }
}
