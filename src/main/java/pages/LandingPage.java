package pages;

import libs.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends ParentPage {
    public LandingPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@class='sidebar__top-block--6oCNs']/div[2]")
    private WebElement launchesMenu;

    @FindBy(xpath = ".//aside")
    private WebElement sideBar;

    public LaunchesPage clickOnLaunchesSideBarItem() {
        Utils.waitABit(5);
        clickOnElement(launchesMenu);
        return new LaunchesPage(webDriver);
    }

    public LandingPage verifyLandingPageIsLoaded(){
        Utils.waitABit(5);
        Assert.assertTrue("Side bar menu is not there",sideBar.isDisplayed());
        return this;
    }
    public LandingPage verifyLandingPageIsNotLoaded(){
        Utils.waitABit(5);
        Assert.assertFalse("Side bar menu is not there",sideBar.isDisplayed());
        return this;
    }
}
