package msl.qa.helpers;

import static io.restassured.RestAssured.given;

public class Browserstack {

 // curl -u "svetlanamazhayki_cEelZU:EzCqTygq41dh7kqwamet" -X GET "https://api-cloud.browserstack.com/app-automate/sessions/<session-id>.json"
  //automation_session.video_url

  public static String videoUrl(String sessionId) {
    String url = String.format("https://api-cloud.browserstack.com/app-automate/sessions/%s.json", sessionId);

    return given()
            .log().all()
            .auth().basic("svetlanamazhayki_cEelZU", "EzCqTygq41dh7kqwamet")
            .get(url)
            .then()
            .log().status()
            .log().body()
            .statusCode(200)
            .extract().path("automation_session.video_url");
  }
}
