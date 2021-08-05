package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helper.PageHelper;

public class CheckoutCompletePage extends PageHelper {

    private By orderConfirmationEle = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationMessage() {
        return getText(orderConfirmationEle);
    }
}
