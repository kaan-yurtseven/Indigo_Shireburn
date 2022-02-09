package indigo_testing.shireburn.com.pages;

import indigo_testing.shireburn.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{


  @FindBy(id = "txtUsername")
    public WebElement usernameBox;

  @FindBy(id = "txtPassword")
    public WebElement passwordBox;

  @FindBy(className = "loginMessage")
    public WebElement errorMessage;

  @FindBy(id = "submit")
    public WebElement loginButton;
}
