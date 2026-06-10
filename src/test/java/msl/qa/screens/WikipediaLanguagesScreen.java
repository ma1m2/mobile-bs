package msl.qa.screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaLanguagesScreen {
  
  private SelenideElement title = $(id("//android.widget.TextView[@text=\"Wikipedia languages\"]"));
  private SelenideElement headerText = $(id("org.wikipedia.alpha:id/section_header_text"));
  private String text = "Your languages";

}
