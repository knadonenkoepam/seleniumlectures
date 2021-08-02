package googletest;

import diexample.DriverService;
import diexample.WebDriverInjector;
import driverutils.DriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    static WebDriver webDriver;
    private String baseURL = "https://www.google.com";

    @BeforeClass
    public static void prepareToTest() {
//        webDriver = new DriverManager().setupDriver();
        DriverService driverService = new WebDriverInjector().getDriverService();
        webDriver = driverService.setupDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Before
    public void initTest() {
        webDriver.get(baseURL);
    }

    @AfterClass
    public static void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
