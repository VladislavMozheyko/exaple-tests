package ui.bbc_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

public class BbcCheckAgePage extends BaseSeleniumPage {
    @FindBy(xpath = "//a[@data-bbc-result='/register/details/age']")
    private WebElement over16Btn;
    Actions actions=new Actions(driver);
    public BbcCheckAgePage (){
        PageFactory.initElements(driver,this);
    }
    public String getBbcRegisterTitle(){
        return driver.getTitle();
    }
}
