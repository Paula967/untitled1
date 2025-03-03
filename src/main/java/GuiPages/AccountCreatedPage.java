package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountCreatedPage extends BasePage{
    public AccountCreatedPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    public By getAccountCreatedPageMessage(){
        return getLocator(locatorType.CSS,"h2[class='title text-center'] b");
    }

    public AccountCreatedPage assertAccountCreatedPageMessage(){
        driver.assertThat()
                .element(getAccountCreatedPageMessage())
                .isVisible()
                .withCustomReportMessage("Verify that New User Signup is visible")
                .perform();
        return this;
    }
    public AccountCreatedPage clickOnContinue(){
        clickElement(locatorType.CSS,".btn.btn-primary");
        return this;
    }

    public By getLoggedInUserName(){
        return getLocator(locatorType.CSS,"li:nth-child(10) a:nth-child(1)");
    }
    public AccountCreatedPage assertLoggedInUserName(){
        driver.assertThat()
                .element(getLoggedInUserName())
                .isVisible()
                .withCustomReportMessage("Verify that New User Signup is visible")
                .perform();
        return this;
    }

    public AccountCreatedPage clickOnDeleteAccount(){
        clickElement(locatorType.CSS,"a[href='/delete_account']");
        return this;
    }

    public By getAccountDeletedPageMessage(){
        return getLocator(locatorType.CSS,"h2[class='title text-center'] b");
    }
    public AccountCreatedPage assertAccountDeletedPageMessage(){
        driver.assertThat()
                .element(getAccountDeletedPageMessage())
                .isVisible()
                .withCustomReportMessage("Verify that New User Signup is visible")
                .perform();
        return this;
    }

}
