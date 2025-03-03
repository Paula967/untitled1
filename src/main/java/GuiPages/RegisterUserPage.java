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
    /**
     * @return The Locator
     */
    public By getHeaderOfHomePage(){
        return getLocator(locatorType.CSS,"div[class='item active'] div[class='col-sm-6'] h2");
    }
    public void assertHomePageIsVisible(){
        driver.assertThat()
                .element(getHeaderOfHomePage())
                .isVisible()
                .withCustomReportMessage("Verify that home page is visible successfully")
                .perform();
    }






}
