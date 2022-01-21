package indigo_testing.shireburn.com.step_definitions;


import indigo_testing.shireburn.com.pages.TaxProfilePage;
import indigo_testing.shireburn.com.utilities.BrowserUtils;
import indigo_testing.shireburn.com.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class TaxProfile_steps {
    TaxProfilePage taxProfilePage = new TaxProfilePage();

    @Given("user clicks the Tax Profile button")
    public void user_clicks_the_Tax_Profile_button() {
        taxProfilePage.taxProfilesButton.click();
        Driver.waitFor(5);

    }

    @Given("user should be on Tax Profile page")
    public void user_should_be_on_Tax_Profile_page() {
        Driver.get().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        assertEquals("you are not on the tax profile pages","QATest01 - Tax Profiles", Driver.get().getTitle());
    }

    @Then("verify submenu under the Tax profile page")
    public void verify_submenu_under_the_Tax_profile_page() {
        assertTrue(taxProfilePage.submenu.isDisplayed());
        Driver.get().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }

    @Then("verify buttons are not clickable below")
    public void verify_buttons_are_not_clickable_below(List<String> buttons) throws InterruptedException {
        for (String eachButton :buttons ) {
            Driver.waitFor(1);
            WebElement button = Driver.get().findElement(By.xpath("//*[@id='"+eachButton+"Button']"));
            assertTrue(button.isEnabled());


        }

    }

    @When("user clicks the add button")
    public void user_clicks_the_add_button() {
        BrowserUtils.waitForClickablility(taxProfilePage.addButton,2500).click();
        //taxProfilePage.addButton.click();

    }

    @Then("verify buttons are clickable below")
    public void verify_buttons_are_clickable_below(List<String> buttons) {
        for (String eachButton :buttons ) {
            WebElement button = Driver.get().findElement(By.xpath("//*[@id='"+eachButton+"Button']"));
            Driver.waitFor(1);
            assertTrue(button.isEnabled());

        }
    }

    @When("user enter Tax profile description below")
    public void user_enter_Tax_profile_description_below(String string) {
        taxProfilePage.taxProfileDescripBox.click();
        taxProfilePage.taxProfileDescripBox.sendKeys(string);
        taxProfilePage.saveButton.click();
        }

    @Then("Verify the error message")
    public void verify_the_error_message() {
        taxProfilePage.errorPopUp.isDisplayed();
     }

    @When("user enter Tax profile data below")
    public void user_enter_Tax_profile_data_below(String string) {
        taxProfilePage.taxProfileBox.click();
        taxProfilePage.taxProfileBox.sendKeys(string);
        taxProfilePage.saveButton.click();
    }

    @When("user enter some {string},{string},{string},{string}")
    public void user_enter_some(String taxProfile, String taxProfileDesc, String FSS, String Tax) {
        taxProfilePage.taxProfileBox.click();
        taxProfilePage.taxProfileBox.sendKeys(taxProfile);
        taxProfilePage.taxProfileDescripBox.click();
        taxProfilePage.taxProfileDescripBox.sendKeys(taxProfileDesc);

        taxProfilePage.fssStatus(FSS);
        Driver.waitFor(2);
        if (Tax.equalsIgnoreCase("checked")){
            taxProfilePage.checkBox.click();
            Driver.get().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
           assertEquals("it is not selected",taxProfilePage.checkBox.getAttribute("aria-checked"),"true");
        }else{
            assertEquals("it is selected",taxProfilePage.checkBox.getAttribute("aria-checked"),"false");

        }


    }



    @When("user enters the accept button")
    public void user_enters_the_accept_button() {
       taxProfilePage.saveButton.click();
        Driver.waitFor(2);
        taxProfilePage.cancelButton.click();
        Driver.waitFor(2);
    }



    @When("User selects this {string} and deletes it.")
    public void user_selects_this_and_deletes_it(String string) {
       taxProfilePage.selectCheckbox(string);
       BrowserUtils.clickWithJS(taxProfilePage.deleteButton);
       Driver.waitFor(2);
       taxProfilePage.deleteConfirmation.click();
       Driver.waitFor(2);



    }



}
