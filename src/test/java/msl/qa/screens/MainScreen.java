package msl.qa.screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import msl.qa.helpers.Attach;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class MainScreen {

  private final SelenideElement searchBtn = $$(id("org.wikipedia.alpha:id/navigation_bar_item_small_label_view")).findBy(text("Search"));
  private final SelenideElement searchCard = $(id("org.wikipedia.alpha:id/search_card"));

  @Step("Click on Search Button on Navigation Bar")
  public MainScreen activateSearchCard() {
    searchBtn.click();
    Attach.screenshotAs("Search Button on Navigation Bar");
    return this;
  }

  @Step("Click on Search Line to activate Search Field")
  public SearchFieldScreen activateSearchField() {
    searchCard.click();
    Attach.screenshotAs("Search Line to activate Search Field");
    return new SearchFieldScreen();
  }

}
