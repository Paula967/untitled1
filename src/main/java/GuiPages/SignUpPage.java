package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignUpPage extends BasePage{

    //Constructor
    public SignUpPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    public void assertEnterAccountInformationLocator(){
        assertElementIsVisible(locatorType.XPATH,"//b[normalize-space()='Enter Account Information']");
    }

    public SignUpPage fillAccountInformation(String Name, String Password, int Day, String Months, int Year){
        clickElement(locatorType.CSS,"#id_gender1");
        enterText(locatorType.CSS,"#name", Name);
        enterText(locatorType.CSS,"#password",Password);
        selectElement(locatorType.CSS,"#days",String.valueOf(Day));
        selectElement(locatorType.CSS,"#months",Months);
        selectElement(locatorType.CSS,"#years",String.valueOf(Year));
        clickElement(locatorType.CSS,"#newsletter");
        clickElement(locatorType.CSS,"#optin");
        return this;

    }

    public SignUpPage fillAddressInformation(String firstName, String lastName, String Company,
                                             String Address1, String Address2, String Country,
                                             String State, String City, int zipCode, int mobileNumber){

        enterText(locatorType.CSS,"#first_name",firstName);
        enterText(locatorType.CSS,"#last_name",lastName);
        enterText(locatorType.CSS,"#company",Company);
        enterText(locatorType.CSS,"#address1",Address1);
        enterText(locatorType.CSS,"#address2",Address2);
        selectElement(locatorType.CSS,"#country",Country);
        enterText(locatorType.CSS,"#state",State);
        enterText(locatorType.CSS,"#city",City);
        enterText(locatorType.CSS,"#zipcode",String.valueOf(zipCode));
        enterText(locatorType.CSS,"#mobile_number",String.valueOf(mobileNumber));
        return this;
    }

    public AccountCreatedPage clickOnCreateAccountButton(){
        clickElement(locatorType.CSS,"button[data-qa='create-account']");
        return new AccountCreatedPage(driver);
    }

}
