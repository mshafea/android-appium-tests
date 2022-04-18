package managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageObjects.LoginPage;

public class PageObjectManager {

    private AppiumDriver<MobileElement> driver;
    private LoginPage loginPage;


    public PageObjectManager(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

}