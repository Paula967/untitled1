package TestPackage;

import GuiPages.RegisterUserPage;
import GuiPages.SignUpAndLoginPage;
import com.shaft.driver.SHAFT;
import io.cucumber.java.be.I;
import org.testng.annotations.Test;

public class TestLoginWithInvalidData extends BaseClass{
    private SHAFT.TestData.JSON SignIntestData =
            new SHAFT.TestData.JSON("src/test/resources/testDataFiles/SignInTestData.json");
    protected RegisterUserPage registerUserPage;
    protected SignUpAndLoginPage signUpAndLoginPage;

    @Test(priority = 10)
    public void Verify_that_home_page_is_visible_successfully(){
        registerUserPage=new RegisterUserPage(driver);
        registerUserPage
                .navigateToURL()
                .assertHomePageIsVisible();
    }

    @Test(priority = 11)
    public void Verify_that_LoginToYourAccount_is_visible_successfully(){
        signUpAndLoginPage=registerUserPage
                .clickOnSignUpAndLoginButton()
                .assertSignInHeader();
    }
    @Test(priority = 12)
    public void Verify_that_ErrorYourEmailOrPasswordIsIncorrect_is_visible_successfully(){

        String CorrectPassword=SignIntestData.getTestData("Password");
        String IncorrectPassword=CorrectPassword+"Abcdf";
        signUpAndLoginPage
                .loginWithUserNameAndPassword
                        (
                                SignIntestData.getTestData("Email"),
                                IncorrectPassword
                        )
                .clickOnLoginButton();
                signUpAndLoginPage.assertErrorMessageWithIncorrectLoginData();
    }
}
