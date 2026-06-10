package msl.qa.helpers;

import msl.qa.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {

  // curl -u "testikarus_koaKq0:cE78m2zFxvVLGpUm2jdM" -X GET "https://api-cloud.browserstack.com/app-automate/sessions/<session-id>.json"
  //automation_session.video_url

  private static final BrowserstackConfig cfg = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

  public static String videoUrl(String sessionId) {
    String url = String.format("https://api-cloud.browserstack.com/app-automate/sessions/%s.json", sessionId);

    return given()
            .log().all()
            .auth().basic(cfg.userName(), cfg.accessKey())
            .get(url)
            .then()
            .log().status()
            .log().body()
            .statusCode(200)
            .extract().path("automation_session.video_url");
  }
}
