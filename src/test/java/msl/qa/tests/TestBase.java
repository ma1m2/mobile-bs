package msl.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import msl.qa.drivers.BrowserstackDriver;
import msl.qa.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

  @BeforeAll
  public static void beforeClass() {
    Configuration.browser = BrowserstackDriver.class.getName();
    Configuration.browserSize = null;
    Configuration.timeout = 30000;
  }

  @BeforeEach
  public void beforeEach() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    open();
  }

  @AfterEach
  public void addAttachments() {
    String sessionId = Selenide.sessionId().toString();
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    closeWebDriver();
    Attach.addVideo(sessionId);
  }
}
