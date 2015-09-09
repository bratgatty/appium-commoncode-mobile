# appium-commoncode-mobile
Common Code implementation for iOS and Android app automation using Appium

Instructions
1. Open the pom.xml in Eclipse or Intellij editor to setup the project.
2. Ensure appium is installed and running on your machine.
3. To run the test from command line, execute the following command
mvn test
4. To run the test in parallel for multiple android device, execute the following command after making change in the platform.properties file.
platform=android
./parallel_execution.sh
5. To run the test on iOS, make platform=ios in the platform.properties and execute the command
mvn test
