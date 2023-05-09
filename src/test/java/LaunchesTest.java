import org.junit.Test;

public class LaunchesTest extends BaseTest {
    String inputName = "kate";
    String password = "qwerty";

//    public LaunchesTest(String inputName, String password) {
//        this.inputName = inputName;
//        this.password = password;
//    }

//    @Parameterized.Parameters
//    public static Collection testData() throws IOException {
//        InputStream inputStream = new FileInputStream(configProperties.DATA_FILE_PATH() + "testData.xls");
//        return new SpreadsheetData(inputStream, "validLogOn").getData();
//    }

    @Test
    public void demonstrationLaunchSectionVerification() {
        loginPage.openLoginPage()
                .enterTextInNameInput(inputName)
                .enterTextInPasswordInput(password)
                .clickOnLoginButton()
                .clickOnLaunchesSideBarItem()
                .verifyDemonstrationLaunchSection("Suite > Test > Step > Log");

    }
}
