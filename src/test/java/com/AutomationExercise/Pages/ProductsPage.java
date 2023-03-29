package com.AutomationExercise.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
}
