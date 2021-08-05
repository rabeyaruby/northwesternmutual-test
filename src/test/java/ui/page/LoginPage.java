package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helper.Constants;
import ui.helper.PageHelper;

public class LoginPage extends PageHelper {
    private By userNameField = By.id("user-name");
    private By passWordField = By.id("password");
    private By logInButton = By.cssSelector("[value='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        setField(userNameField, Constants.DEFAULT_USERNAME);
        setField(passWordField, Constants.DEFAULT_PASSWORD);
        clickOnElement(logInButton);
    }
}
