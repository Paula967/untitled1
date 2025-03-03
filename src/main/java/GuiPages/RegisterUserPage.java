package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class RegisterUserPage extends BasePage{

    //Constructor
    public RegisterUserPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    //Actions

    /**
     * @return RegisterUserPage
     */
    public RegisterUserPage navigateToURL(){
        driver.browser().navigateToURL("https://automationexercise.com/");
        return new RegisterUserPage(driver);
    }
    /**
     * @return SignUp And login Page
     */
    public SignUpAndLoginPage clickOnSignUpAndLoginButton(){
        clickElement(locatorType.CSS,"a[href='/login']");
        return new SignUpAndLoginPage(driver);
    }

    public void assertHomePageIsVisible(){
        assertElementIsVisible(locatorType.CSS,"div[class='item active'] div[class='col-sm-6'] h2");
    }






}
