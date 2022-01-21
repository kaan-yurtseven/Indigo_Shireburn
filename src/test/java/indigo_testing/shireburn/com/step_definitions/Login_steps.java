package indigo_testing.shireburn.com.step_definitions;

import indigo_testing.shireburn.com.pages.LoginPage;
import indigo_testing.shireburn.com.utilities.ConfigurationReader;
import indigo_testing.shireburn.com.utilities.Driver;
import indigo_testing.shireburn.com.utilities.MyScreenRecorder;
import io.cucumber.java.en.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Login_steps {
    LoginPage loginPage = new LoginPage();

    @Given("As a user should be on login page")
    public void as_a_user_should_be_on_login_page() throws Exception {
        MyScreenRecorder.startRecording("Time");

        Driver.get().get(ConfigurationReader.get("url"));
        assertEquals("You are not on login page","Shireburn Indigo - Login",Driver.get().getTitle());

    }

    @When("user enters the valid username")
    public void user_enters_the_valid_username() {
        loginPage.usernameBox.sendKeys(ConfigurationReader.get("validUsername"));

    }

    @When("user enters the valid password")
    public void user_enters_the_valid_password() {
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("validPassword"));

    }

    @Then("user should be on home page")
    public void user_should_be_on_home_page() {
        assertEquals("you are not on homepage","Index",Driver.get().getTitle());

    }


    @When("user enters the invalid username")
    public void user_enters_the_invalid_username() {
        loginPage.usernameBox.sendKeys(ConfigurationReader.get("invalidUsername"));

    }

    @Then("user should get the error message")
    public void user_should_get_the_error_message() {
        assertEquals("you could not take an error message","Invalid user name or password",loginPage.errorMessage.getText());
    }

    @When("user enters the invalid password")
    public void user_enters_the_invalid_password() {
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("invalidPassword"));

    }
    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.loginButton.click();
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }



}
