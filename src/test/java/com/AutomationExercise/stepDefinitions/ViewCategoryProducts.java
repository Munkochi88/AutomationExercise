package com.AutomationExercise.stepDefinitions;

import com.AutomationExercise.Pages.HomePage;
import com.AutomationExercise.Pages.ProductsPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ViewCategoryProducts {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);

    @When("User Click on Women Category")
    public void user_click_on_women_category() {
    homePage.clickingWomenCategoryButton();
    }
    @When("User Click Tops under Women Category")
    public void user_click_tops_under_women_category() {
    homePage.clickingTopsUnderWomen();
    }
    @And("User Validate {string} Page is Displayed and Validate {string}")
    public void userValidateCategoryPageIsDisplayedAndValidateWOMENTOPSPRODUCTS(String category,String header) {
        Assert.assertTrue(driver.getCurrentUrl().contains(category));
        productsPage.validatingHeaderWomenTopsProductsHeader(header);
    }
    @When("User on Left Side bar, Click on any Sub-Category link of Man Category")
    public void user_on_left_side_bar_click_on_any_sub_category_link_of_man_category() {
    homePage.clickingJeansButtonUnderMen();
    }
    @Then("Validate User is Navigated to that Category {string}")
    public void validate_user_is_navigated_to_that_category(String header) {
    productsPage.validatingHeaderMenJeansProducts(header);
    }
}
