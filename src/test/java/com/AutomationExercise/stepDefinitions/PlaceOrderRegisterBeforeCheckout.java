package com.AutomationExercise.stepDefinitions;

import com.AutomationExercise.Pages.HomePage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class PlaceOrderRegisterBeforeCheckout {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    @When("User Click SignupLogin Button")
    public void user_click_signup_login_button() {
        homePage.clickingSignupLoginButton();
    }
}
