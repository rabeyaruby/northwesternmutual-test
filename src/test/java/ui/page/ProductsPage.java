package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helper.PageHelper;

import java.util.List;

public class ProductsPage extends PageHelper {

    private By sortField = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select");
    private By shoppingCart = By.id("shopping_cart_container");
    private By cartQuantityBadge = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void sortProducts(String sortBy) {
        selectByValue(sortField, sortBy.toLowerCase());
    }

    public void addProductsToCart(List<String> products) {
        for (String product : products) {
            addToCartByProductName(product);
        }
    }

    private void addToCartByProductName(String productName) {
        By addToCartButton = By.xpath("//*[@class='inventory_item_label']//div[contains(text(),'" + productName.trim() + "')]//..//..//..//div[@class='pricebar']/button");
        if (isElementEnabled(addToCartButton)) {
            clickOnElement(addToCartButton);
        }
    }

    public void clickOnShoppingCart() {
        clickOnElement(shoppingCart);
    }


    public String getCartQuantity() {
        return getText(cartQuantityBadge);
    }
}
