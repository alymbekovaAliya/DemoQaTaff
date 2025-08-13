package com.demoqa.pages.adidas;
import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@href='/' and contains(@style, 'orange')]")
    public WebElement homeOrange;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signUp;

    @FindBy(xpath = "//a[text()=' Logged in as ']")
    public WebElement loggedInAsUsernameIsVisible;

    @FindBy(xpath = "//a[@href ='/delete_account']")
    public WebElement deleteAccountButton;

//    public boolean verifyHomePageIsDisplayed() {
//       return homeOrange.getAttribute("style").equals("orange");
//    }
}
