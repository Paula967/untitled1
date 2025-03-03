package TestPackage;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
    protected static SHAFT.GUI.WebDriver driver;
    @BeforeSuite
    public void setup(){
       driver =new SHAFT.GUI.WebDriver();
       driver.browser().navigateToURL("https://automationexercise.com/");
    }
    @AfterSuite
    public void tearDown(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
