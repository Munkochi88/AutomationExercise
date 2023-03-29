package com.AutomationExercise.stepDefinitions;

import com.AutomationExercise.Pages.HomePage;
import com.AutomationExercise.Pages.ProductsPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ViewAndCartBrandProducts {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    @When("User Click Products Button")
    public void user_click_products_button() {
    homePage.clickingProductsButton();
    }
    @When("User Validate that {string} are Visible on Left Side Bar")
    public void user_validate_that_are_visible_on_left_side_bar(String header) {
    productsPage.validatingBrandsVisibility(header);
    }
    @When("User Click H&M Brand")
    public void user_click_h_m_brand() {
    productsPage.clickingHAndMBrand();
    }
    @When("User Validate that Navigated to Brand {string} and {string} are Displayed")
    public void user_validate_that_navigated_to_brand_and_are_displayed(String url, String header) {
        Assert.assertEquals(url,driver.getCurrentUrl());
        productsPage.validatingBrandHAndMProductsDisplayed(header);
    }
    @When("User Click KOOKIE KIDS Brand Link")
    public void user_click_kookie_kids_brand_link() {
    productsPage.clickingKookieKidsBrand();
    }
    @Then("User Validate that User Navigated to that Brand {string} and Products are Displayed")
    public void user_validate_that_user_navigated_to_that_brand_and_products_are_displayed(String header) {
    productsPage.validatingHeaderBrandKookieKidsProducts(header);
    }
}
