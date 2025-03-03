package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class BasePage {
    protected static SHAFT.GUI.WebDriver driver;

    public enum locatorType{
        ID, NAME, CLASSNAME, TAGNAME, LINKTEXT, PARTIALLINKTEXT, CSS, XPATH
    }
    public BasePage(SHAFT.GUI.WebDriver driver) {
        BasePage.driver = driver;
    }
    protected By getLocator(locatorType type, String value) {
        switch (type) {
            case ID: return By.id(value);
            case NAME: return By.name(value);
            case CLASSNAME: return By.className(value);
            case TAGNAME: return By.tagName(value);
            case LINKTEXT: return By.linkText(value);
            case PARTIALLINKTEXT: return By.partialLinkText(value);
            case CSS: return By.cssSelector(value);
            case XPATH: return By.xpath(value);
            default: throw new IllegalArgumentException("Invalid locator type: " + type);
        }
    }

    protected void clickElement(locatorType type, String value) {
        driver.element().click(getLocator(type,value));
    }

    protected void enterText(locatorType type, String value, String text) {
        driver.element().type(getLocator(type,value),text);
    }

    protected void selectElement(locatorType Type, String Value ,String Option){
        driver.element().select(getLocator(Type,Value),Option);
    }
    protected String getElementText(locatorType type, String value) {
       return driver.element().getText(getLocator(type,value));
    }

}
