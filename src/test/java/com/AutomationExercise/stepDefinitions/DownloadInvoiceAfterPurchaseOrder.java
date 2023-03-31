package com.AutomationExercise.stepDefinitions;

import com.AutomationExercise.Pages.PaymentPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class DownloadInvoiceAfterPurchaseOrder {
    WebDriver driver = DriverHelper.getDriver();
    PaymentPage paymentPage = new PaymentPage(driver);


    @When("User click download invoice button and validate invoice is downloaded successfully and click continue Button")
    public void user_click_download_invoice_button_and_validate_invoice_is_downloaded_successfully_and_click_continue_button() {
        paymentPage.clickDownloadInvoiceButtonAndVerifyInvoiceDownloadedAndClickContinueButton();
        File downloadedFile = new File("/Users/narmandakhsumiya/Downloads/invoice.txt");
        System.out.println(downloadedFile.getPath());
        System.out.println(downloadedFile.getName());
        assertTrue(downloadedFile.exists());
        assertTrue(downloadedFile.length() > 0);
    }
}
