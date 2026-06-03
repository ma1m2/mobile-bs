package msl.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/bs.properties"
})
public interface BsConfig extends Config{

  @Key("userName")
  String userName();

  @Key("accessKey")
  String accessKey();

  @Key("url")
  String url();

  @Key("app")
  String app();
}
