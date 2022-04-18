package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class PageBase {

    final WebDriverWait wait;
    public int time = 100;
    protected AppiumDriver<MobileElement> driver;
    private int frequency = 2;
    private FluentWait<AppiumDriver> fluentWait;


    public PageBase(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        wait = new WebDriverWait(driver, time);
        fluentWait = new FluentWait<AppiumDriver>(driver).
                withTimeout(ofSeconds(time)).
                pollingEvery(ofSeconds(frequency)).
                ignoring(NoSuchElementException.class).
                ignoring(TimeoutException.class).
                ignoring(StaleElementReferenceException.class);
    }

    public void click(MobileElement element) {
        element.click();
    }

    public void setText(MobileElement element, String text) throws NoSuchElementException {
        element.clear();
        element.sendKeys(text);
    }

    public String getElementAttribute(MobileElement element, String attribute) {
        try {
            return element.getAttribute(attribute);
        } catch (NoSuchElementException e) {
            return ("No such element exception is returned");
        }
    }

    public boolean isElemenetEnabled(MobileElement element) {
        waitForVisibilityOf(element);
        return element.isEnabled();
    }

    public void waitForVisibilityOf(final MobileElement element) {
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }


}