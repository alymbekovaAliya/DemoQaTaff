package demoqa.adidas;
import demoqa.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginUserWithCorrectParamsTest extends BaseTest {

    @Test
    public void loginUserWithCorrectParamsTest() {

        final String email = "aliia1@gmail.com";
        final String password = "1234";

        browserManager.open("https://automationexercise.com/");

        Assert.assertTrue(homePage.homeOrange.isDisplayed());

        webElementActions.click(homePage.signUp);

        Assert.assertTrue(loginPage.loginHeader.isDisplayed());

        webElementActions.type(loginPage.loginEmailInput, email)
                .type(loginPage.loginPasswordInput, password).click(loginPage.loginButton);

        Assert.assertTrue(homePage.loggedInAsUsernameIsVisible.isDisplayed());

        webElementActions.click(homePage.deleteAccountButton);

        Assert.assertTrue(deleteAccount.accountDeletedIsVisible.isDisplayed());
    }
}
