package ui.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;
import static ui.helper.Constants.DEFAULT_TIMEOUT_SECONDS;
import static ui.helper.DriverUtils.setDriverTimeout;

public class PageHelper {

    public static WebDriver driver;

    public PageHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Wait for element to be clickable and click
     *
     * @param locator
     */
    public void clickOnElement(By locator) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * Clear and set a text field
     *
     * @param locator
     * @param value
     */
    public void setField(By locator, String value) {
        findWebElementBy(locator).clear();
        findWebElementBy(locator).sendKeys(value);
    }

    /**
     * Wait for element to load
     * @param by
     * @return
     */
    public WebElement findWebElementBy(By by) {
        WebElement element = null;
        try {
            setDriverTimeout(0);
            new WebDriverWait(driver, DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(by));
            element = driver.findElement(by);
        } catch (Exception e) {
            fail("Failed to locate element by [" + by + "]\n" + e.getStackTrace());
        }
        return element;
    }

    public boolean isElementEnabled(By byElement) {
        boolean isEnabled;
        try {
            new WebDriverWait(driver, DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(byElement));
            isEnabled = true;
        } catch (Exception ignore) {
            isEnabled = false;
        }
        return isEnabled;
    }

    public void selectByValue(By by, String value) {
        new Select(findWebElementBy(by)).selectByValue(value);
    }

    public String getText(By by) {
        return findWebElementBy(by).getText().trim();
    }

    public List<String> getStringList(By by) {
        List<String> listStrings = new ArrayList<>();
        List<WebElement> webElements = new WebDriverWait(driver, DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        for (WebElement element : webElements) {
            listStrings.add(element.getText().trim());
        }
        return listStrings;
    }

}
