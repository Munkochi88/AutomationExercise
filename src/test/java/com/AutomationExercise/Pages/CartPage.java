package com.AutomationExercise.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#product-1")
    WebElement product;

    //git practice whatever

    @FindBy(xpath = "//td//button")
    WebElement productQuantity;
    @FindBy(xpath = "//a[.='Proceed To Checkout']")
    WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//a[.='Register / Login']")
    WebElement registerLoginButton;
    @FindBy(css = ".cart_quantity_delete")
    WebElement xButton;
    @FindBy(tagName = "b")
    WebElement cartEmptyMessage;
    public void validatingProductIsDisplayedCartWithQuantity(int quantity){
        Assert.assertTrue(product.isDisplayed());
        Assert.assertEquals(String.valueOf(quantity), BrowserUtils.getText(productQuantity));
    }
    public void clickingProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }
    public void clickingRegisterLoginButton(){
        registerLoginButton.click();
    }
    public void clickingXButton(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(xButton).perform();
        xButton.click();
    }
    public void validatingProductRemoved(String message){
        Assert.assertEquals(message,BrowserUtils.getText(cartEmptyMessage));
    }
}
