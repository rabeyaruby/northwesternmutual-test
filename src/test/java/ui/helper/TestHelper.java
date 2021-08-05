package ui.helper;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;

import static ui.helper.Constants.DEFAULT_DRIVER;

public class TestHelper {

    public static WebDriver driver;
    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @BeforeClass
    public static void setupDriver() {
        driver = DriverUtils.loadDriver(DEFAULT_DRIVER);
        driver.get("https://www.saucedemo.com/"); //TODO move to properties
    }

    /**
     * Test continue on assert failure, throws ErrorCollector at the end
     * @param message
     * @param expected
     * @param actual
     */
    public void verifyEquals(String message, String expected, String actual) {
        try {
            Assert.assertEquals(message, expected, actual);
        } catch (AssertionError e) {
            errorCollector.addError(e);
            //TODO capture screenshot
        }
    }

    @AfterClass
    public static void tearDownDriver() {
        DriverUtils.quitDriver();
    }

}
