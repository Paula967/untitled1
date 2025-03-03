package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    public By getLoggedInUserName(){
        return getLocator(locatorType.CSS,"li:nth-child(10) a:nth-child(1)");
    }
    public LoginPage assertLoggedInUserName(){
        driver.assertThat()
                .element(getLoggedInUserName())
                .isVisible()
                .withCustomReportMessage("Verify that New User Signup is visible")
                .perform();
        return this;
    }
    public SignUpAndLoginPage clickOnLogout(){
        clickElement(locatorType.CSS,"a[href='/logout']");
        return new SignUpAndLoginPage(driver);
    }


}
