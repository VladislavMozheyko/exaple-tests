package ui.bbc_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

public class BbcHomePage extends BaseSeleniumPage {
    @FindBy(xpath = "//a[@id='idcta-link']")
    private WebElement signInBtn;

    public BbcHomePage() {
        PageFactory.initElements(driver, this);
    }

    public BbcHomePage openSignIn() {
        waitElementIsVisible(signInBtn).click();
        return this;
    }

    public String signInTitle() {
        return driver.getTitle();
    }
}
