package stepDefinitions;

import cucumber.TestContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginPage;

import java.io.IOException;

public class StepDefinition {

    AppiumDriver<MobileElement> driver;
    TestContext testContext;
    LoginPage loginPage;

    public StepDefinition(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }


    @Given("User open mobile app")
    public void user_open_mobile_app() throws IOException, InterruptedException {
        driver = testContext.getDriverManager().getDriver();
    }

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLoginBtn();
    }

    @Then("user should see a success login message {string}")
    public void user_should_see_a_success_login_message(String expectedMessage) {
        Assert.assertEquals(loginPage.getSuccessLoginMessage(), expectedMessage, "Success login message is not displayed as expected");
    }

    @When("the user enters a valid username {string} and empty password")
    public void theUserEntersAValidUsernameAndEmptyPassword(String username) {
        loginPage.setUsername(username);
    }

    @Then("the login button is not enabled")
    public void theLoginButtonIsNotEnabled() {
        Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Login button is enabled and not as expected");
    }

    @When("the user enters an empty username and a valid password {string}")
    public void theUserEntersAnEmptyUsernameAndAValidPassword(String password) {
        loginPage.setPassword(password);
    }


}
