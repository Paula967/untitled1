package TestPackage;

import GuiPages.AccountCreatedPage;
import GuiPages.RegisterUserPage;
import GuiPages.SignUpAndLoginPage;
import GuiPages.SignUpPage;
import com.shaft.driver.SHAFT;

import org.testng.annotations.Test;

public class TestRegisterUser extends BaseClass{

    private SHAFT.TestData.JSON SignUptestData =
            new SHAFT.TestData.JSON("src/test/resources/testDataFiles/SignUpTestData.json");
    private SHAFT.TestData.JSON AccountDetailstestData =
            new SHAFT.TestData.JSON(("src/test/resources/testDataFiles/AccountDetailsTestData.json"));
    protected RegisterUserPage registerUserPage;
    protected SignUpPage signUpPage;
    protected SignUpAndLoginPage signUpAndLoginPage;
    protected AccountCreatedPage accountCreatedPage;

    @Test(priority = 1)
    public void Verify_that_home_page_is_visible_successfully(){
       registerUserPage=new RegisterUserPage(driver);
       registerUserPage
               .assertHomePageIsVisible();
    }

    @Test(priority = 2)
    public void Verify_that_newUserSignUp_is_visible_successfully(){
        signUpAndLoginPage=registerUserPage
                .clickOnSignUpAndLoginButton()
                .assertSignUpHeader();
    }

    @Test(priority =3)
    public void Verify_that_EnterAccountInformation_is_visible_successfully(){
         signUpPage =signUpAndLoginPage
                .addNewUser
                        (
                                SignUptestData.getTestData("name"),
                                SignUptestData.getTestData("SignUpEmail")
                        )
                .clickOnSignUpButton();

       signUpPage.assertEnterAccountInformationLocator();
    }
    @Test(priority = 4)
    public void Verify_that_ACCOUNTCREATED_is_visible_successfully(){
         accountCreatedPage =createNewAccount()
                 .assertAccountCreatedPageMessage();
    }
    @Test(priority = 5)
    public void Verify_that_loggedIn_is_visible_successfully(){
        accountCreatedPage =accountCreatedPage
                .clickOnContinue()
                .assertLoggedInUserName();
    }
    @Test(priority = 6)
    public void Verify_that_AccountDeleted_is_visible_successfully(){
        accountCreatedPage
                .clickOnDeleteAccount()
                .assertAccountDeletedPageMessage();
    }
    private AccountCreatedPage createNewAccount(){
        accountCreatedPage=
                signUpPage
                .fillAccountInformation
                        (
                                AccountDetailstestData.getTestData("Name"),
                                AccountDetailstestData.getTestData("Password"),
                                Integer.parseInt(AccountDetailstestData.getTestData("Day")),
                                AccountDetailstestData.getTestData("Month"),
                                Integer.parseInt(AccountDetailstestData.getTestData("Year"))
                        )
                .fillAddressInformation
                        (
                                AccountDetailstestData.getTestData("FirstName"),
                                AccountDetailstestData.getTestData("LastName"),
                                AccountDetailstestData.getTestData("Company"),
                                AccountDetailstestData.getTestData("Address1"),
                                AccountDetailstestData.getTestData("Address2"),
                                AccountDetailstestData.getTestData("Country"),
                                AccountDetailstestData.getTestData("State"),
                                AccountDetailstestData.getTestData("City"),
                                Integer.parseInt(AccountDetailstestData.getTestData("Zipcode")),
                                Integer.parseInt(AccountDetailstestData.getTestData("MobileNumber"))
                        )
                .clickOnCreateAccountButton();
        return accountCreatedPage;
    }
}

