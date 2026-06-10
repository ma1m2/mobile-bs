package msl.qa.tests.local;

import msl.qa.tests.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@EnabledIfSystemProperty(named = "deviceHost", matches = "emulator|real")
public class WikiSearchTest extends TestBase {

  @Test
  void successfulSearchTest(){
    back();

    step("Type search", () -> {
      $$(id("org.wikipedia.alpha:id/navigation_bar_item_small_label_view")).findBy(text("Search")).click();
      $(id("org.wikipedia.alpha:id/search_card")).click();
      $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
    });

    step("Verify content found", () -> {
      $$(".android.view.View")
              .shouldHave(sizeGreaterThan(0));
    });

  }
}
