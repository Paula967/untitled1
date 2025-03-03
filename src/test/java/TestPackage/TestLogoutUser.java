package TestPackage;

import GuiPages.LoginPage;
import GuiPages.RegisterUserPage;
import GuiPages.SignUpAndLoginPage;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.testng.annotations.Test;

public class TestLogoutUser extends BaseClass{
    private SHAFT.TestData.JSON SignIntestData =
            new SHAFT.TestData.JSON("src/test/resources/testDataFiles/SignInTestData.json");
    protected RegisterUserPage registerUserPage;
    protected SignUpAndLoginPage signUpAndLoginPage;
    protected LoginPage loginPage;

    @Test(priority = 13)
    public void Verify_that_home_page_is_visible_successfully(){
        registerUserPage=new RegisterUserPage(driver);
        registerUserPage
                .navigateToURL()
                .assertHomePageIsVisible();
    }

    @Test(priority = 14)
    public void Verify_that_LoginToYourAccount_is_visible_successfully(){
        signUpAndLoginPage=registerUserPage
                .clickOnSignUpAndLoginButton()
                .assertSignInHeader();
    }
    @Test(priority = 15)
    public void Verify_that_loggedIn_is_visible_successfully(){
         loginPage =signUpAndLoginPage
                .loginWithUserNameAndPassword
                        (
                                SignIntestData.getTestData("Email"),
                                SignIntestData.getTestData("Password")
                        )
                .clickOnLoginButton()
                .assertLoggedInUserName();
    }
    @Test(priority = 16)
    public void Verify_that_user_is_navigated_toLoginPage(){
        String ActualURL=loginPage.clickOnLogout()
                  .getPageURL();
        Validations.assertThat().object(ActualURL).isEqualTo("https://automationexercise.com/login");
    }
}
