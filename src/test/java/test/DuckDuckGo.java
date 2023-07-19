package test;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class DuckDuckGo {

    @Step("open page")
    public static void openMainPage() {
        Selenide.open("https://duckduckgo.com");
    }
}
