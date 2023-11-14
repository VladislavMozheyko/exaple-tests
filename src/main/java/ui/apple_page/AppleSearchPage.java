package ui.apple_page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AppleSearchPage {
    private final ElementsCollection articleTitles = $$x("//h2//a");

    /**
     * Возвращает href из первой статьи.
     */
    public String getHrefFromFirstArticle(){
        return articleTitles.first().getAttribute("href");
    }
}
