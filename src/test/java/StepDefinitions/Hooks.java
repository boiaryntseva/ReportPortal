package StepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import libs.DriverHelper;
import org.apache.log4j.Logger;

public class Hooks {
    DriverHelper driverHelper = new DriverHelper();
    Logger logger = Logger.getLogger(getClass());


    @Before(order = 0)
    public void setUp(Scenario scenario) {
        driverHelper.createWebDriver();
        logger.info(scenario.getName() + "was started");
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        driverHelper.closeDriver();
        logger.info(scenario.getName() + "was ended with status" + scenario.getStatus());
    }

}
