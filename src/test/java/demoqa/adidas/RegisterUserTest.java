package demoqa.adidas;

import com.demoqa.enums.Title;
import com.demoqa.pages.adidas.HomePage;
import demoqa.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.qameta.allure.Allure.step;

public class RegisterUserTest extends BaseTest {

    @Test
    @Description("Register user")
    @Owner("Aliia")
    @Severity(SeverityLevel.BLOCKER)
    public void registerUserTest() {

        var loginPage = open(HomePage.class).verifyPageIsLoaded().clickSignUp();

        SoftAssert softAssert = new SoftAssert();
        step("Проверка присутствия текста New User Signup!", () -> {
                    softAssert.assertEquals(loginPage.signUpHeaderIsVisible.getText(), "New User Signup!");
                }
        );

        var firstName = dataService.generateRandomFirstName();
        var signupPage = loginPage.fillName(firstName)
                .fillEmail(dataService.generateRandomEmail())
                .clickSignupBtn();

        step("Проверка присутствия текста Enter Account Information", () -> {
                    softAssert.assertEquals(webElementActions.getText(signupPage.enterAccountInformationHeader), "ENTER ACCOUNT INFORMATION", "значения не совпадают!");
                }
        );



        var accountCreatedPage = signupPage.titleFill(Title.MR)
                .enterNewPassword(dataService.generateRandomPassword())
                .selectDateMonthYearCalendar("19 March 1996")
                .clickCheckboxNewsletter()
                .clickCheckboxOption()
                .fillFirstName(firstName)
                .fillLastName(dataService.generateRandomLastName())
                .enterCompanyName(dataService.generateRandomCompany())
                .fillAddress(dataService.generateRandomAddress())
                .fillAddress2(dataService.generateRandomAddress())
                .selectCounty("India")
                .fillState(dataService.generateRandomState())
                .fillCity(dataService.generateRandomCity())
                .fillZipCode(dataService.generateRandomZipcode())
                .fillMobileNumber(dataService.generateRandomNumber())
                .clickCreateAccount();

        step("Проверка присутствия текста ACCOUNT CREATED!", () -> {
                    softAssert.assertEquals(webElementActions.getText(accountCreatedPage.accountCreatedIsVisible), "ACCOUNT CREATED!", "значения не совпадают!");
                }
        );

        var homePage = accountCreatedPage.clickContinueBtn();

        step("Проверка присутствия текста Logged in as username", () -> {
                    softAssert.assertEquals(webElementActions.getText(homePage.loggedInAsUsernameIsVisible), "Logged in as " + firstName, "значения не совпадают!");
                }
        );

        var deleteAccountPage = homePage.clickDeleteAccBtn();

        step("Проверка присутствия текста ACCOUNT DELETED!", () -> {
                    softAssert.assertEquals(webElementActions.getText(deleteAccountPage.accountDeletedIsVisible), "ACCOUNT DELETED!", "значения не совпадают!");
                }
        );

        deleteAccountPage.clickContinueBtn().verifyPageIsLoaded();

        softAssert.assertAll();
    }

}
