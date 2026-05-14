package msl.qa.tests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchTestsWithDeepSeek {
/*  Could not start a new session. Possible causes are invalid address of the remote server or browser start-up failure.
Host info: host: 'DESKTOP-VSRD44A', ip: '192.168.0.17'
org.openqa.selenium.SessionNotCreatedException: Could not start a new session.
Possible causes are invalid address of the remote server or browser start-up failure.*/

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

    caps.setCapability("bstack:options", bstackOptions);

    // Platform
    caps.setCapability("platformName", "Android");

    // Appium capabilities с ПУБЛИЧНЫМ приложением Wikipedia
    caps.setCapability("appium:app", "bs://9fg0rt302be241e6524ebc67253ecdee266343");
    // ИЛИ используйте прямой URL:
    // caps.setCapability("appium:app", "https://github.com/cloudgrey-io/appium-demo/raw/master/apps/WikipediaSample.apk");
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
              AppiumBy.className("android.widget.TextView"));
      assert (allProductsName.size() > 0);

    } finally {
      driver.quit();
    }
  }
}