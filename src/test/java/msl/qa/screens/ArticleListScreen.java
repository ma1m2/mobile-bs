package msl.qa.screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;

public class ArticleListScreen {
  private final SelenideElement searchLine = $x("//android.widget.TextView[@text=\"Search for an article\"]");
  private final SelenideElement title = $x("//android.widget.TextView[@text=\"What are you interested in?\"]");

  private final SelenideElement forwardBtn = $x("//android.view.View[@content-desc=\"Next\"]");
  private final SelenideElement skipBtn = $x("//android.widget.TextView[@text=\"Skip\"]");

  @Step("Check that we are on Article List screen")
  public void checkTitleOfArticleListScreen(){
    title.shouldHave(exist);
  }

}
