package msl.qa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class WikiSearchTests  extends TestBase{

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

    step("Verify content found", () -> {
      $(id("pcs-edit-section-title-description")).shouldHave(text("General-purpose programming language"));
    });

  }
}
