import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

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
    public void loginToReportPortal() {
        loginPage.openLoginPage()
                .enterTextInNameInput(inputName)
                .enterTextInPasswordInput(password)
                .clickOnLoginButton()
                .clickOnLaunchesSideBarItem();

    }
}
