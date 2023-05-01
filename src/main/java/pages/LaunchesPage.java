package pages;

import libs.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LaunchesPage extends LandingPage {

    @FindBy(xpath = ".//*[@data-id='10']//tr//p")
    private WebElement demonstrationLaunchSection;
    public LaunchesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LaunchesPage verifyDemonstrationLaunchSection(String textExample){

        Utils.waitABit(3);
        Assert.assertTrue("Error", demonstrationLaunchSection.getText().contains(textExample));
        return this;
    }
}