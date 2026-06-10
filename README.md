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



