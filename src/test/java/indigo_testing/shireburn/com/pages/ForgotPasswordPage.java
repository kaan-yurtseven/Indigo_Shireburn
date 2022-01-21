package indigo_testing.shireburn.com.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ForgotPasswordPage extends BasePage {

    @FindBy(className = "loginLink")
    public WebElement forgotPasswordButton;

    @FindBy(id = "Username")
    public WebElement forgotPasswordUsernameBox;

    @FindBy(xpath = "//*[@href='/Home']")
    public WebElement returnHomeButtonInPassword;

    @FindBy(id= "submit")
    public WebElement sendButton;

    @FindBy(className = "panelMessage")
    public WebElement panelMessage;

}
