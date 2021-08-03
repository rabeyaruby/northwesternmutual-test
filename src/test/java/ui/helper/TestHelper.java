package ui.helper;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import static ui.helper.Constants.DEFAULT_DRIVER;

public class TestHelper {
    public static WebDriver driver;

    @BeforeClass
    public static void setupDriver() {
        driver = DriverUtils.loadDriver(DEFAULT_DRIVER);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public static void tearDownDriver() {
        DriverUtils.quitDriver();
    }

}
