package msl.qa.config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({
        "classpath:config/emulator.properties"
})
public interface RealConfig extends Config{

  @Key("appium_server_url")
  @DefaultValue("http://localhost:4723/wd/hub")
  URL url();

  @Key("app")
  String app();

  @Key("platformVersion")
  String platformVersion();

  @Key("deviceName")
  String deviceName();

  @Key("appPackage")
  String appPackage();

  @Key("appActivity")
  String appActivity();
}
