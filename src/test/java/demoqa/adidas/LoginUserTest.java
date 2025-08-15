package demoqa.adidas;
import com.demoqa.enums.Title;
import com.demoqa.pages.adidas.HomePage;
import demoqa.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.qameta.allure.Allure.step;

public class LoginUserTest extends BaseTest {

    @Test
    @Description("Login User with correct data")
    @Owner("Aliia")
    @Issue("Home work")
    @Link("https://automationexercise.com/test_cases#collapse1")
    @Severity(SeverityLevel.BLOCKER)
    public void loginUserWithCorrectDataTest() {
        String userEmail = dataService.generateRandomEmail();
        String userPassword = dataService.generateRandomPassword();
        String userName = dataService.generateRandomFirstName();

        var loginPage = open(HomePage.class).verifyPageIsLoaded().clickSignUpLogin();

        SoftAssert softAssert = new SoftAssert();
        step("Проверка присутствия текста New User Signup!", () -> {
                    softAssert.assertEquals(loginPage.signUpHeaderIsVisible.getText(), "New User Signup!");
                }
        );

        var signupPage = loginPage.fillName(userEmail)
                .fillEmail(userEmail)
                .clickSignupBtn();

        step("Проверка присутствия текста Enter Account Information", () -> {
                    softAssert.assertEquals(webElementActions.getText(signupPage.enterAccountInformationHeader), "ENTER ACCOUNT INFORMATION", "значения не совпадают!");
                }
        );

        var accountCreatedPage = signupPage.titleFill(Title.MR)
                .enterNewPassword(userPassword)
                .selectDateMonthYearCalendar("19 March 1996")
                .clickCheckboxNewsletter()
                .clickCheckboxOption()
                .fillFirstName(userName)
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
                    softAssert.assertEquals(webElementActions.getText(homePage.loggedInAsUsernameIsVisible), "Logged in as " + userEmail, "значения не совпадают!");
                }
        );

        homePage.clickLogOutBtn();

        homePage.clickSignUpLogin();


        step("Проверка присутствия текста Login to your account", () -> {
                    softAssert.assertEquals(webElementActions.getText(loginPage.loginHeader), "Login to your account", "Данные не совпадают");
                }
        );

        loginPage.login(userEmail, userPassword);

        step("Проверка присутствия текста Logged in as username", () -> {
                    softAssert.assertEquals(webElementActions.getText(homePage.loggedInAsUsernameIsVisible), "Logged in as " + userEmail, "значения не совпадают!");
                }
        );

        var deleteAccountPage = homePage.clickDeleteAccBtn();

        step("Проверка присутствия текста ACCOUNT DELETED!", () -> {
                    softAssert.assertEquals(webElementActions.getText(deleteAccountPage.accountDeletedIsVisible), "ACCOUNT DELETED!", "значения не совпадают!");
                }
        );

        softAssert.assertAll();
    }

    @Test
    @Description("Login User with incorrect data")
    @Owner("Aliia")
    @Issue("Home work")
    @Link("https://automationexercise.com/test_cases#collapse3")
    @Severity(SeverityLevel.BLOCKER)
    public void loginUserWithIncorrectDataTest() {
        String userEmail = dataService.generateRandomEmail();
        String userPassword = dataService.generateRandomPassword();

        var loginPage = open(HomePage.class).verifyPageIsLoaded().clickSignUpLogin();

        SoftAssert softAssert = new SoftAssert();
        step("Проверка присутствия текста Login to your account", () -> {
                    softAssert.assertEquals(webElementActions.getText(loginPage.loginHeader), "Login to your account");
                }
        );

        loginPage.login(userEmail, userPassword);

        step("Проверка присутствия текста Your email or password is incorrect!", () -> {
                    softAssert.assertEquals(webElementActions.getText(loginPage.warningIncorrectParams), "Your email or password is incorrect!", "значения не совпадают!");
                }
        );

        softAssert.assertAll();
    }

    @Test
    @Description("Logout User")
    @Owner("Aliia")
    @Issue("Home work")
    @Link("https://automationexercise.com/test_cases#collapse1")
    @Severity(SeverityLevel.BLOCKER)
    public void logoutUserTest() {
        String userEmail = dataService.generateRandomEmail();
        String userPassword = dataService.generateRandomPassword();
        String userName = dataService.generateRandomFirstName();

        var loginPage = open(HomePage.class).verifyPageIsLoaded().clickSignUpLogin();

        SoftAssert softAssert = new SoftAssert();
        step("Проверка присутствия текста New User Signup!", () -> {
                    softAssert.assertEquals(loginPage.signUpHeaderIsVisible.getText(), "New User Signup!");
                }
        );

        var signupPage = loginPage.fillName(userEmail)
                .fillEmail(userEmail)
                .clickSignupBtn();

        step("Проверка присутствия текста Enter Account Information", () -> {
                    softAssert.assertEquals(webElementActions.getText(signupPage.enterAccountInformationHeader), "ENTER ACCOUNT INFORMATION", "значения не совпадают!");
                }
        );

        var accountCreatedPage = signupPage.titleFill(Title.MR)
                .enterNewPassword(userPassword)
                .selectDateMonthYearCalendar("19 March 1996")
                .clickCheckboxNewsletter()
                .clickCheckboxOption()
                .fillFirstName(userName)
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
                    softAssert.assertEquals(webElementActions.getText(homePage.loggedInAsUsernameIsVisible), "Logged in as " + userEmail, "значения не совпадают!");
                }
        );

        homePage.clickLogOutBtn();

        homePage.clickSignUpLogin();


        step("Проверка присутствия текста Login to your account", () -> {
                    softAssert.assertEquals(webElementActions.getText(loginPage.loginHeader), "Login to your account", "Данные не совпадают");
                }
        );

        loginPage.login(userEmail, userPassword);

        step("Проверка присутствия текста Logged in as username", () -> {
                    softAssert.assertEquals(webElementActions.getText(homePage.loggedInAsUsernameIsVisible), "Logged in as " + userEmail, "значения не совпадают!");
                }
        );

        homePage.clickLogOutBtn();

        step("Проверка присутствия текста Login to your account", () -> {
                    softAssert.assertEquals(webElementActions.getText(loginPage.loginHeader), "Login to your account", "Данные не совпадают");
                }
        );

        softAssert.assertAll();
    }

    @Test
    @Description("Register User With Existing Email")
    @Owner("Aliia")
    @Issue("Home work")
    @Link("https://automationexercise.com/test_cases#collapse1")
    @Severity(SeverityLevel.BLOCKER)
    public void registerUserWithExistingEmail() {
        String userEmail = dataService.generateRandomEmail();
        String userPassword = dataService.generateRandomPassword();
        String userName = dataService.generateRandomFirstName();

        var loginPage = open(HomePage.class).verifyPageIsLoaded().clickSignUpLogin();

        SoftAssert softAssert = new SoftAssert();
        step("Проверка присутствия текста New User Signup!", () -> {
                    softAssert.assertEquals(loginPage.signUpHeaderIsVisible.getText(), "New User Signup!");
                }
        );

        var signupPage = loginPage.fillName(userEmail)
                .fillEmail(userEmail)
                .clickSignupBtn();

        step("Проверка присутствия текста Enter Account Information", () -> {
                    softAssert.assertEquals(webElementActions.getText(signupPage.enterAccountInformationHeader), "ENTER ACCOUNT INFORMATION", "значения не совпадают!");
                }
        );

        var accountCreatedPage = signupPage.titleFill(Title.MR)
                .enterNewPassword(userPassword)
                .selectDateMonthYearCalendar("19 March 1996")
                .clickCheckboxNewsletter()
                .clickCheckboxOption()
                .fillFirstName(userName)
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
                    softAssert.assertEquals(webElementActions.getText(homePage.loggedInAsUsernameIsVisible), "Logged in as " + userEmail, "значения не совпадают!");
                }
        );

        homePage.clickLogOutBtn();

        loginPage.switchToHomePage();

        //перейти на homepage

        homePage.clickSignUpLogin();

        step("Проверка присутствия текста New User Signup!", () -> {
                    softAssert.assertEquals(webElementActions.getText(loginPage.signUpHeaderIsVisible), "New User Signup!");
                }
        );

        loginPage.fillName(userEmail)
                .fillEmail(userEmail)
                .clickSignupBtn();


        step("Проверка присутствия текста Email Address already exist!", () -> {
                    softAssert.assertEquals(webElementActions.getText(loginPage.warningEmailAlreadyExist), "Email Address already exist!", "прошла регистрация с существующим email");
                }
        );

        softAssert.assertAll();
    }
}
