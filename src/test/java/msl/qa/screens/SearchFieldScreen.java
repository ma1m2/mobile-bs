package msl.qa.screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.appium.java_client.AppiumBy.id;

public class SearchFieldScreen {

  private SelenideElement searchField = $(id("org.wikipedia.alpha:id/search_src_text"));
  private SelenideElement emptyImage = $(id("org.wikipedia.alpha:id/search_empty_image"));

  private SelenideElement emptyMessage = $(id("org.wikipedia.alpha:id/search_empty_message"));
  private String text = "Search Wikipedia in more languages";

  private SelenideElement languages_button = $(id("org.wikipedia.alpha:id/add_languages_button"));

  public void search(String word) {
    searchField.setValue(word).click();
  }

}
