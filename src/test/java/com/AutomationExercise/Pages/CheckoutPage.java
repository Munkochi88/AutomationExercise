package com.AutomationExercise.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class CheckoutPage {
    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#address_delivery")
    WebElement deliveryAddress;
    @FindBy(xpath = "//textarea[@name='message']")
    WebElement comment;
    @FindBy(xpath = "//a[.='Place Order']")
    WebElement placeOrderButton;

    public void verifyingAddress(String address){
        Assert.assertTrue(BrowserUtils.getText(deliveryAddress).contains(address));
    }
    public void commentAndClickPlaceOrderButton(String description){
        this.comment.sendKeys(description);
        placeOrderButton.click();
    }
}
