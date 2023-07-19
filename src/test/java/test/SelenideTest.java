package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static pageObjects.DuckDuckGoMainPage.searchField;
import static test.DuckDuckGo.openMainPage;


@Epic("test.DuckDuckGo Tests")
@Feature("Search Feature")
@Story("Basic search functionality")
@Severity(SeverityLevel.MINOR)
@Owner("TesterName")
@Tags({@Tag("web"), @Tag("mobile")})
public class SelenideTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }


    @Test()
    @DisplayName("test.DuckDuckGo basic search test")
    @Description("In this cool test we will use test.DuckDuckGo search")
    @Link(name = "Test Case", url = "url_to_your_test_case_in_test_management_tool")
    @Issue("issue_id_in_bug_tracking_system")
    public void searchTest() {
        Selenide.open("https://duckduckgo.com");

        // Find search box and type query
        searchField.setValue("Selenide").pressEnter();

        // Assert that search results contain expected text
        $$("div.web-result").first().shouldHave(text("selenide.org"));

        // Attach screenshot
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES)));

        // Attach page source
        Allure.addAttachment("Html source", WebDriverRunner.getWebDriver().getPageSource());
    }

    @Test()
    @DisplayName("test.DuckDuckGo basic search test")
    @Description("In this cool test we will use test.DuckDuckGo search")
    @Link(name = "Test Case", url = "url_to_your_test_case_in_test_management_tool")
    @Issue("issue_id_in_bug_tracking_system")
    public void searchTestLambda() {

        step("Открыть страницу ",()->{
            Selenide.open("https://duckduckgo.com");
        });
        step("Дать полю поиск значение",()->{
            searchField.setValue("Selenide").pressEnter();
        });
        step("Проверить результат",()->{
            $$("div.web-result").first().shouldHave(text("selenide.org"));
        });

        // Attach screenshot
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES)));

        // Attach page sourcegit remote add origin https://github.com/QABoost/AllureBeauty.git
        Allure.addAttachment("Html source", WebDriverRunner.getWebDriver().getPageSource());
    }
    @Test()
    @DisplayName("test.DuckDuckGo basic search test")
    @Description("In this cool test we will use test.DuckDuckGo search")
    @Link(name = "Test Case", url = "url_to_your_test_case_in_test_management_tool")
    @Issue("issue_id_in_bug_tracking_system")
    public void searchTestWebStep() {


        openMainPage();

        step("Дать полю поиск значение",()->{
            searchField.setValue("Selenide").pressEnter();
        });
        step("Проверить результат",()->{
            $$("div.web-result").first().shouldHave(text("selenide.org"));
        });

        // Attach screenshot
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES)));

        // Attach page source
        Allure.addAttachment("Html source", WebDriverRunner.getWebDriver().getPageSource());
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
