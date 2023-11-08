package ui.bbc_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

import java.time.Duration;

import static ui.constants.Constant.Values.PAUSE;

public class BbcCheckAgePage extends BaseSeleniumPage {
    @FindBy(xpath = "//a[@data-bbc-result='/register/details/age']")
    private WebElement over16Btn;
    Actions actions = new Actions(driver);

    public BbcCheckAgePage() {
        PageFactory.initElements(driver, this);
    }

    public BbcCheckAgePage clickOver16Btn() {
        actions.moveToElement(over16Btn)
                .pause(Duration.ofSeconds(PAUSE))
                .click()
                .build().perform();
        actions.pause(Duration.ofSeconds(PAUSE))
                .build().perform();
        return this;
    }

    public String getBbcRegisterTitle() {
        return driver.getTitle();
    }
}
