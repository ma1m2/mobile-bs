package msl.qa.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import msl.qa.config.RealConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class RealDriver implements WebDriverProvider {

  private final RealConfig cfg = ConfigFactory.create(RealConfig.class, System.getProperties());

  @Nonnull
  @Override
  public WebDriver createDriver(@Nonnull Capabilities capabilities) {
    UiAutomator2Options options = new UiAutomator2Options();

    options.setAutomationName(ANDROID_UIAUTOMATOR2)
            .setPlatformName(ANDROID)
            .setPlatformVersion(cfg.platformVersion())
            .setDeviceName(cfg.deviceName())
            .setUdid(cfg.udid())
            .setApp(getAppPath())
            .setAppPackage(cfg.appPackage())
            .setAppActivity(cfg.appActivity())
            .setNoReset(false)//Сбрасывает приложение к состоянию "после первой установки"
            .setSkipServerInstallation(true)//Пропускает установку APK-файлов сервера Appium
            .setAutoGrantPermissions(true);

    return new AndroidDriver(cfg.url(), options);
  }

  private String getAppPath() {
    String appVersion = "app-alpha-universal-release.apk";
    String appUrl = "https://github.com/wikimedia/apps-android-wikipedia" +
            "/releases/download/latest/" + appVersion;
    String appPath = "src/test/resources/apps/" + appVersion;

    File app = new File(appPath);
    if (!app.exists()) {
      try (InputStream in = new URL(appUrl).openStream()) {
        copyInputStreamToFile(in, app);
      } catch (IOException e) {
        throw new AssertionError("Failed to download application", e);
      }
    }
    return app.getAbsolutePath();
  }

}
