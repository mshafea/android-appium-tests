# Android Automation Tests

## About

The goal of this project is testing Android login page content using cucumber BDD framework integrated with TestNG.

#### Prerequisites: (This has been tested on the following system)

* macOS version 12.1
* Android Studio and Android SDKs
* with $ANDROID_HOME environment variable set pointing to your android SDK
* Java 1.8+
* Maven 3.3.3+ installed and available on your PATH
* NodeJS
* Maven
* Appium 1.22+ (All details related to Appium installation are here: http://appium.io/docs/en/about-appium/getting-started/)


## Instructions

1. Clone the repo:

    ` $ git clone https://github.com/mshafea/android-appium-tests.git`

2. Run the tests from the command line with:

   `$ mvn test verify -Dhub_host=$hub_host -Dport=$port -Ddevice_name=$device_name`
   
   in which 

    - $hub_host is Ip Address of Appium Server
    - $port is the port of Appium server
    - $device_name is the name of android emulator/device

    e.g : mvn test verify -Dhub_host=127.0.0.1 -Dport=4723 -Ddevice_name=Nexus6

By default, tests are run on headless mode

## Test Reports

Generated test reports after executing the tests can be accessed under target/cucumber-html-reports folder