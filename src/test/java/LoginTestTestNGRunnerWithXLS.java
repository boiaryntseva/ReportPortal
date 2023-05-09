import libs.SpreadSheetData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class LoginTestTestNGRunnerWithXLS extends BaseTestTestNGRunner {

    @DataProvider(name = "excelData")
    public Iterator<Object[]> getInputData() throws IOException {
        InputStream inputStream = new FileInputStream(configProperties.DATA_FILE_PATH() + "testDataExample.xls");
        return SpreadSheetData.getDataFromExcel(inputStream, "validLogOn").iterator();
    }

    @Test(dataProvider = "excelData")
    public void loginToReportPortal(String login, String pass) {
        loginPage.openLoginPage()
                .enterTextInNameInput(login)
                .enterTextInPasswordInput(pass)
                .clickOnLoginButton()
                .verifyLandingPageIsLoaded();

    }
}
