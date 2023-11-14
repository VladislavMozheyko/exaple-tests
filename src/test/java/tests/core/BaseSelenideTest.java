package tests.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseSelenideTest {
    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "2736x1824";
        Configuration.headless = false;

    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
