package indigo_testing.shireburn.com.pages;

import indigo_testing.shireburn.com.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}

