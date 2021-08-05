package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helper.PageHelper;

public class YourInformationPage extends PageHelper {

    private By firstNameFiled = By.name("firstName");
    private By lastNameFiled = By.name("lastName");
    private By zipCodeFiled = By.name("postalCode");
    private By continueButton = By.name("continue");

    public YourInformationPage(WebDriver driver) {
        super(driver);
    }

    public void submitUserInformation(String firstName, String lastName, String zipCode) {
        setField(firstNameFiled, firstName);
        setField(lastNameFiled, lastName);
        setField(zipCodeFiled, zipCode);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }
}
