import org.junit.Test;

public class LoginTest extends BaseTest{

    @Test

    public void loginToReportPortal() {
        loginPage.openLoginPage()
                .enterTextInNameInput("kate");

    }
}
