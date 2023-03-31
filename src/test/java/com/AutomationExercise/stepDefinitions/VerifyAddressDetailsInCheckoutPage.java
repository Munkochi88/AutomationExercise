package com.AutomationExercise.stepDefinitions;

import com.AutomationExercise.Pages.CheckoutPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class VerifyAddressDetailsInCheckoutPage {
    WebDriver driver = DriverHelper.getDriver();
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    @Given("User also verify the billing address {string}")
    public void user_also_verify_the_billing_address(String address) {
    checkoutPage.validatingBillingAddress(address);
    }
}
