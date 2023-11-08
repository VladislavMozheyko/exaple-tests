package ui.pages.heroku_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

import static ui.constants.Constant.Urls.HEROKU_HOME;

public class HerokuHomePage extends BaseSeleniumPage {
    @FindBy(xpath = "//a[@class='sign-up highlight']")
    private WebElement signIn;
    @FindBy(xpath = "//dx-helmet[@title='Salesforce Developers']")
    private WebElement titleSignIn;
    private String signInTitle = driver.getTitle();

    public HerokuHomePage() {
        PageFactory.initElements(driver, this);
    }

    public HerokuHomePage pressSignIn() {
        waitElementIsVisible(signIn).click();
        return this;
    }

    public String getSignInTitle() {
        return driver.getTitle();

    }
}
