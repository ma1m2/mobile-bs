package msl.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import msl.qa.drivers.BrowserstackDriver;
import msl.qa.drivers.EmulatorDriver;
import msl.qa.drivers.RealDriver;
import msl.qa.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

  private static String deviceHost;

  @BeforeAll
  public static void setupEnvironment() {
    deviceHost = System.getProperty("deviceHost", "real");
    Configuration.browser = getDriverClass(deviceHost);
    Configuration.browserSize = null;
    Configuration.timeout = 30000;
  }

  @BeforeEach
  public void addListenerAndOpen() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    open();
  }

  @AfterEach
  public void addAttachments() {
    boolean isBS = "browserstack".equalsIgnoreCase(deviceHost);
    String sessionId = isBS ? Selenide.sessionId().toString() : null;

    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    closeWebDriver();

    if (isBS) Attach.addVideo(sessionId);
  }

  private static String getDriverClass(String deviceHost) {
    return switch (deviceHost.toLowerCase()) {
      case "browserstack" -> BrowserstackDriver.class.getName();
      case "real" -> RealDriver.class.getName();
      case "emulator" -> EmulatorDriver.class.getName();
      default -> throw new IllegalArgumentException("Unknown deviceHost: " + deviceHost);
    };
  }
}
