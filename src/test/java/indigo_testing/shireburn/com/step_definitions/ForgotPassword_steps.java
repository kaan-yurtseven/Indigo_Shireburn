package indigo_testing.shireburn.com.step_definitions;

import indigo_testing.shireburn.com.pages.ForgotPasswordPage;
import indigo_testing.shireburn.com.utilities.ConfigurationReader;
import indigo_testing.shireburn.com.utilities.Driver;
import io.cucumber.java.en.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ForgotPassword_steps {
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();


    @Given("As a user should click the Forgot your password? button")
    public void as_a_user_should_click_the_Forgot_your_password_button() {
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        forgotPasswordPage.forgotPasswordButton.click();

    }

    @Then("As a user I should click Return to login page")
    public void as_a_user_I_should_click_Return_to_login_page() {
        Driver.get().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        forgotPasswordPage.returnHomeButtonInPassword.click();
    }



    @Then("Verify that user should be on Forgot password page.")
    public void verify_that_user_should_be_on_Forgot_password_page() {
        Driver.get().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        assertEquals("You are not on the Forgot Password Page","Forgot Password",Driver.get().getTitle());
    }

    @Then("As a user should enter {string}")
    public void as_a_user_should_enter(String string) {
        Driver.get().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        string = ConfigurationReader.get("validUsername");
        forgotPasswordPage.forgotPasswordUsernameBox.sendKeys(string);

    }

    @Then("As a user should click the send button")
    public void as_a_user_should_click_the_send_button() {
        Driver.get().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        forgotPasswordPage.sendButton.click();
    }

    @Then("verify that the email sent message")
    public void verify_that_the_email_sent_message() {
        Driver.get().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        forgotPasswordPage.panelMessage.isDisplayed();
    }



    @Then("Verify that login page is displayed")
    public void verify_that_login_page_is_displayed() {
        assertEquals("You are not on the login page","Shireburn Indigo - Login",Driver.get().getTitle());
    }




}
