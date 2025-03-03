package TestPackage;

import GuiPages.*;
import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;

public class TestLoginUserWithValidData extends BaseClass{
    private SHAFT.TestData.JSON SignIntestData =
            new SHAFT.TestData.JSON("src/test/resources/testDataFiles/SignInTestData.json");
    protected RegisterUserPage registerUserPage;
    protected SignUpAndLoginPage signUpAndLoginPage;

    @Test(priority = 7)
    public void Verify_that_LoginToYourAccount_is_visible_successfully(){
        registerUserPage=new RegisterUserPage(driver);
        signUpAndLoginPage=registerUserPage
                .clickOnSignUpAndLoginButton()
                .assertSignInHeader();
    }
    @Test(priority = 8)
    public void Verify_that_loggedIn_is_visible_successfully(){
        LoginPage loginPage =signUpAndLoginPage
                .loginWithUserNameAndPassword
                        (
                                   SignIntestData.getTestData("Email"),
                                   SignIntestData.getTestData("Password")
                        )
                .clickOnLoginButton()
                .assertLoggedInUserName();
        loginPage.clickOnLogout();
    }
}
