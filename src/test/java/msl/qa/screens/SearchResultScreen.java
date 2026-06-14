package msl.qa.screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import msl.qa.helpers.Attach;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultScreen {

  //private final ElementsCollection searchResults = $$(".android.view.View");
  private final ElementsCollection searchResultsTextView = $$(".android.widget.TextView");

  @Step("Verify that content found")
  public void checkSearchResults() {
    searchResultsTextView.shouldHave(sizeGreaterThan(0));
    Attach.screenshotAs("searchResults");
  }

  @Step("Open first Article in Search Result")
  public ArticleScreen openedFirstSearchResults(String articleTitle) {
    searchResultsTextView.findBy(text(articleTitle)).click();
    Attach.screenshotAs("Open first Article");
    return new ArticleScreen();
  }

}
