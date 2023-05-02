import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginTestJunitWithXLS extends BaseTest {

        String inputName, password;


        public LoginTestJunitWithXLS(String inputName, String password) {
            this.inputName = inputName;
            this.password = password;
        }

        @Parameterized.Parameters
        public static Collection testData() throws IOException {
            InputStream inputStream = new FileInputStream(configProperties.DATA_FILE_PATH() + "testDataExample.xls");
            return new SpreadsheetData(inputStream, "validLogOn").getData();
        }

        @Test
        public void loginToReportPortal() {
            loginPage.openLoginPage()
                    .enterTextInNameInput(inputName)
                    .enterTextInPasswordInput(password)
                    .clickOnLoginButton()
                    .verifyLandingPageIsLoaded();

        }
    }

