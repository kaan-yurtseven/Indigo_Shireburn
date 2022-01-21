package indigo_testing.shireburn.com.step_definitions;


import indigo_testing.shireburn.com.pages.RatesPages;
import indigo_testing.shireburn.com.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Rates_steps {

    RatesPages ratesPages = new RatesPages();
    @Given("user clicks th Rates button")
    public void user_clicks_th_Rates_button() {
        ratesPages.ratesButton.click();
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);




    }
    @Then("Verify the page title")
    public void verify_the_page_title() {
        Driver.waitFor(5);
        assertEquals("You are not on Rates page","QATest01 - Tax Rates",Driver.get().getTitle());
    }


    @When("user enter some {string},{string},{string},{string} on Rates Page")
    public void user_enter_some_on_Rates_Page(String code, String rangeFrom, String rangeTo, String subtract) {
       ratesPages.code.sendKeys(code);
       ratesPages.RangeFrom.sendKeys(rangeFrom);
       ratesPages.RangeTo.sendKeys(rangeTo);
       ratesPages.subtract.sendKeys(subtract);
       ratesPages.subtract.sendKeys(Keys.ENTER);

    }

}
