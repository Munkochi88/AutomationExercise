package com.AutomationExercise.stepDefinitions;

import com.AutomationExercise.Pages.*;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class PlaceOrderRegisterWhileCheckout {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    CartPage cartPage = new CartPage(driver);
    SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
    SignupPage signupPage = new SignupPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    PaymentPage paymentPage = new PaymentPage(driver);
    @Given("User validate that Home Page is Visible Successfully")
    public void user_validate_that_home_page_is_visible_successfully() {
        Assert.assertEquals(ConfigReader.readProperty("url"),driver.getCurrentUrl());
    }
    @When("User add products to cart")
    public void user_add_products_to_cart() {
        homePage.clickingAddToCartButton();
    }
    @When("User Click Cart button")
    public void user_click_cart_button() {
    homePage.clickingCartButton();
    }
    @When("User Verify that cart page is displayed")
    public void user_verify_that_cart_page_is_displayed() {
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
    }
    @When("User Click Proceed To Checkout")
    public void user_click_proceed_to_checkout() {
    cartPage.clickingProceedToCheckoutButton();
    }
    @When("User Click RegisterLogin button")
    public void user_click_register_login_button() {
    cartPage.clickingRegisterLoginButton();
    }
    @When("User Fill all details in Signup and create account")
    public void user_fill_all_details_in_signup_and_create_account() {
    signupLoginPage.signup();
    signupPage.creatingAccount();
    }
    @When("User Verify account created {string} and click Continue button")
    public void user_verify_account_created_and_click_continue_button(String header) {
    signupPage.validatingHeader(header);
    }
    @When("User Verify Logged in as {string} at top")
    public void user_verify_logged_in_as_at_top(String username) {
    homePage.validatingUsername(username);
    }
    @When("User Click Proceed To Checkout button")
    public void user_click_proceed_to_checkout_button() {
        cartPage.clickingProceedToCheckoutButton();
    }
    @And("User Verify {string} Details and Review Your Order")
    public void userVerifyAddressDetailsAndReviewYourOrder(String address) {
    checkoutPage.verifyingAddress(address);
    }
    @And("User Enter description in {string} text area and click Place Order")
    public void userEnterDescriptionInCommentTextAreaAndClickPlaceOrder(String comment) {
    checkoutPage.commentAndClickPlaceOrderButton(comment);
    }
    @When("User Enter payment details Name , card Number, CVC, Expiration date")
    public void user_enter_payment_details_name_card_number_cvc_expiration_date() {
    paymentPage.fillingPayment();
    }
    @When("User Click Pay and Confirm Order button")
    public void user_click_pay_and_confirm_order_button() throws InterruptedException {
    paymentPage.clickingPayAndConfirmOrderButton(driver);
    }
    @When("User Verify success message {string}")
    public void user_verify_success_message(String message) {
    paymentPage.validateSuccessfulMessage(driver,message);
    }
    @When("User Click Delete Account button")
    public void user_click_delete_account_button() {
    homePage.clickingDeleteAccountButton();
    }
    @Then("User Verify {string} and click Continue button")
    public void user_verify_and_click_continue_button(String accountDeleted) {
    homePage.validateAccountDelete(accountDeleted);
    }

}
