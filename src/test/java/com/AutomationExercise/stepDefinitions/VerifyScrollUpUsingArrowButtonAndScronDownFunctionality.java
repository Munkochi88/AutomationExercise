package com.AutomationExercise.stepDefinitions;

import com.AutomationExercise.Pages.HomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class VerifyScrollUpUsingArrowButtonAndScronDownFunctionality{
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    @When("User scroll down and validate {string}")
    public void user_scroll_down_and_validate(String subscription) {
    homePage.scrollingDownAndValidatingSubscription(driver,subscription);
    }
    @Then("User click scroll up button and validate header {string}")
    public void user_click_scroll_up_button_and_validate_header(String header) {
    homePage.scrollUpFunctionalityAndValidatingHeader(header);
    }
}
