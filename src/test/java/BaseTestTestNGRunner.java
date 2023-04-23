import io.github.bonigarcia.wdm.WebDriverManager;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;

import java.time.Duration;

public class BaseTestTestNGRunner {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    protected String baseUrl = configProperties.base_url();
    protected LoginPage loginPage;

    @BeforeTest

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(webDriver);

    }

// Will be in separate test file
//    @Test
//
//    public void openHomePage(){
//        webDriver.get(baseUrl);
//    }

    @AfterClass

    public void tearDown() {
        webDriver.quit();
    }

}



