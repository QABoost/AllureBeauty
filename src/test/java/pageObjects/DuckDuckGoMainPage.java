package pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DuckDuckGoMainPage {

    public static SelenideElement searchField=$("input[name='q']");
    public static final SelenideElement SEARCH_FIELD_ON_GENERAL_PAGE=$("input[name='q']");

    public static SelenideElement searchField(){
        if(searchField.isDisplayed()){
            return  $("input[name='q']");
        }
      return  $("input[name='q']");
    }
}
