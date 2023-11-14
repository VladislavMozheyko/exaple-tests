package ui.apple_page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Description;

import static com.codeborne.selenide.Selenide.$x;

public class AppleHomePage {
    private final SelenideElement searchBtn = $x("//input[@value]");

    /**
     * Не кликабельный элемент. Передаем значение через value.
     */
    public void clickSearch(String search) {
        searchBtn.setValue(search);
        searchBtn.pressEnter();
    }

    public AppleHomePage() {
    }

    public void openUrl(String url) {

        Selenide.open(url);
    }
}
