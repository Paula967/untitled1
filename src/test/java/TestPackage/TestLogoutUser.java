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
    protected LoginPage loginPage;

    @Test(priority = 11)
    public void Verify_that_loggedIn_is_visible_successfully(){
        registerUserPage=new RegisterUserPage(driver);
         loginPage =registerUserPage
                 .navigateToURL()
                 .clickOnSignUpAndLoginButton()
                 .loginWithUserNameAndPassword
                        (
                                SignIntestData.getTestData("Email"),
                                SignIntestData.getTestData("Password")
                        )
                .clickOnLoginButton()
                .assertLoggedInUserName();
    }
    @Test(priority = 12)
    public void Verify_that_user_is_navigated_toLoginPage(){
        String ActualURL=loginPage.clickOnLogout()
                  .getPageURL();
        Validations.assertThat().object(ActualURL).isEqualTo("https://automationexercise.com/login");
    }
}
