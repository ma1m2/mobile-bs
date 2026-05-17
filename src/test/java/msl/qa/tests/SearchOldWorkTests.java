package msl.qa.tests;

import com.codeborne.selenide.Configuration;
import io.appium.java_client.android.AndroidDriver;
import msl.qa.drivers.BrowserstackDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchOldWorkTests{

  @Test
  void successfulSearchTest() throws Exception {
    MutableCapabilities caps = new MutableCapabilities();

    // BrowserStack options
    Map<String, Object> bstackOptions = new HashMap<>();
    bstackOptions.put("userName", "svetlanamazhayki_cEelZU");
    bstackOptions.put("accessKey", "EzCqTygq41dh7kqwamet");
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
}