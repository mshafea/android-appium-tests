package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends PageBase {


    @AndroidFindBy(id = "com.example.vivytask:id/username")
    private MobileElement usernameTxtField;

    @AndroidFindBy(id = "com.example.vivytask:id/password")
    private MobileElement passwordTxtField;

    @AndroidFindBy(id = "com.example.vivytask:id/login")
    private MobileElement loginBtn;

    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    private MobileElement loginSuccessMsg;

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void setUsername(String username) {
        waitForVisibilityOf(usernameTxtField);
        setText(usernameTxtField, username);
    }

    public void setPassword(String password) {
        waitForVisibilityOf(passwordTxtField);
        setText(passwordTxtField, password);
    }

    public void clickOnLoginBtn() {
        click(loginBtn);
    }

    public String getSuccessLoginMessage() {
        return getElementAttribute(loginSuccessMsg,"name");
    }

    public boolean isLoginButtonEnabled() {
        return isElemenetEnabled(loginBtn);
    }

}
