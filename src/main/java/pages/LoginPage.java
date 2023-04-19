package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//*[@placeholder='Login']")
    private WebElement inputName;
    public LoginPage(WebDriver webDriver) {

        super(webDriver);
    }

    public LoginPage openLoginPage(){
        webDriver.get(configProperties.base_url());
        return this;
    }

    public LoginPage enterTextInNameInput(String input) {
        enterTextIntoElement(inputName, input);
        return this;
    }
}
