package GuiPages;

import com.shaft.driver.SHAFT;

public class LoginPage extends BasePage{

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    public LoginPage assertLoggedInUserName(){
        assertElementIsVisible(locatorType.CSS,"li:nth-child(10) a:nth-child(1)");
        return this;
    }
    public SignUpAndLoginPage clickOnLogout(){
        clickElement(locatorType.CSS,"a[href='/logout']");
        return new SignUpAndLoginPage(driver);
    }


}
