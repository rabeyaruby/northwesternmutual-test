package ui.test;

import org.junit.Test;
import ui.helper.TestHelper;
import ui.page.LoginPage;

public class LoginTest extends TestHelper {

    @Test
    public void verifyLoginSuccessful() {
        LoginPage logInPage = new LoginPage(driver);
        logInPage.login();
    }

}
