package com.AutomationExercise.stepDefinitions;

import com.AutomationExercise.Pages.CartPage;
import com.AutomationExercise.Pages.HomePage;
import com.AutomationExercise.Pages.ProductsPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class AddToCartFromRecommendedItems {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    CartPage cartPage = new CartPage(driver);
    @When("User scroll to bottom of page and validate {string} header")
    public void user_scroll_to_bottom_of_page_and_validate_header(String header) {
    homePage.validatingHeaderRecommendedItem(driver,header);
    }
    @When("User click add to cart and view cart button on recommended product")
    public void user_click_add_to_cart_and_view_cart_button_on_recommended_product() throws InterruptedException {
    homePage.clickingAddToCartOnRecommendedProduct();
    productsPage.clickingViewCartButton();
    }
    @Then("User validate that product is displayed in cart page")
    public void user_validate_that_product_is_displayed_in_cart_page() {
    cartPage.validatingProductsAreVisible();
    }
}
