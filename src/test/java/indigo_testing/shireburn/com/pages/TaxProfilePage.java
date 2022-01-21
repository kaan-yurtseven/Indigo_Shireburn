package indigo_testing.shireburn.com.pages;

import indigo_testing.shireburn.com.utilities.BrowserUtils;
import indigo_testing.shireburn.com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaxProfilePage extends BasePage {

    @FindBy(xpath = "//div[@class='currentModuleSectionGroup']/a")
    public WebElement taxProfilesButton;

    @FindBy(xpath = "//*[@id=\"currentViewWrapper1\"]/div/section/div/div[1]/div/div")
   public WebElement submenu;

    @FindBy(xpath = "(//*[contains(@title,'Insert')])[1]")
     public WebElement addButton;

    @FindBy(xpath = "//*[@data-uid='TaxProfile-Description']")
    public WebElement taxProfileDescripBox;

    @FindBy(xpath ="//*[@data-uid='TaxProfile-Code']" )
    public WebElement taxProfileBox;

    @FindBy(xpath = "//*[contains(@title,'Save (Enter)')]")
    public WebElement saveButton;

    @FindBy(xpath = "//*[contains(@title,'Cancel ')]")
    public WebElement cancelButton;

    @FindBy(className = "toast-title")
    public WebElement errorPopUp;

    @FindBy(xpath = "(//*[@role='checkbox'])[1]")
    public WebElement checkBox;

    @FindBy(xpath = "//*[@id='deleteActionButton']")
    public WebElement deleteButton;
    @FindBy(xpath = "//button[contains(text(),'delete')]")
    public WebElement deleteConfirmation;


    public void selectCheckbox(String string){
        Driver.get().findElement(By.xpath("//*[text()='"+string+"']/../../div[1]")).click();

    }




  public void fssStatus(String string){
    try{

        BrowserUtils.doubleClick(Driver.get().findElement(By.xpath("//input[@role='textbox']/../../div[4]")));
        Driver.waitFor(1);
        if (string.equalsIgnoreCase("FSS Main")){
            Driver.get().findElement(By.xpath("//div[@role='option'][1]")).click();
        }else{
            Driver.get().findElement(By.xpath("//div[@role='option'][2]")).click();
        }

        Driver.waitFor(2);
    }catch (Exception e){
        Driver.waitFor(2);
        Driver.get().navigate().refresh();
        Driver.get().findElement(By.xpath("//input[@role='textbox']/../../div[4]")).click();
        if (string.equalsIgnoreCase("FSS Main")){
            Driver.get().findElement(By.xpath("//div[@role='option'][1]")).click();
        }else{
            Driver.get().findElement(By.xpath("//div[@role='option'][2]")).click();
        }
    }
  }


}
