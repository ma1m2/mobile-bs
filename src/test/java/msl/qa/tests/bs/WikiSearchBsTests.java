package msl.qa.tests.bs;

import msl.qa.tests.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@EnabledIfSystemProperty(named = "deviceHost", matches = "browserstack")
public class WikiSearchBsTests extends TestBase {

  @Test
  void successfulSearchTest(){

    step("Type search", () -> {
      $(id("org.wikipedia.alpha:id/search_container")).click();
      $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
    });

    step("Verify content found", () -> {
      $$(id("org.wikipedia.alpha:id/page_list_item_title"))
              .shouldHave(sizeGreaterThan(0));
    });

  }

  @Test
  void openArticleInResultSearchTest(){

    step("Type search", () -> {
      $(id("org.wikipedia.alpha:id/search_container")).click();
      $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Kotlin");
    });

    step("Open first article of list", () -> {
      $$(id("org.wikipedia.alpha:id/page_list_item_image")).stream().findFirst().get().click();
    });

    step("Error icon is displayed", () -> {
      $(id("org.wikipedia.alpha:id/view_wiki_error_icon")).should(exist);
    });

  }
}
