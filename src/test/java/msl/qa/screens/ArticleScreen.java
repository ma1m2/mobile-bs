package msl.qa.screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static io.appium.java_client.AppiumBy.id;
import static com.codeborne.selenide.Selenide.$;

public class ArticleScreen {
  private final SelenideElement modalWindowCloseBtn = $(id("org.wikipedia.alpha:id/closeButton"));
  private final SelenideElement webView = $(id("org.wikipedia.alpha:id/page_web_view"));

  @Step("Verify that article opened")
  public void checkThatArticleOpend() {
    modalWindowCloseBtn.click();
    webView.shouldHave(exist);
  }

}