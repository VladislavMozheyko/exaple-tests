package tests.ui.selenide_apple_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.core.BaseSelenideTest;
import ui.apple_page.AppleHomePage;
import ui.apple_page.AppleSearchPage;

import static ui.constants.Constant.Urls.APPLE_HOME;
import static ui.constants.Constant.Values.APPLE_SEARCH;
import static ui.constants.Constant.Values.CONTAINS_APPLE;

public class AppleTest extends BaseSelenideTest {
    @Test
    public void checkHref() {

        AppleHomePage appleHomePage = new AppleHomePage(APPLE_HOME);
        appleHomePage.clickSearch(APPLE_SEARCH);
        AppleSearchPage appleSearchPage = new AppleSearchPage();
        String href = appleSearchPage.getHrefFromFirstArticle();
        Assertions.assertTrue(href.contains(CONTAINS_APPLE));
    }
}
