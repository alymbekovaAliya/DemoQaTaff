package com.demoqa.pages.adidas;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccount extends BasePage {

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    public WebElement accountDeletedIsVisible;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;
}
