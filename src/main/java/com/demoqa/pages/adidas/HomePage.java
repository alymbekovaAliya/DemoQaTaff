package com.demoqa.pages.adidas;

import com.demoqa.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@href='/' and contains(@style, 'orange')]")
    public WebElement homeOrange;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signUp;

    @FindBy(xpath = "//a[text()=' Logged in as ']")
    public WebElement loggedInAsUsernameIsVisible;

    @FindBy(xpath = "//a[@href ='/delete_account']")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//i[@class='fa fa-lock']")
    public WebElement logout;

    @FindBy(xpath = "//a[normalize-space(text())='Contact us']")
    public WebElement contactUsBtn;

    @Step("click sign up btn")
    public LoginPage clickSignUpLogin() {
        actions.click(signUp);
        return new LoginPage();
    }

    @Step("verify home page is displayed")
    public HomePage verifyPageIsLoaded() {
        Assert.assertEquals(homeOrange.getAttribute("style"), "color: orange;");
        return this;
    }

    @Step("click delete account btn")
    public DeleteAccountPage clickDeleteAccBtn(){
        actions.click(deleteAccountButton);
        return new DeleteAccountPage();
    }

    @Step("click logout")
    public LoginPage clickLogOutBtn() {
        actions.click(logout);
        return new LoginPage();
    }

    @Step("click contact us")
    public ContactUpPage clickContactUs() {
        actions.click(contactUsBtn);
        return  new ContactUpPage();
    }
}


