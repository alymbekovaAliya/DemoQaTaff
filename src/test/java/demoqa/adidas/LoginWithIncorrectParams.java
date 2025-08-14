package demoqa.adidas;

import demoqa.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithIncorrectParams extends BaseTest {

    @Test
    public void loginWithIncorrectParams() {
        browserManager.open("https://automationexercise.com/");

        Assert.assertTrue(homePage.homeOrange.isDisplayed());

        webElementActions.click(homePage.signUp);

        Assert.assertTrue(loginPage.loginHeader.isDisplayed());

        webElementActions.type(loginPage.loginEmailInput, "some@gmail.com")
                .type(loginPage.loginPasswordInput, "some").click(loginPage.loginButton);

        Assert.assertTrue(loginPage.warningIncorrectParams.isDisplayed());
    }
}
