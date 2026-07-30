# Demo Project for automating mobile tests for the [Wikipedia](https://ru.wikipedia.org/)  application  

<p align="center">
<a href="https://ru.wikipedia.org/"><img src="media/logo/WikiLogo.png" alt="Wikipedia" ></a>
</p>

> Wikipedia is a free, multilingual, general-interest online encyclopedia that operates on wiki principles.

## Contents:
____
* <a href="#tools">Technologies & Tools</a>

* <a href="#cases">Automated Test Scenarios</a>

* <a href="#setup">Environment Setup</a>

* <a href="#jenkins">Jenkins Build</a>

* <a href="#console">Running Tests (Terminal)</a>

* <a href="#allure">Allure Report</a>

* <a href="#allure-testops">Allure TestOps Integration</a>

* <a href="#jira">Jira Integration</a>

* <a href="#tg">Telegram Alerts</a>

* <a href="#video">BrowserStack Video Examples</a>
____
<a id="tools"></a>
## Technologies & Tools

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="media/logo/intellij-original.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="media/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://www.selenium.dev/"><img src="media/logo/selenuim.svg" width="50" height="50"  alt="Selenium"/></a>  
<a href="https://selenide.org/"><img src="media/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="media/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a> 
<a href="https://appium.io/docs/en/latest/"><img src="media/logo/appium.svg" width="50" height="50"  alt="Appium"/></a>  
<a href="https://developer.android.com/studio?hl=ru"><img src="media/logo/Android-studio.svg" width="50" height="50"  alt="Android-studio"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="media/logo/allure.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="media/logo/AllureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>
<a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="media/logo/Jira.svg" width="50" height="50"  alt="Jira"/></a>  
</p>


- Programming language: [Java](https://www.java.com/ru/)
- UI automation: [Selenide](https://selenide.org/)
- Test framework: [JUnit5](https://github.com/junit-team/junit5)
- Build system: [Gradle](https://gradle.org/)
- CI/CD: [Jenkins](https://www.jenkins.io/)
- Reporting: [Allure](https://github.com/allure-framework)
- Test run notifications: Telegram-bot
- Integration with  [Allure TestOps](https://qameta.io/)
- Integration with  [Jira Software](https://www.atlassian.com/software/jira)
___

<a id="#cases"></a>
## Automated Test Scenarios
### For local launch  

- Check Onboarding Screens
- Check successful Search Result
- Open first Search Result and check the article

### For remote launch
- Check successful Search Result
- Open article in Search Result and check Error icon.

____
<a id="setup"></a>
## Environment Setup  

**Start Appium Server**
```bash
appium server --base-path /wd/hub
```  
**Start the emulator**
```bash
emulator -avd Pixel_4 -gpu swiftshader_indirect
```  
**Check running devices**
```bash
adb devices
```

**Real Device Setup**  
Before running tests on a real Android device, configure it as follows: 
1. Enable Developer Options:
    - Go to **Settings** > **About phone** > tap **Build number** 7 times
    - Go back to **Settings** > **Advanced settings** > **Developer options**

2. Enable the following:
    - ✅ USB debugging
    - ✅ Install via USB
    - ✅ USB debugging (security settings)
    - ✅ Verify bytecode for debuggable apps

3. Disable the following:
    - ❌ Disable automatic ADB authorization revocation
    - ❌ Verify apps over USB

----
<a id="jenkins"></a>
## <img width="25" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> </a> Jenkins Build <a target="_blank" href="https://jenkins.qa.guru/job/C40-ma1m2-redsoft/"></a>
To access Jenkins, registration on the resource is required [Jenkins](https://jenkins.qa.guru/). 
To start the build, click the <code>Build Now</code> button.
____
<p align="center">  
<a href="https://jenkins.qa.guru/view/java-students/job/C40-ma1m2-mobile-bs/" target="_blank" rel="noopener noreferrer"><img src="media/screen/Jenkins2.png" alt="Jenkins" width="950"/></a>  
</p>


<a id="console"></a>
## Running Tests (Terminal)

**To run on different environments, pass from the command line:**
```bash
./gradlew clean test -DdeviceHost=browserstack
./gradlew clean test -DdeviceHost=emulator
./gradlew clean test -DdeviceHost=real
```  
**To run a single specific test**
```bash
./gradlew clean test -DdeviceHost=emulator --tests "msl.qa.tests.local.WikiSearchTest.successfulSearchWithScreenObjectTest"
```   
**or (if the test name is unique)**
```bash
./gradlew clean test -DdeviceHost=emulator --tests "*.successfulSearchWithScreenObjectTest"
```  
**For smoke tests**  
`./gradlew clean smokeTest -DdeviceHost=emulator`

___
<a id="allure"></a>
## <img alt="Allure" height="20" src="media/logo/allure.svg" width="20"/></a> <a name="Allure"></a>Allure [Report](https://jenkins.qa.guru/view/java-students/job/C40-ma1m2-mobile-bs/allure-report)</a>
___

### Overview page of Allure Report

<p align="center">  
<img title="Allure Overview Dashboard" src="media/screen/AllureOverview.png" width="850">  
</p>  

### Test-cases

<p align="center">  
<img title="Allure Tests" src="media/screen/AllureTests.png" width="850">  
</p>

### Graphs

  <p align="center">  
<img title="Allure Graphics" src="media/screen/Graphs.png" width="850">
</p>

___
<a id="allure-testops"></a>
## <img alt="Allure" height="25" src="media/logo/AllureTestOps.svg" width="25"/></a> Integration with <a target="_blank" href="https://allure.autotests.cloud/project/5259/dashboards">Allure TestOps</a>
____
### *Allure TestOps Dashboard*

<p align="center">  
<img title="Allure TestOps Dashboard" src="media/screen/Dash-TestOps.png" width="850">  
</p>  

### Auto and Manual Test-cases

<p align="center">  
<img title="Allure Tests" src="media/screen/autoManual.png" width="850">  
</p>

___
<a id="jira"></a>
## <img alt="Jira" height="25" src="media/logo/Jira.svg" width="25"/></a> Integration with <a target="_blank" href="https://jira.qa.guru/browse/REF-8">Jira</a>
____
<p align="center">  
<img title="Jira" src="media/screen/jira.png" width="850">  
</p>

____
<a id="tg"></a>

## <img width="30" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg">Telegram notifications:  

After the build is completed, a <code>Telegram bot</code> automatically processes the test run results and sends a report to a dedicated chat


____  
<p align="center">  
<img title="Telegram" src="media/screen/br-tg-bot.png" width="550">  
</p>





<a id="movie"></a>
<img alt="Browserstack" height="20" src="media/logo/Browserstack.svg" width="20"/> **BrowserStack Video Examples**  
<table align="center">
  <tr>
    <td align="center"><img title="Browserstack Video" src="media/video/bs.gif" width="250" height="500" alt="video"></td>
    <td width="40"></td>
    <td align="center"><img title="Browserstack Video" src="media/video/bs-kotlin.gif" width="250" height="500" alt="video"></td>
  </tr>
</table>

