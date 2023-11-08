package tests.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.core.BaseSeleniumPage;


import java.beans.Visibility;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static ui.constants.Constant.TimeOutVariable.IMPLICIT_WAIT;
import static ui.constants.Constant.TimeOutVariable.PAGE_LOAD_WAIT;

public class BaseSeleniumTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        BaseSeleniumPage.setDriver(driver);
    }


    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

