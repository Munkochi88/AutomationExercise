package com.AutomationExercise.stepDefinitions;

import com.AutomationExercise.Pages.HomePage;
import com.AutomationExercise.Pages.ProductsPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class AddReviewOnProduct {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    @When("User clicks view product button and validate {string}")
    public void user_clicks_view_product_button_and_validate(String header) {
    homePage.clickingViewProductButton();
    productsPage.validatingReviewHeader(header);
    }
    @And("User enter {string}, {string}, {string} and clicks submit button")
    public void userEnterNameEmailReviewAndClicksSubmitButton(String name,String email,String review) {
        productsPage.fillingNameEmailReviewAndSubmit(name,email,review);
    }
    @Then("User validate success message {string}")
    public void user_validate_success_message(String message) {
    productsPage.validatingSuccessMessage(message);
    }
}
