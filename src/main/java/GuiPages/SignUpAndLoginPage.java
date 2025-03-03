package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignUpAndLoginPage extends BasePage{

    //Constructor
    public SignUpAndLoginPage(
            SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    public By getSignUpHeader(){
        return getLocator(locatorType.CSS,"div[class='signup-form'] h2");
    }
    public SignUpAndLoginPage assertSignUpHeader(){
        driver.assertThat()
                .element(getSignUpHeader())
                .isVisible()
                .withCustomReportMessage("Verify that New User Signup is visible")
                .perform();
        return this;
    }

    public SignUpAndLoginPage addNewUser(String Name, String Email){
        enterText(locatorType.CSS,"input[placeholder='Name']",Name);
        enterText(locatorType.CSS,"input[data-qa='signup-email']",Email);
        return this;
    }

    public SignUpPage clickOnSignUpButton(){
        clickElement(locatorType.CSS,"button[data-qa='signup-button']");
        return new SignUpPage(driver);
    }

    public SignUpAndLoginPage loginWithUserNameAndPassword(String userName, String Password){
        enterText(locatorType.CSS,"input[data-qa='login-email']",userName);
        enterText(locatorType.NAME,"password",Password);
        return this;
    }

    public LoginPage clickOnLoginButton(){
        clickElement(locatorType.CSS,"button[data-qa='login-button']");
        return new LoginPage(driver);
    }
    public By getSignInHeader(){
        return getLocator(locatorType.CSS,"div[class='login-form'] h2");
    }

    public SignUpAndLoginPage assertSignInHeader(){
        driver.assertThat()
                .element(getSignInHeader())
                .isVisible()
                .withCustomReportMessage("Verify that New User Signup is visible")
                .perform();
        return this;
    }
    public By getErrorMessageWithIncorrectLoginData(){
        return getLocator(locatorType.XPATH,
                "//p[normalize-space()='Your email or password is incorrect!']");
    }

}
