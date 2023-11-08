package ui.bbc_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

public class BbcAccountPage extends BaseSeleniumPage {
    @FindBy(xpath = "//a[@data-bbc-result='/register']")
    private WebElement registerNowBtn;
    public BbcAccountPage(){
        PageFactory.initElements(driver,this);
    }
    public BbcAccountPage clickRegisterNow(){
        waitElementIsVisible(registerNowBtn).click();
        return this;
    }
}
