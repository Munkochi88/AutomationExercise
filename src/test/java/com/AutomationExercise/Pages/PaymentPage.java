package com.AutomationExercise.Pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;
import utils.ConfigReader;

import java.time.Duration;
import java.util.function.Function;

public class PaymentPage {
    public PaymentPage(WebDriver driver){
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='name_on_card']")
    WebElement nameOnTheCard;
    @FindBy(xpath = "//input[@name='card_number']")
    WebElement cardNumber;
    @FindBy(xpath = "//input[@name='cvc']")
    WebElement cvc;
    @FindBy(xpath = "//input[@name='expiry_month']")
    WebElement expirationMonth;
    @FindBy(xpath = "//input[@name='expiry_year']")
    WebElement expirationYear;
    @FindBy(css = "#submit")
    WebElement payAndConfirmOrderButton;
    @FindBy(xpath = "//div[@id='success_message']//div")
    WebElement successMessage;
    public void fillingPayment(){
    nameOnTheCard.sendKeys(ConfigReader.readProperty("nameOnCard"));
    cardNumber.sendKeys(ConfigReader.readProperty("cardNumber"));
    cvc.sendKeys(ConfigReader.readProperty("cvc"));
    expirationMonth.sendKeys(ConfigReader.readProperty("expirationMonth"));
    expirationYear.sendKeys(ConfigReader.readProperty("expirationYear"));
    }
    public void clickingPayAndConfirmOrderButton(WebDriver driver) throws InterruptedException {
        BrowserUtils.clickWithJS(driver, payAndConfirmOrderButton);
//        payAndConfirmOrderButton.click();
        driver.navigate().back();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofNanos(10))
                .ignoring(NoSuchElementException.class);

        String successMsg = wait.until(driver1 -> driver1.findElement(By.xpath("//div[@id='success_message']//div"))).getText();
//        String text = successMsg.getText();
        System.out.println("Success message is: "+ successMsg);

    }
    public void validateSuccessfulMessage(WebDriver driver,String successfulMessage){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        this.successMessage=wait.until(ExpectedConditions.visibilityOf(this.successMessage));
        Assert.assertEquals(successfulMessage,this.successMessage.getText());
        driver.navigate().forward();
    }
}
