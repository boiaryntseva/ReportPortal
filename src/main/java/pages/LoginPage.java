package pages;

import libs.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//*[@placeholder='Login']")
    private WebElement inputName;

    @FindBy(xpath = ".//*[@type='password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//*[@type='submit']")
    private WebElement buttonLogin;


    public LoginPage(WebDriver webDriver) {

        super(webDriver);
    }

    public LoginPage openLoginPage() {
        webDriver.get(configProperties.base_url());
        return this;
    }

    public LoginPage enterTextInNameInput(String input) {
        Utils.waitABit(5);
        enterTextIntoElement(inputName, input);
        System.out.println(input);
        return this;
    }

    public LoginPage enterTextInPasswordInput(String input) {
        enterTextIntoElement(inputPassword, input);
        return this;
    }

    public LandingPage clickOnLoginButton() {
        clickOnElement(buttonLogin);
        return new LandingPage(webDriver);
    }
}
