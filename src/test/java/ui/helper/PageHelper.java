package ui.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ui.helper.Constants.DEFAULT_TIMEOUT_SECONDS;

public class PageHelper {
    public WebDriver driver;

    public PageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(By locator) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void setField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
}
