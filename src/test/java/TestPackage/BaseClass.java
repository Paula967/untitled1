package TestPackage;

import GuiPages.*;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
    protected static SHAFT.GUI.WebDriver driver;
    /*protected RegisterUserPage registerUserPage;
    protected SignUpPage signUpPage;
    protected SignUpAndLoginPage signUpAndLoginPage;
    protected AccountCreatedPage accountCreatedPage;
    protected LoginPage loginPage;*/
    @BeforeSuite
    public void setup(){
       driver =new SHAFT.GUI.WebDriver();
       driver.browser().navigateToURL("https://automationexercise.com/");
       /*registerUserPage=new RegisterUserPage(driver);
       signUpPage=new SignUpPage(driver);
       signUpAndLoginPage=new SignUpAndLoginPage(driver);
       accountCreatedPage=new AccountCreatedPage(driver);
       loginPage=new LoginPage(driver);*/
    }
    @AfterSuite
    public void tearDown(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
