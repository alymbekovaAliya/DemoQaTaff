package com.demoqa.pages.adidas;

import com.demoqa.drivers.DriverManager;
import com.demoqa.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    public WebElement enterAccountInformationHeader;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "days")
    public WebElement selectDays;

    @FindBy(id = "months")
    public WebElement selectMonths;

    @FindBy(id = "years")
    public WebElement selectYears;

    @FindBy(id = "newsletter")
    public WebElement checkboxNewsletter;

    @FindBy(id = "optin")
    public WebElement checkboxOption;

    @FindBy(id = "first_name")
    public WebElement firstNameInput;

    @FindBy(id = "last_name")
    public WebElement lastNameInput;

    @FindBy(id = "company")
    public WebElement companyInput;

    @FindBy(id = "address1")
    public WebElement address1Input;

    @FindBy(id = "address2")
    public WebElement address2Input;

    @FindBy(id = "country")
    public WebElement countrySelect;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "zipcode")
    public WebElement zipcode;

    @FindBy(id = "mobile_number")
    public WebElement mobile_number;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountButton;

    public SignUpPage selectCounty(String country) {
        actions.selectByText(countrySelect, country);
        return this;
    }

    public SignUpPage selectDateMonthYearCalendar(String dateMonthYear) {

        String[] dateMonthYearParts = dateMonthYear.split(" ");
        String day = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];

        actions.selectByText(selectDays, day);
        actions.selectByText(selectMonths, month);
        actions.selectByText(selectYears, year);

        return this;
    }

    public SignUpPage titleFill(String gender) {
       WebElement element = DriverManager.getDriver().findElement(By.xpath("//input[@value='"+ gender +"']"));
       actions.click(element);
       return this;
    }
}
