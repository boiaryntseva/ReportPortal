import io.github.bonigarcia.wdm.WebDriverManager;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class BaseTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    protected String baseUrl = configProperties.base_url();

    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

//    public WebDriver initDriver(){}

    @Test

    public void openHomePage(){
        webDriver.get(baseUrl);
    }
}


