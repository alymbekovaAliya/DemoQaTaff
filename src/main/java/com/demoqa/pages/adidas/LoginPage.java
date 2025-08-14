package com.demoqa.pages.adidas;

import com.demoqa.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement signUpHeaderIsVisible;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginHeader;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement signUpName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement signUpEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginEmailInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement loginPasswordInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    public WebElement warningIncorrectParams;

    @Step("fill user name {0}")
    public LoginPage fillName(String username) {
        actions.type(signUpName, username);
        return this;
    }

    @Step("fill email {0}")
    public LoginPage fillEmail(String userEmail) {
        actions.type(signUpEmail, userEmail);
        return this;
    }

    @Step("click sign up btn")
    public SignUpPage clickSignupBtn() {
        actions.click(signUpButton);
        return new SignUpPage();
    }
}
