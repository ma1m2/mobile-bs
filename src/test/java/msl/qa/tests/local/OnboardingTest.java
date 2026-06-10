package msl.qa.tests.local;

import msl.qa.screens.OnboardingScreen;
import msl.qa.tests.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

@EnabledIfSystemProperty(named = "deviceHost", matches = "emulator|real")
public class OnboardingTest extends TestBase {

  OnboardingScreen os = new OnboardingScreen();

  @Test
  void onboardingTest(){
    os.checkFirstOnboardingScreen()
            .goForwardOnboardingScreen()
            .checkSecondOnboardingScreen()
            .goForwardOnboardingScreen()
            .checkThirdOnboardingScreen()
            .goForwardOnboardingScreen()
            .checkFourthOnboardingScreen()
            .goToArticleListScreen()
            .checkTitleOfArticleListScreen();
  }

}
