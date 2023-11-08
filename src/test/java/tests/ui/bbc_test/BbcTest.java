package tests.ui.bbc_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.core.BaseSeleniumTest;
import ui.bbc_page.BbcAccountPage;
import ui.bbc_page.BbcHomePage;

import static ui.constants.Constant.Titles.BBC_SIGNIN_TITLE;
import static ui.constants.Constant.Urls.BBC_HOME;

public class BbcTest extends BaseSeleniumTest {
    @Test
    public void successUserReg(){
        BbcHomePage bbcHomePage= new BbcHomePage();
        BbcAccountPage bbcAccountPage = new BbcAccountPage();
        bbcHomePage.openUrl(BBC_HOME);
        bbcHomePage.openSignIn();
        Assertions.assertEquals(BBC_SIGNIN_TITLE,bbcHomePage.signInTitle());
        bbcAccountPage.clickRegisterNow();
    }
}
