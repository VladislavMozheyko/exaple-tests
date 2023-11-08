package tests.ui.bbc_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.core.BaseSeleniumTest;
import ui.bbc_page.*;
import ui.constants.StringModifier;

import static ui.constants.Constant.Titles.*;
import static ui.constants.Constant.Urls.BBC_HOME;
import static ui.constants.Constant.Values.*;

public class BbcTest extends BaseSeleniumTest {
    @Test
    public void successUserReg() {
        BbcHomePage bbcHomePage = new BbcHomePage();
        BbcAccountPage bbcAccountPage = new BbcAccountPage();
        BbcCheckAgePage bbcCheckAgePage = new BbcCheckAgePage();
        BbcFillAgePage bbcFillAgePage = new BbcFillAgePage();
        BbcRegUserPage bbcRegUserPage = new BbcRegUserPage();

        bbcHomePage.openUrl(BBC_HOME);
        bbcHomePage.openSignIn();
        Assertions.assertEquals(BBC_SIGNIN_TITLE, bbcHomePage.signInTitle());
        bbcAccountPage.clickRegisterNow();
        Assertions.assertEquals(BBC_REGISTER_TITLE, bbcAccountPage.getOver16Title());
        bbcCheckAgePage.clickOver16Btn();
        Assertions.assertEquals(BBC_DATA_TITLE, bbcCheckAgePage.getBbcRegisterTitle());
        bbcFillAgePage.fillData();
        Assertions.assertEquals(BBC_REG_USER_TITLE, bbcFillAgePage.getUserDataTitle());
        bbcRegUserPage.fillUserData(FIRST_NAME+"@mail.ru",PASSWORD);
        Assertions.assertEquals(BBC_SUCCESS_REG_TITLE,bbcRegUserPage.getConfirmRegTitle());
    }
}
