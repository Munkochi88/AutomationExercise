package com.AutomationExercise.stepDefinitions;

import com.AutomationExercise.Pages.CartPage;
import com.AutomationExercise.Pages.HomePage;
import com.AutomationExercise.Pages.ProductsPage;
import com.AutomationExercise.Pages.SignupLoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchProductsAndValidateCartAfterLogin {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    CartPage cartPage = new CartPage(driver);
    SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
    @When("User clicks Products Button and Validate {string} header")
    public void user_clicks_products_button_and_validate_header(String header) {
    homePage.clickingProductsButton();
    productsPage.validatingHeader(header);
    }
    @When("User searches {string} and  click searchButton")
    public void user_searches_and_click_search_button(String product) {
    productsPage.searchingProduct(product);
    }
    @When("User validate {string} header and all products related to {string}")
    public void user_validate_header_and_all_products_related_to(String header, String product) {
    productsPage.validatingHeaderAndProducts(header,product);
    }
    @When("User add all products to cart and click cart button")
    public void user_add_all_products_to_cart_and_click_cart_button() throws InterruptedException {
    productsPage.addingAllProductsAndClickingCartButton(driver);
    homePage.clickingCartButton();
    }
    @When("User validate all products are visible")
    public void user_validate_all_products_are_visible() {
    cartPage.validatingProductsAreVisible();
    }
    @When("User clicks signupAndLogin button and fill login")
    public void user_clicks_signup_and_login_button_and_fill_login() {
    homePage.clickingSignupLoginButton();
    signupLoginPage.login();
    }
    @Then("User clicks cart button and validate all products are visible")
    public void user_clicks_cart_button_and_validate_all_products_are_visible() {
    //homePage.clickingCartButton();
    cartPage.validatingProductsAreVisible();
    }
}
