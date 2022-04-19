package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.StartStopAppium;
import utilities.StartStopEmulator;

import java.io.IOException;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
        plugin = "json:target/jsonReports/cucumber-report.json")
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeTest
    public static void setup() throws IOException, InterruptedException {
        StartStopAppium.startAppiumServer();
        String device = System.getProperty("device_name");
        if (!device.contains("Android Device")) {
            StartStopEmulator.launchEmulator(device);
        }
    }

    @AfterTest
    public static void teardown() throws IOException, InterruptedException {
        StartStopEmulator.closeEmulator();
        StartStopAppium.stopAppiumServer();
    }

}