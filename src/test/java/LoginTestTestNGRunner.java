import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestTestNGRunner extends BaseTestTestNGRunner {

    @Test

    public void loginToReportPortal() {

        loginPage.openLoginPage()
                .enterTextInNameInput("kate");

    }

    @Test

    public void loginToReportPortalWithWrongUserName() {

        loginPage.openLoginPage()
                .enterTextInNameInput("kateWrongName");

    }

}
