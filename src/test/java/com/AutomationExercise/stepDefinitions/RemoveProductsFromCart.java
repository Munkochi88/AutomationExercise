package com.AutomationExercise.stepDefinitions;

import com.AutomationExercise.Pages.CartPage;
import com.AutomationExercise.Pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class RemoveProductsFromCart {
    WebDriver driver = DriverHelper.getDriver();
    CartPage cartPage = new CartPage(driver);

    @When("User Click X Button corresponding to particular product")
    public void user_click_x_button_corresponding_to_particular_product() throws InterruptedException {
        Thread.sleep(2000);
    cartPage.clickingXButton(driver);
    }
    @And("User validate that {string}")
    public void userValidateThatCartIsEmpty(String message) throws InterruptedException {
        Thread.sleep(2000);
    cartPage.validatingProductRemoved(message);
    }
}
