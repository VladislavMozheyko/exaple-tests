package tests.ui.heroku_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.core.BaseSeleniumTest;
import ui.pages.heroku_page.HerokuHomePage;
import ui.pages.heroku_page.HerokuSignInPage;

import static ui.constants.Constant.Titles.HEROKU_SIGNIN_TITLE;
import static ui.constants.Constant.Urls.HEROKU_HOME;
import static ui.constants.Constant.Values.*;

public class HerokuTest extends BaseSeleniumTest {
    @Test
    public void registerUserFail() {
        HerokuHomePage herokuHomePage = new HerokuHomePage();
        HerokuSignInPage herokuSignInPage = new HerokuSignInPage();
        herokuHomePage
                .openUrl(HEROKU_HOME);
        herokuHomePage
                .pressSignIn();
        Assertions.assertEquals(HEROKU_SIGNIN_TITLE, herokuHomePage.getSignInTitle());
        herokuSignInPage.createUser(FIRST_NAME, LAST_NAME, EMAIL, COMPANY_NAME);


    }
}
