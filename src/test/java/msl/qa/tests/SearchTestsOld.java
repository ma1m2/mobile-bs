package msl.qa.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class SearchTestsOld {
  /*
  Could not start a new session.
  Possible causes are invalid address of the remote server or browser start-up failure.
Host info: host: 'DESKTOP-VSRD44A', ip: '192.168.0.17'
   */
  @Test
  void successfulSearchTest() throws InterruptedException, MalformedURLException {

    DesiredCapabilities caps = new DesiredCapabilities();

    // Set your access credentials
    caps.setCapability("browserstack.user", "svetlanamazhayki_cEelZU");
    caps.setCapability("browserstack.key", "EzCqTygq41dh7kqwamet");

    // Set URL of the application under test
    caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

    // Specify device and os_version for testing
    caps.setCapability("device", "Samsung Galaxy S22 Ultra");
    caps.setCapability("os_version", "12.0");

    // Set other BrowserStack capabilities
    caps.setCapability("project", "First Java Project");
    caps.setCapability("build", "browserstack-build-1");
    caps.setCapability("name", "first_test");


    // Initialise the remote Webdriver using BrowserStack remote URL
    // and desired capabilities defined above
    RemoteWebDriver driver = new RemoteWebDriver(
            new URL("https://hub.browserstack.com/wd/hub"), caps);

    // Test case for the BrowserStack sample Android app.
    // If you have uploaded your app, update the test case here.
    WebElement searchElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(120)).until(
            ExpectedConditions.elementToBeClickable(
                    AppiumBy.accessibilityId("Search Wikipedia")));
    searchElement.click();
    WebElement insertTextElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(60)).until(
            ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("org.wikipedia.alpha:id/search_src_text")));
    insertTextElement.sendKeys("Appium");
    Thread.sleep(5000);
    List<WebElement> allProductsName = driver.findElements(AppiumBy.className(
            "android.widget.TextView"));
    assert (allProductsName.size() > 0);


    // Invoke driver.quit() after the test is done to indicate that the test is completed.
    driver.quit();

  }
}
