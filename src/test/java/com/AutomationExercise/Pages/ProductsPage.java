package com.AutomationExercise.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class ProductsPage {
    public ProductsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void validateProductDetailIsOpened(WebDriver driver){
        Assert.assertTrue(driver.getCurrentUrl().contains("details"));
    }
    @FindBy(css = "#quantity")
    WebElement quantity;
    @FindBy(xpath = "//button[@type='button']//*")
    WebElement addToCart;
    @FindBy(xpath = "//a[.='View Cart']")
    WebElement viewCartButton;
    @FindBy(xpath = "//h2[.='Women - Tops Products']")
    WebElement headerWomenTopsProducts;
    @FindBy(xpath = "//h2[.='Men - Jeans Products']")
    WebElement headerMenJeansProducts;
    @FindBy(xpath = "//h2[.='Brands']")
    WebElement brands;
    @FindBy(xpath = "//a[@href='/brand_products/H&M']")
    WebElement hAndMBrand;
    @FindBy(xpath = "//h2[.='Brand - H&M Products']")
    WebElement headerBrandHAndMProducts;
    @FindBy(xpath = "//a[@href='/brand_products/Kookie Kids']")
    WebElement kookieKidsBrand;
    @FindBy(xpath = "//h2[.='Brand - Kookie Kids Products']")
    WebElement headerBrandKookieKidsProducts;
    @FindBy(css = ".single-products")
    List<WebElement> allProducts;
    @FindBy(xpath = "//h2[.='All Products']")
    WebElement headerAllProducts;
    @FindBy(xpath = "//input[@id='search_product']")
    WebElement searchBar;
    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement searchSubmit;
    @FindBy(xpath = "//h2[.='Searched Products']")
    WebElement headerSearchedProducts;
    @FindBy(xpath = "//button[.='Continue Shopping']")
    WebElement continueShoppingButton;
    @FindBy(xpath = "//div[@class='productinfo text-center']//a")
    List<WebElement> addToCartButtons;
    @FindBy(xpath = "//span[.='Thank you for your review.']")
    WebElement reviewSuccessMessage;
    @FindBy(css = "#button-review")
    WebElement reviewSubmitButton;
    @FindBy(css = "#name")
    WebElement reviewName;
    @FindBy(css = "#email")
    WebElement reviewEmail;
    @FindBy(tagName = "textarea")
    WebElement addReview;
    @FindBy(xpath = "//a[.='Write Your Review']")
    WebElement headerWriteYourReview;


    public void increasingQuantity(int number){
        quantity.clear();
        while (!BrowserUtils.getText(quantity).equals("4")){
            this.quantity.sendKeys(String.valueOf(number));
            break;
        }
        //this.quantity.sendKeys(String.valueOf(number));
    }

    public void clickingAddToCartButton(){
        addToCart.click();
    }
    public void clickingViewCartButton(){
        viewCartButton.click();
    }
    public void validatingHeaderWomenTopsProductsHeader(String header){
        Assert.assertEquals(header,BrowserUtils.getText(headerWomenTopsProducts));
    }
    public void validatingHeaderMenJeansProducts(String header){
        Assert.assertEquals(header,BrowserUtils.getText(headerMenJeansProducts));
    }
    public void validatingBrandsVisibility(String brandsHeader){
        Assert.assertTrue(brands.isDisplayed());
        Assert.assertEquals(brandsHeader,BrowserUtils.getText(brands));
    }
    public void clickingHAndMBrand(){
        hAndMBrand.click();
    }
    public void validatingBrandHAndMProductsDisplayed(String header){
        Assert.assertTrue(headerBrandHAndMProducts.isDisplayed());
        Assert.assertEquals(header,BrowserUtils.getText(headerBrandHAndMProducts));
    }
    public void clickingKookieKidsBrand(){
        kookieKidsBrand.click();
    }
    public void validatingHeaderBrandKookieKidsProducts(String header){
        Assert.assertEquals(header,BrowserUtils.getText(headerBrandKookieKidsProducts));
        for (WebElement product:allProducts){
            Assert.assertTrue(product.isDisplayed());
        }
    }
    public void validatingHeader(String header){
        Assert.assertEquals(header,BrowserUtils.getText(headerAllProducts));
    }
    public void searchingProduct(String product){
        this.searchBar.sendKeys(product);
        searchSubmit.click();
    }
    public void validatingHeaderAndProducts(String header,String product){
        Assert.assertEquals(header,BrowserUtils.getText(headerSearchedProducts));
        for (WebElement jeans:allProducts) {
           Assert.assertTrue(BrowserUtils.getText(jeans).contains(product));
        }
    }
    public void addingAllProductsAndClickingCartButton(WebDriver driver) throws InterruptedException {
        Thread.sleep(9000);
        //Actions actions = new Actions(driver);
    for (int i = 0;i< allProducts.size();i++){
        //actions.moveToElement(allProducts.get(i)).perform();
        addToCartButtons.get(i).click();
        continueShoppingButton.click();
        }
    }
    public void validatingReviewHeader(String header){
        Assert.assertEquals(header,BrowserUtils.getText(headerWriteYourReview));
    }
    public void fillingNameEmailReviewAndSubmit(String name,String email,String review){
        this.reviewName.sendKeys(name);
        this.reviewEmail.sendKeys(email);
        this.addReview.sendKeys(review);
        reviewSubmitButton.click();
    }
    public void validatingSuccessMessage(String message){
        Assert.assertEquals(message,BrowserUtils.getText(reviewSuccessMessage));
    }
}
