package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;


public class Hooks {

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException, InterruptedException {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        testContext.getDriverManager().quitDriver();
    }

}