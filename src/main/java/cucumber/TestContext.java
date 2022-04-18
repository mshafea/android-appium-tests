package cucumber;

import managers.DriverManager;
import managers.PageObjectManager;

import java.io.IOException;

public class TestContext {
    private DriverManager driverManager;
    private PageObjectManager pageObjectManager;

    public TestContext() throws IOException, InterruptedException {
        driverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver());
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }
    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

}