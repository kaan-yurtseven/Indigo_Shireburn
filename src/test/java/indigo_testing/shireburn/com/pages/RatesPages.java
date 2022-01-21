package indigo_testing.shireburn.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RatesPages extends BasePage {

    @FindBy(xpath = "//*[@id = 'taxratebutton']")
    public WebElement ratesButton;

    @FindBy(xpath = "//input[@type='textarea'][1]")
    public WebElement code;

    @FindBy(xpath = "//input[@type='textarea'][4]")
    public WebElement RangeFrom;

    @FindBy(xpath = "//input[@type='textarea'][5]")
    public  WebElement RangeTo;

    @FindBy(xpath = "//input[@type='textarea'][6]")
    public WebElement subtract;



}
