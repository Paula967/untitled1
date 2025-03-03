package TestPackage;

import GuiPages.RegisterUserPage;
import GuiPages.SignUpAndLoginPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;

public class TestRegisterWithExistingEmail extends BaseClass{
    private SHAFT.TestData.JSON SignUptestData =
            new SHAFT.TestData.JSON("src/test/resources/testDataFiles/SignUpTestData.json");
    private SHAFT.TestData.JSON SignIntestData =
            new SHAFT.TestData.JSON("src/test/resources/testDataFiles/SignInTestData.json");
    protected RegisterUserPage registerUserPage;
    protected SignUpAndLoginPage signUpAndLoginPage;

    @Test(priority = 13)
    public void Verify_that_ErrorMessageEmailAlreadyExist_is_visible_successfully(){
        registerUserPage=new RegisterUserPage(driver);
        signUpAndLoginPage=registerUserPage
                .navigateToURL()
                        .clickOnSignUpAndLoginButton();
        signUpAndLoginPage.addNewUser
                (
                        SignUptestData.getTestData("name"),
                        SignIntestData.getTestData("Email")
                )
                .clickOnSignUpButton();
        signUpAndLoginPage.assertErrorMessageWithAlreadyRegisteredUser();
    }
}
