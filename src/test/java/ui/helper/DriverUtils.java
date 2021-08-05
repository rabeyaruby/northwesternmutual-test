package ui.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static ui.helper.Constants.DEFAULT_TIMEOUT_SECONDS;
import static ui.helper.Constants.TIMEOUT_SECONDS_THIRTY;

public class DriverUtils {

    public static WebDriver driver;

    /**
     * Load driver, pass driver type: chrome, ie, firefox, etc.
     * @param driverType
     * @return
     */
    public static WebDriver loadDriver(String driverType) {
        if (driverType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            driver = new ChromeDriver(chromeOptions);
        } else if (driverType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            //TODO use logger
            System.out.println("You did not set any driver type, please set: chrome or firefox");
        }
        driver.manage().timeouts().pageLoadTimeout(TIMEOUT_SECONDS_THIRTY, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static void setDriverTimeout(int timeoutSeconds) {
        driver.manage().timeouts().implicitlyWait(timeoutSeconds, TimeUnit.SECONDS);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
