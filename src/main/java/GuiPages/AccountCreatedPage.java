package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountCreatedPage extends BasePage{
    public AccountCreatedPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    public AccountCreatedPage assertAccountCreatedPageMessage(){
        assertElementIsVisible(locatorType.CSS,"h2[class='title text-center'] b");
        return this;
    }
    public AccountCreatedPage clickOnContinue(){
        clickElement(locatorType.CSS,".btn.btn-primary");
        return this;
    }

    public AccountCreatedPage assertLoggedInUserName(){
        assertElementIsVisible(locatorType.CSS,"li:nth-child(10) a:nth-child(1)");
        return this;
    }

    public AccountCreatedPage clickOnDeleteAccount(){
        clickElement(locatorType.CSS,"a[href='/delete_account']");
        return this;
    }

    public AccountCreatedPage assertAccountDeletedPageMessage(){
        assertElementIsVisible(locatorType.CSS,"h2[class='title text-center'] b");
        return this;
    }

}
