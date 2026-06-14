package msl.qa.tests.old;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.selenide.AllureSelenide;
import msl.qa.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@EnabledIfSystemProperty(named = "deviceHost", matches = "browserstack")
public class SearchOldWorkTests{

  @BeforeEach
  public void addListenerAndOpen() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    open();
  }

  @Test
  void successfulSearchTest() throws Exception {
    MutableCapabilities caps = new MutableCapabilities();

    // BrowserStack options
    Map<String, Object> bstackOptions = new HashMap<>();
    bstackOptions.put("userName", "testikarus_koaKq0");
    bstackOptions.put("accessKey", "cE78m2zFxvVLGpUm2jdM");
    bstackOptions.put("projectName", "First Java Project");
    bstackOptions.put("buildName", "browserstack-build-1");
    bstackOptions.put("sessionName", "first_test");
    bstackOptions.put("appProfiling", "true");

    caps.setCapability("bstack:options", bstackOptions);

    // Platform
    caps.setCapability("platformName", "Android");

    // Appium capabilities с ПУБЛИЧНЫМ приложением Wikipedia
    caps.setCapability("appium:app", "bs://sample.app");
    // ИЛИ используйте прямой URL github
    caps.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
    caps.setCapability("appium:platformVersion", "12.0");
    caps.setCapability("appium:automationName", "UiAutomator2");

    AndroidDriver driver = new AndroidDriver(
            new URL("https://hub.browserstack.com/wd/hub"), caps);

    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

      // Ждем загрузки приложения
      Thread.sleep(5000);

      // Пробуем разные локаторы для Wikipedia
      WebElement searchElement;
      try {
        searchElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Search Wikipedia")));
      } catch (Exception e) {
        // Альтернативный локатор
        searchElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.id("org.wikipedia.alpha:id/search_container")));
      }
      searchElement.click();

      WebElement insertTextElement = wait.until(
              ExpectedConditions.elementToBeClickable(
                      AppiumBy.id("org.wikipedia.alpha:id/search_src_text")));
      insertTextElement.sendKeys("Appium");

      Thread.sleep(5000);

      List<WebElement> allProductsName = driver.findElements(
              //AppiumBy.className("android.widget.TextView"));
              AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"));
      assert (allProductsName.size() > 0);

    } finally {
      driver.quit();
    }
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