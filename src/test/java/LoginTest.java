import org.junit.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class LoginTest extends BaseTest {

    @Test

    public void loginToReportPortal() {
        loginPage.openLoginPage()
                .enterTextInNameInput("kate")
                .enterTextInPasswordInput("qwerty")
                .clickOnLoginButton();

    }
@Test
    public void loginToReportPortalWrongCred() {
        loginPage.openLoginPage()
                .enterTextInNameInput("kate1")
                .enterTextInPasswordInput("qwerty1")
                .clickOnLoginButton();

    }
}
