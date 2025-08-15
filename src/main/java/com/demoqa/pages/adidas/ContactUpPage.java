package com.demoqa.pages.adidas;

import com.demoqa.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUpPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    public WebElement getInTouch;

    @FindBy(xpath = "//input[@name = 'name']")
    public WebElement inputName;

    @FindBy(xpath = "//input[@name = 'email']")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@name = 'subject']")
    public WebElement inputSubject;

    @FindBy(xpath = "//textarea[@id = 'message']")
    public WebElement inputMessage;

    @FindBy(xpath = "//input[@data-qa='submit-button']")
    public WebElement submitBtn;

    @FindBy(xpath = "//input[@name = 'upload_file']")
    public WebElement uploadFile;

    @Step("input user name")
    public ContactUpPage fillInputName(String name) {
        actions.type(inputName,name );
        return  this;
    }

    @Step("input user email")
    public ContactUpPage fillInputEmail(String email) {
        actions.type(inputEmail,email);
        return  this;
    }

    @Step("input user subject")
    public ContactUpPage fillInputSubject(String subject) {
        actions.type(inputSubject,subject);
        return  this;
    }

    @Step("input user subject")
    public ContactUpPage fillMessage(String message) {
        actions.type(inputMessage,message);
        return  this;
    }

    @Step("upload file")
    public ContactUpPage uploadFile(String path) {
        actions.type(uploadFile, path);
        uploadFile.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("click submit")
    public ContactUpPage clickSubmit() {
        actions.click(submitBtn);
        return this;
    }

    @Step("accept alert")
    public ContactUpPage clickAlertAccept() {
        actions.click(submitBtn);
        return this;
    }


}
