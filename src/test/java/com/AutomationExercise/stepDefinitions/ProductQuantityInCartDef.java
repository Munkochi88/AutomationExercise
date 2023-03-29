package com.AutomationExercise.stepDefinitions;

import com.AutomationExercise.Pages.CartPage;
import com.AutomationExercise.Pages.HomePage;
import com.AutomationExercise.Pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ProductQuantityInCartDef {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    CartPage cartPage = new CartPage(driver);
    @When("User click View Product for any Product on Home Page")
    public void user_click_view_product_for_any_product_on_home_page() {
    homePage.clickingViewProductButton();
    }
    @When("User Validate Product Detail is Opened")
    public void user_validate_product_detail_is_opened() {
    productsPage.validateProductDetailIsOpened(driver);
    }
    @When("User Increase Quantity to {int}")
    public void user_increase_quantity_to(int quantity) {
    productsPage.increasingQuantity(quantity);
    }
    @When("User click Add to Cart Button")
    public void user_click_add_to_cart_button() {
    productsPage.clickingAddToCartButton();
    }
    @When("User click View Cart Button")
    public void user_click_view_cart_button() {
    productsPage.clickingViewCartButton();
    }
    @Then("User validate Product is Displayed in Cart with Quantity {int}")
    public void user_validate_product_is_displayed_in_cart_with_quantity(int quantity) {
    cartPage.validatingProductIsDisplayedCartWithQuantity(quantity);
    }
}
