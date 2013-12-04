hybrid-mobile-apps-automation
=============================

Hybrid-Mobile-Apps-Automation

Application under test is in: https://github.com/jboss-developer/ticket-monster or in our fork https://github.com/testers-lviv-ua/ticket-monster

Here is the manual how to build the apps for different platforms that we are testing on:

For Android:
https://github.com/jboss-developer/ticket-monster/blob/master/cordova/android/README.md

For IOS (Mac OS needed):
https://github.com/jboss-developer/ticket-monster/blob/master/cordova/ios/README.md

For android tests use Selendroid:
download from here:
https://github.com/selendroid/selendroid/releases/download/0.6.0/selendroid-standalone-0.6.0-with-dependencies.jar

For IOS tests use IOS-driver (Mac OS needed):
download from here:
https://github.com/ios-driver/ios-driver/releases/download/0.6.5/ios-server-0.6.5-jar-with-dependencies.jar

or better build it by your own from refactor branch 
https://github.com/ios-driver/ios-driver

or our fork (December 4, 2013 last checked)
https://github.com/testers-lviv-ua/ios-driver

IOS-driver should be build with https://github.com/testers-lviv-ua/libimobiledevice-wrapper 
Clone and copy the folder to libimobiledevice-wrapper folder of IOS-driver

Execution:
selendroid part:
java -jar selendroid-standalone-0.6.0-with-dependencies.jar -app TicketMonster.apk

ios-driver part:
java -jar ios-server-0.6.5-jar-with-dependencies.jar -aut TicketMonster.app -port 4444 -simulators

Test execution:
run as testng singletestAndroid/IOS.xml file or generalSuite.xml for both at once.
