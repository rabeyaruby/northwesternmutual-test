package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helper.PageHelper;

import java.util.List;

public class CheckoutOverviewPage extends PageHelper {
    private By cartCostElement = By.xpath("//div[@class='inventory_item_price']");
    private By checkoutTotalCostEle = By.className("summary_subtotal_label");
    private By cartProductNameElements = By.xpath("//*[@class='cart_item_label']/a/div");
    private By finishButton = By.name("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public double getProductsCartTotal() {
        double cost = 00.00;
        List<String> cartCosts = getStringList(cartCostElement);
        for (int i = 0; i < cartCosts.size(); i++) {
          Double unitCost = Double.valueOf(cartCosts.get(i).replace("$", ""));
            cost += unitCost;
        }
        return cost;
    }

    public String getCheckoutTotalCost() {
        return getText(checkoutTotalCostEle);
    }


    public List<String> getCartProductsName() {
        return getStringList(cartProductNameElements);
    }

    public void clickOnFinishButton() {
        clickOnElement(finishButton);
    }
}
