package msl.qa.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
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
  void findJavaSearchTest(){

    step("Type search", () -> {
      $(id("org.wikipedia.alpha:id/search_container")).click();
      $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
    });

    step("Open first article of list", () -> {
      //List<SelenideElement> list = $$(id("org.wikipedia.alpha:id/page_list_item_title")).stream().toList();
      $$(id("org.wikipedia.alpha:id/page_list_item_image")).stream().findFirst().get().click();
    });

/*    step("Verify content found", () -> {
      $(id("pcs-edit-section-title-description")).shouldHave(Condition.text("Island and region in Indonesia"));
    });*/

  }
}
