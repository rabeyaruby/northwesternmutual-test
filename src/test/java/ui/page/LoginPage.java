package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helper.PageHelper;

public class LoginPage extends PageHelper {
    private By userNameField = By.id("user-name");
    private By passWordField = By.id("password");
    private By logInButton = By.cssSelector("[value='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        String userName = "standard_user";
        String passWord = "secret_sauce";
        setField(userNameField, userName);
        setField(passWordField, passWord);
        clickOnElement(logInButton);
    }
}
