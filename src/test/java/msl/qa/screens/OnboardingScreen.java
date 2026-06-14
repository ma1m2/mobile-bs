package msl.qa.screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import msl.qa.helpers.Attach;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;


public class OnboardingScreen {
  private final ElementsCollection content = $$(".android.widget.TextView");
  private final SelenideElement forwardBtn = $(".android.widget.Button");
  private final SelenideElement nextBtn = $x("//android.view.View[@content-desc=\"Next\"]");
  private final SelenideElement skipBtn = $x("//android.widget.TextView[@text=\"Skip\"]");

  private final String firstScreen = "All the world's knowledge";
  private final String secondScreen = "Data & Privacy";
  private final String thirdScreen = "Read in more than 300 languages";
  private final String fourthScreen = "Follow your curiosity";

  @Step("Go Forward next Onboarding Screen")
  public OnboardingScreen goForwardOnboardingScreen() {
    forwardBtn.click();
    return this;
  }

  @Step("Go to Article List Screen")
  public ArticleListScreen goToArticleListScreen() {
    nextBtn.click();
    return new ArticleListScreen();
  }

  @Step("Check text on the First Onboarding screen")
  public OnboardingScreen checkFirstOnboardingScreen() {
    checkOnboardingScreen(firstScreen);
    Attach.screenshotAs("First Onboarding screen");
    return this;
  }

  @Step("Check text on the Second Onboarding screen")
  public OnboardingScreen checkSecondOnboardingScreen() {
    checkOnboardingScreen(secondScreen);
    Attach.screenshotAs("Second Onboarding screen");
    return this;
  }

  @Step("Check text on the Third Onboarding screen")
  public OnboardingScreen checkThirdOnboardingScreen() {
    checkOnboardingScreen(thirdScreen);
    Attach.screenshotAs("Third Onboarding screen");
    return this;
  }

  @Step("Check text on the Fourth Onboarding screen")
  public OnboardingScreen checkFourthOnboardingScreen() {
    checkOnboardingScreen(fourthScreen);
    Attach.screenshotAs("Fourth Onboarding screen");
    return this;
  }

  private void checkOnboardingScreen(String text) {
    content.findBy(text(text));
  }

}
