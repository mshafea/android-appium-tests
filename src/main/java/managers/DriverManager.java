package managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverManager {
    private AppiumDriver<MobileElement> driver;
    private DesiredCapabilities capabilities;
    private static String androidApp;
    private static String hubHost, port, completeUrl;


    public DriverManager() {
        androidApp = FileReaderManager.getInstance().getConfigReader().getAndroidAppName();
        capabilities = new DesiredCapabilities();
    }

    public AppiumDriver<MobileElement> getDriver() throws IOException, InterruptedException {
        if (driver == null)
            driver = createDriver();
        return driver;
    }

    public AppiumDriver<MobileElement> createDriver() throws IOException, InterruptedException {
        hubHost = System.getProperty("hub_host");
        port = System.getProperty("port");
        completeUrl = "http://" + hubHost + ":" + port + "/wd/hub";
        System.out.println("complete URL : " + completeUrl);
        File f = new File(System.getProperty("user.dir") + "/src/main/resources");
        File app = new File(f, androidApp);
        String device = System.getProperty("device_name");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
//        capabilities.setCapability("isHeadless", true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        driver = new AndroidDriver<>(new URL(completeUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public void quitDriver() {
        try {
            this.driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}