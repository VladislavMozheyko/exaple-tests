package ui.bbc_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

import java.time.Duration;

import static ui.constants.Constant.Values.PAUSE;

public class BbcHomePage extends BaseSeleniumPage {
    @FindBy(xpath = "//a[@id='idcta-link']")
    private WebElement signInBtn;
    Actions actions=new Actions(driver);

    public BbcHomePage() {
        PageFactory.initElements(driver, this);
    }

    public BbcHomePage openSignIn() {
        actions
                .moveToElement(signInBtn)
                .pause(Duration.ofSeconds(PAUSE))
                .click()
                .pause(Duration.ofSeconds(PAUSE))
                .build().perform();
        return this;
    }

    public String signInTitle() {
        return driver.getTitle();
    }
}
