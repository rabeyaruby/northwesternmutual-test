package ui.tests;

import org.junit.Assert;
import org.junit.Test;
import ui.helper.Constants;
import ui.helper.TestHelper;
import ui.page.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckoutTest extends TestHelper {

    private String expectedMessage = "THANK YOU FOR YOUR ORDER";

    @Test
    public void verifyItemsAddedToCart() {
        List<String> products = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Fleece Jacket");

        LoginPage logInPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        logInPage.login();

        /*Sort and add products*/
        productsPage.sortProducts(Constants.DEFAULT_SORT);
        productsPage.addProductsToCart(products);
        productsPage.clickOnShoppingCart();

        /*Verify Shopping cart*/
        String cartQuantity = productsPage.getCartQuantity();
        verifyEquals("Added product cart quantity not matched.", String.valueOf(products.size()), cartQuantity);
        verifyCartProductName(products, shoppingCartPage);

        /* Remove an item*/
        shoppingCartPage.removeProduct(products.get(1));
        cartQuantity = productsPage.getCartQuantity();
        verifyEquals("After product remove cart quantity not matched.", String.valueOf(products.size() - 1), cartQuantity);

        /*Continue Shopping*/
        shoppingCartPage.clickOnContinueShopping();
        List<String> newProducts = Arrays.asList("Sauce Labs Onesie");
        productsPage.addProductsToCart(newProducts);
        cartQuantity = productsPage.getCartQuantity();
        verifyEquals("Added new product cart quantity not matched.", String.valueOf((products.size() - 1) + newProducts.size()), cartQuantity);

        /*Checkout*/
        productsPage.clickOnShoppingCart();
        shoppingCartPage.clickOnCheckoutButton();

        /*Submit customer information */
        YourInformationPage yourInformationPage = new YourInformationPage(driver);
        yourInformationPage.submitUserInformation(Constants.FIRST_NAME, Constants.LAST_NAME, Constants.ZIP_CODE);
        yourInformationPage.clickOnContinueButton();

        /*Verify check out overview */
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        List<String> cartProductsName = checkoutOverviewPage.getCartProductsName();
        Assert.assertTrue("Added new product in cart not matched.", cartProductsName.containsAll(newProducts));

        double cartTotal = checkoutOverviewPage.getProductsCartTotal();
        String expectedTotal = checkoutOverviewPage.getCheckoutTotalCost();
        verifyEquals("Total price not matched.", "Item total: $" + String.valueOf(cartTotal), expectedTotal);

        /*Verify Checkout complete confirmation*/
        checkoutOverviewPage.clickOnFinishButton();
        String confirmationMessage = new CheckoutCompletePage(driver).getConfirmationMessage();
        verifyEquals("Checkout confirmation message not matched", expectedMessage, confirmationMessage);
    }

    /**
     * Verify each product name added to the cart
     * @param products
     * @param cartPage
     */
    private void verifyCartProductName(List<String> products, ShoppingCartPage cartPage) {
        List<String> actualCartProductsName = cartPage.getCartProductsName();
        Collections.sort(actualCartProductsName);
        Collections.sort(products);
        Assert.assertEquals("Added products name not matched", products, actualCartProductsName);
    }

}
