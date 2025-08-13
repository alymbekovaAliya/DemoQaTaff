package demoqa.adidas;

import demoqa.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserTest extends BaseTest {

    @Test
    public void registerUserTest() {
        browserManager.open("https://automationexercise.com/");

        Assert.assertTrue(homePage.homeOrange.isDisplayed());

        webElementActions.click(homePage.signUp);

        Assert.assertTrue(loginPage.signUpHeaderIsVisible.isDisplayed());

        webElementActions.type(loginPage.signUpName, dataService.generateRandomFirstName())
                .type(loginPage.signUpEmail, dataService.generateRandomEmail())
                .click(loginPage.signUpButton);

        Assert.assertTrue(signUpPage.enterAccountInformationHeader.isDisplayed());

        signUpPage.titleFill("Mr");
        webElementActions.type(signUpPage.password, dataService.generateRandomPassword());
        signUpPage.selectDateMonthYearCalendar("25 January 2000");

        webElementActions.click(signUpPage.checkboxNewsletter)
                .click(signUpPage.checkboxOption);

        webElementActions.scrollToElement(signUpPage.firstNameInput);

        webElementActions.type(signUpPage.firstNameInput, dataService.generateRandomFirstName())
                .type(signUpPage.lastNameInput, dataService.generateRandomLastName())
                .type(signUpPage.companyInput, dataService.generateRandomCompany())
                .type(signUpPage.address1Input, dataService.generateRandomAddress())
                .type(signUpPage.address2Input, dataService.generateRandomAddress());

        signUpPage.selectCounty("India");

        webElementActions.type(signUpPage.state, dataService.generateRandomState())
                .type(signUpPage.city, dataService.generateRandomCity())
                .type(signUpPage.zipcode, dataService.generateRandomZipcode())
                .type(signUpPage.mobile_number, dataService.generateRandomNumber())
                .click(signUpPage.createAccountButton);

        Assert.assertTrue(accountCreatedPage.accountCreatedIsVisible.isDisplayed());

        webElementActions.click(accountCreatedPage.continueButton);

        Assert.assertTrue(homePage.loggedInAsUsernameIsVisible.isDisplayed());

        webElementActions.click(homePage.deleteAccountButton);

        Assert.assertTrue(deleteAccount.accountDeletedIsVisible.isDisplayed());

        webElementActions.click(deleteAccount.continueButton);

    }

}
