package com.AutomationExercise.stepDefinitions;

import com.AutomationExercise.Pages.SignupLoginPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class PlaceOrderLoginBeforeCheckout {
    WebDriver driver = DriverHelper.getDriver();
    SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
    @When("User Fill Email, Password and Click Login Button")
    public void user_fill_email_password_and_click_login_button() {
        signupLoginPage.login();
    }
}
