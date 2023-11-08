package ui.pages.heroku_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

public class HerokuSignInPage extends BaseSeleniumPage {
    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='company']")
    private WebElement companyNameField;
    @FindBy(xpath = "//select[@id='role']")
    private WebElement role;
    @FindBy(xpath = "//select[@id='role']//option[@value='student']")
    private WebElement roleType;
    @FindBy(xpath = "//select[@id='self_declared_country']")
    private WebElement region;
    @FindBy(xpath = "//select[@id='self_declared_country']//option[@value='United States']")
    private WebElement regionUS;
    @FindBy(xpath = "//select[@id='main_programming_language']")
    private WebElement language;
    @FindBy(xpath = "//select[@id='main_programming_language']//option[@value='java']")
    private WebElement languageJava;
    @FindBy(xpath = "//input[@value='Create an Account']")
    private WebElement createAccount;
    @FindBy(xpath = "//p[@class='alert alert-error'][1]")
    private WebElement error;

    public HerokuSignInPage() {
        PageFactory.initElements(driver, this);
    }

    public HerokuSignInPage createUser(String userName, String lastName, String email, String companyName) {
        waitElementIsVisible(firstNameField).sendKeys(userName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        companyNameField.sendKeys(companyName);
        role.click();
        roleType.click();
        region.click();
        regionUS.click();
        language.click();
        languageJava.click();
        waitElementIsVisible(createAccount).click();
        return this;
    }
}
