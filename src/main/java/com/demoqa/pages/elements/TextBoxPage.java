package com.demoqa.pages.elements;
import com.demoqa.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {

    @FindBy(id = "userName")
    public WebElement userName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddress;

    @FindBy(id = "submit")
    public WebElement submit;

    @FindBy(id = "name")
    public WebElement resultName;

    @FindBy(id = "email")
    public WebElement resultEmail;

    @FindBy(css = "p#currentAddress")
    public WebElement resultCurrentAddress;

    @FindBy(css = "p#permanentAddress")
    public WebElement resultPermanentAddress;

    @Step("Input username {0}")
    public TextBoxPage inputUserName(String name) {
        actions.type(userName, name);
        return this;
    }
    @Step("Input user email {0}")
    public TextBoxPage inputUserEmail(String email) {
             actions.type(userEmail, email);
        return this;
    }

    @Step("Input current address {0}")
    public TextBoxPage inputCurrentAddress(String address) {
        actions.type(currentAddress, address);
        return this;
    }

    @Step("Input permanent address {0}")
    public TextBoxPage inputPermanentAddress(String address) {
        actions.type(permanentAddress, address);
        return this;
    }

    @Step("Input click submit button")
    public TextBoxPage clickSubmit() {
        actions.click(submit);
        return this;
    }
}
