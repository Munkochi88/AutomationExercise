package com.AutomationExercise.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class SignupLoginPage {
    public SignupLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2[.='Login to your account']")
    WebElement loginHeader;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement loginPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//h2[.='New User Signup!']")
    WebElement signupHeader;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement signupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupButton;

    @FindBy(xpath = "//p[.='Your email or password is incorrect!']")
    WebElement incorrectEmailOrPasswordMessage;

    @FindBy(xpath = "//p[.='Email Address already exist!']")
    WebElement emailAlreadyExistMessage;

    public void signup(){
        signupName.sendKeys("Jolie");
        signupEmail.sendKeys("jol@gmail.com");
        signupButton.click();
    }
    public void login(){
        loginEmail.sendKeys(ConfigReader.readProperty("loginEmail"));
        loginPassword.sendKeys(ConfigReader.readProperty("loginPassword"));
        loginButton.click();
    }
}
