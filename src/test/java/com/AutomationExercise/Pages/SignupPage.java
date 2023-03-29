package com.AutomationExercise.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class SignupPage {
    public SignupPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//b[.='Enter Account Information']")
    WebElement headerSignupPage;

    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement genderMr;

    @FindBy(css = "#name")
    WebElement name;

    @FindBy(css = "#password")
    WebElement password;

    @FindBy(css = "#days")
    WebElement dateOfBirthDaySelect;

    @FindBy(css = "#months")
    WebElement dateOfBirthMonthSelect;

    @FindBy(css = "#years")
    WebElement dateOfBirthYearSelect;

    @FindBy(css = "#newsletter")
    WebElement newsletterCheckbox;

    @FindBy(css = "#optin")
    WebElement optInCheckbox;

    @FindBy(css = "#first_name")
    WebElement firstName;

    @FindBy(css = "#last_name")
    WebElement lastName;

    @FindBy(css = "#company")
    WebElement company;

    @FindBy(css = "#address1")
    WebElement address1;

    @FindBy(css = "#address2")
    WebElement address2;

    @FindBy(css = "#country")
    WebElement countrySelect;

    @FindBy(css = "#state")
    WebElement state;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#zipcode")
    WebElement zipCode;

    @FindBy(css = "#mobile_number")
    WebElement mobileNumber;

    @FindBy(xpath = "//button[.='Create Account']")
    WebElement createAccountButton;

    @FindBy(xpath = "//b[.='Account Created!']")
    WebElement headerAccountCreated;

    @FindBy(xpath = "//a[.='Continue']")
    WebElement continueButton;

    public void creatingAccount(){
        genderMr.click();
        this.password.sendKeys("1234");
        BrowserUtils.selectBy(dateOfBirthDaySelect,"1","text");
        BrowserUtils.selectBy(dateOfBirthMonthSelect,"1","value");
        BrowserUtils.selectBy(dateOfBirthYearSelect,"2000","text");
        newsletterCheckbox.click();
        optInCheckbox.click();
        this.firstName.sendKeys("M");
        this.lastName.sendKeys("O");
        this.company.sendKeys("Hopper");
        this.address1.sendKeys("1 hopper dr");
        this.address2.sendKeys("suite 1");
        BrowserUtils.selectBy(countrySelect,"United States","text");
        this.state.sendKeys("IL");
        this.city.sendKeys("Chicago");
        this.zipCode.sendKeys("60018");
        this.mobileNumber.sendKeys("5755");
        createAccountButton.click();
    }
    public void validatingHeader(String header){
        Assert.assertEquals(header,BrowserUtils.getText(headerAccountCreated));
        continueButton.click();
    }
}
