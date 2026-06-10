package msl.qa.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import msl.qa.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserstackDriver implements WebDriverProvider {

  private final BrowserstackConfig cfg = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

  @Override
  @Nonnull
  public WebDriver createDriver(@Nonnull Capabilities capabilities) {
    MutableCapabilities caps = new MutableCapabilities();

    // BrowserStack options
    Map<String, Object> bstackOptions = new HashMap<>();
    bstackOptions.put("userName", cfg.userName());
    bstackOptions.put("accessKey", cfg.accessKey());
    bstackOptions.put("projectName", "First Java Project");
    bstackOptions.put("buildName", "browserstack-build-1");
    bstackOptions.put("sessionName", "first_test");
    bstackOptions.put("appProfiling", "true");

    caps.setCapability("bstack:options", bstackOptions);

    // Platform
    caps.setCapability("platformName", "Android");

    // Appium capabilities с ПУБЛИЧНЫМ приложением Wikipedia
    caps.setCapability("appium:app", cfg.app());
    // ИЛИ используйте прямой URL github
    caps.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
    caps.setCapability("appium:platformVersion", "12.0");
    caps.setCapability("appium:automationName", "UiAutomator2");

    try {
      return new AndroidDriver(
              new URL(cfg.url()), caps);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }

  }
}
