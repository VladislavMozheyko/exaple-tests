package tests.ui.bbc_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.core.BaseSeleniumTest;
import ui.bbc_page.BbcAccountPage;
import ui.bbc_page.BbcCheckAgePage;
import ui.bbc_page.BbcHomePage;

import static ui.constants.Constant.Titles.BBC_REGISTER_TITLE;
import static ui.constants.Constant.Titles.BBC_SIGNIN_TITLE;
import static ui.constants.Constant.Urls.BBC_HOME;

public class BbcTest extends BaseSeleniumTest {
    @Test
    public void successUserReg(){
        BbcHomePage bbcHomePage= new BbcHomePage();
        BbcAccountPage bbcAccountPage = new BbcAccountPage();
        BbcCheckAgePage bbcCheckAgePage=new BbcCheckAgePage();

        bbcHomePage.openUrl(BBC_HOME);
        bbcHomePage.openSignIn();
        Assertions.assertEquals(BBC_SIGNIN_TITLE,bbcHomePage.signInTitle());
        bbcAccountPage.clickRegisterNow();
        Assertions.assertEquals(BBC_REGISTER_TITLE,bbcAccountPage.getOver16Title());
    }
}
