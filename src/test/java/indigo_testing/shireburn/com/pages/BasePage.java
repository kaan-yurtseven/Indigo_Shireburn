package indigo_testing.shireburn.com.pages;

import indigo_testing.shireburn.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = "cachedWindowWrapper")
    public WebElement windowWrapper;

    @FindBy(xpath = "//*[@class='cachedWindowWrapper']/following-sibling::div[1]")
    public WebElement notificationButton;

    @FindBy(id = "helpMenu")
    public WebElement helpMenu;

    @FindBy(xpath = "//*[@id='helpMenu']/div/div/div//*[@class='link']")
    public List<WebElement> helpContent;

    @FindBy(className = "historyWrapper")
    public WebElement historyWrapper;

    @FindBy(className = "headerMenuItemPopupContainer-listItem")
    public List<WebElement> usageHistory;

    @FindBy(id = "activeUserMenu")
    public WebElement userLogo;

    @FindBy(xpath = "(//*[@class= 'headerMenuItemPopupContainer'])[1]/div/div")
    public List<WebElement> underUserLogo;

    @FindBy(xpath = "//*[@class='headerMenuItemPopupContainer-listItem']/../following-sibling::div[1]/div")
    public WebElement clearAllHistory;



}

