package tests.ui.selenide_apple_test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.core.BaseSelenideTest;
import ui.apple_page.AppleHomePage;
import ui.apple_page.AppleSearchPage;

import static io.qameta.allure.Allure.step;
import static ui.constants.Constant.Urls.APPLE_HOME;
import static ui.constants.Constant.Values.APPLE_SEARCH;
import static ui.constants.Constant.Values.CONTAINS_APPLE;

public class AppleTest extends BaseSelenideTest {
    @Test
    public void checkHref() {
        AppleHomePage appleHomePage = new AppleHomePage();
        step("Открываем главную страницу", () -> {
            appleHomePage.openUrl(APPLE_HOME);
        });
        step("Ввводим в окно поиска " + APPLE_SEARCH + " и нажимаем ENTER", () -> {
            appleHomePage.clickSearch(APPLE_SEARCH);
        });

        AppleSearchPage appleSearchPage = new AppleSearchPage();
        step("Проверяем что первая href ссылка содержит " + CONTAINS_APPLE, () -> {
            String href = appleSearchPage.getHrefFromFirstArticle();
            Assertions.assertTrue(href.contains(CONTAINS_APPLE));
        });
    }
}
