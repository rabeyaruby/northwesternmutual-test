package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helper.PageHelper;

import java.util.List;

public class ShoppingCartPage extends PageHelper {

    private By continueShoppingButton = By.name("continue-shopping");
    private By cartProductNameElements = By.xpath("//*[@class='cart_item_label']/a/div");
    private By checkoutButton = By.name("checkout");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getCartProductsName() {
        return getStringList(cartProductNameElements);
    }

    public void removeProduct(String productName) {
        By productNameElement = By.xpath("//*[@class='cart_item_label']/a/div[contains(text(),'" + productName.trim() + "')]//..//../div[@class='item_pricebar']/button");
        clickOnElement(productNameElement);
    }

    public void clickOnContinueShopping() {
        clickOnElement(continueShoppingButton);
    }

    public void clickOnCheckoutButton() {
        clickOnElement(checkoutButton);
    }
}
