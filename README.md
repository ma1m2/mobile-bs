**Стек используемых технологий**  
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.png">
<img width="6%" title="Java" src="media/logo/Java.png">
<img width="6%" title="Browserstack" src="media/logo/Browserstack.png">
<img width="6%" title="Android Studio" src="media/logo/androidstudio.png">
<img width="6%" title="Selenide" src="media/logo/Selenide.png">
<img width="6%" title="GitHub" src="media/logo/GitHub.png">
<img width="6%" title="Allure Report" src="media/logo/Allure_Report.png">
<img width="6%" title="Gradle" src="media/logo/Gradle.png">
<img width="6%" title="JUnit5" src="media/logo/JUnit5.png">
<img width="6%" title="Jenkins" src="media/logo/Jenkins.png">
<img width="6%" title="Telegram" src="media/logo/Telegram.png">
<img width="6%" title="AllureTestOps" src="media/logo/AllureTestOps.png">
<img width="5%" title="Jira" src="media/logo/Jira.png">
</p>

**Запустить Appium Server**  
```bash
appium server --base-path /wd/hub
```  
**Запустить эмулятор**  
```bash
emulator -avd Pixel_4 -gpu swiftshader_indirect
```  
**Проверить запущенные устройства**  
```bash
adb devices
```  
**Для запуска на разных стендах передать из командной строки:**  
```bash
./gradlew clean test -DdeviceHost=browserstack
./gradlew clean test -DdeviceHost=emulator
./gradlew clean test -DdeviceHost=real
```
**Real device**  
- Настройки > О телефоне > Версия ОС (Build number) > тап 7 раз
- Настройки > Расширенные настройки > Для разработчиков (Developer options)

Отключить:
* Отладка по USB
* Установка через USB
* Отладка по USB (настройки безопасности)
* Проверять байт-код приложений, доступный для отладки  

Выключить:
* Отключить автоматический отзыв авторизации adb
* Проверять приложение при установке

<a id="movie"></a>
<img alt="Browserstack" height="25" src="media/logo/Browserstack.png" width="25"/> **Видео выполнения теста c Browserstack**
<p align="center">
<img title="Browserstack Video" src="media/video/bs.gif" width="250" height="500"  alt="video">   
</p>


