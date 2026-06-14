package msl.qa.screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import msl.qa.helpers.Attach;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SearchFieldScreen {

  private final SelenideElement searchField = $(id("org.wikipedia.alpha:id/search_src_text"));
  private final SelenideElement emptyImage = $(id("org.wikipedia.alpha:id/search_empty_image"));
  private final SelenideElement emptyMessage = $(id("org.wikipedia.alpha:id/search_empty_message"));
  private final String text = "Search Wikipedia in more languages";
  private final SelenideElement languages_button = $(id("org.wikipedia.alpha:id/add_languages_button"));

  @Step("Type '{word}' in Search Field")
  public SearchResultScreen search(String word) {
    searchField.sendKeys(word);
    Attach.screenshotAs("Search Field");
    return new SearchResultScreen();
  }

}
