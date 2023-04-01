package com.AutomationExercise.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[.='View Product']")
    List<WebElement> viewProductButtons;
    @FindBy(xpath = "//a[.='Add to cart']")
    List<WebElement> addToCartButtons;
    @FindBy(xpath = "//a[.=' Cart']")
    WebElement cartButton;
    @FindBy(xpath = "//button[.='Continue Shopping']")
    WebElement continueShoppingButton;
    @FindBy(xpath = "//a[contains(text(),'Logged')]")
    WebElement username;
    @FindBy(xpath = "//a[.=' Delete Account']")
    WebElement deleteAccountButton;
    @FindBy(xpath = "//h2//b")
    WebElement accountDeletedHeader;
    @FindBy(xpath = "//a[.=' Signup / Login']")
    WebElement signupLoginButton;
    @FindBy(xpath = "//a[@href='#Women']")
    WebElement womenCategoryButton;
    @FindBy(xpath = "//a[@href='#Men']")
    WebElement menCategoryButton;
    @FindBy(xpath = "//a[contains(text(),'Jeans')]")
    WebElement jeansButtonUnderMen;
    @FindBy(xpath = "//div[@id='Women']//a[contains(text(),'Tops')]")
    WebElement topsButtonUnderWomen;
    @FindBy(xpath = "//a[contains(text(),'Products')]")
    WebElement productsButton;
    @FindBy(xpath = "//h2[.='recommended items']")
    WebElement headerRecommendedItem;
    @FindBy(xpath = "//div[@class='recommended_items']//a[.='Add to cart']")
    List<WebElement> recommendedItemAddToCartButton;
    @FindBy(xpath = "//h2[.='Subscription']")
    WebElement subscription;
    @FindBy(xpath = "//h2[.='Full-Fledged practice website for Automation Engineers']")
    WebElement headerFullFledged;
    @FindBy(css = "#scrollUp")
    WebElement scrollUpButton;

    public void clickingAddToCartOnRecommendedProduct() throws InterruptedException {
        for (WebElement addToCart:recommendedItemAddToCartButton){
            Thread.sleep(2000);
            addToCart.click();
            break;
        }
    }
    public void validatingHeaderRecommendedItem(WebDriver driver,String header){
        BrowserUtils.scrollWithJS(driver,headerRecommendedItem);
        Assert.assertEquals(header,BrowserUtils.getText(headerRecommendedItem));
    }
    public void clickingViewProductButton(){
        for (WebElement viewProductButton:viewProductButtons){
           viewProductButton.click();
           break;
        }
    }
    public void clickingAddToCartButton() {
        for (WebElement addToCartButton:addToCartButtons){
            addToCartButton.click();
            break;
        }
        continueShoppingButton.click();
    }
    public void clickingCartButton(){
        cartButton.click();
    }
    public void validatingUsername(String userName){
        Assert.assertTrue(BrowserUtils.getText(username).contains(userName));
    }
    public void clickingDeleteAccountButton(){
        deleteAccountButton.click();
    }
    public void validateAccountDelete(String headerAccountDeleted){
        Assert.assertEquals(headerAccountDeleted,BrowserUtils.getText(accountDeletedHeader));
    }
    public void clickingSignupLoginButton(){
        signupLoginButton.click();
    }
    public void clickingWomenCategoryButton(){
        womenCategoryButton.click();
    }
    public void clickingTopsUnderWomen(){
        topsButtonUnderWomen.click();
    }
    public void clickingJeansButtonUnderMen(){
        menCategoryButton.click();
        jeansButtonUnderMen.click();
    }
    public void clickingProductsButton(){
        productsButton.click();
    }
    public void scrollingDownAndValidatingSubscription(WebDriver driver,String subs){
        BrowserUtils.scrollWithJS(driver,subscription);
        Assert.assertEquals(subs,BrowserUtils.getText(subscription));
    }
    public void scrollUpFunctionalityAndValidatingHeader(String header){
        scrollUpButton.click();
        Assert.assertEquals(header,BrowserUtils.getText(headerFullFledged));
    }

}
