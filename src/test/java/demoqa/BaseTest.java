package demoqa;

import com.demoqa.data.MockDataService;
import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.BrowserManager;
import com.demoqa.helper.WebElementActions;
import com.demoqa.pages.adidas.*;
import com.demoqa.pages.elements.*;
import com.demoqa.pages.elements.browserWindow.BrowserWindows;
import com.demoqa.pages.elements.widgets.SelectMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public MockDataService dataService;
    public WebDriver driver;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public BrowserWindows browserWindows;
    public BrowserManager.WindowHelper windowHelper;
    public BrowserManager browserManager;
    public BrowserManager.IframeManager iframeManager;
    public SelectMenuPage  selectMenuPage;
    public WebElementActions webElementActions;
    public Buttons buttons;
    public WebTablesPage webTablesPage;
    public PracticeFormPage practiceFormPage;
    public LeftSideMenu leftSideMenu;
    public HomePage homePage;
    public SignUpPage signUpPage;
    public LoginPage loginPage;
    public AccountCreatedPage accountCreatedPage;
    public DeleteAccountPage deleteAccount;

    @BeforeClass(alwaysRun = true)
    public void setupBrowser() {
        driver = DriverManager.getDriver();
        textBoxPage = new TextBoxPage();
        checkBoxPage = new CheckBoxPage();
        dataService = new MockDataService();
        browserWindows = new BrowserWindows();
        windowHelper = new BrowserManager.WindowHelper(driver);
        browserManager = new BrowserManager(driver);
        iframeManager = new BrowserManager.IframeManager(driver);
        selectMenuPage = new SelectMenuPage();
        webElementActions = new WebElementActions();
        buttons = new Buttons();
        webTablesPage = new WebTablesPage();
        practiceFormPage = new PracticeFormPage();
        leftSideMenu = new LeftSideMenu();
        homePage = new HomePage();
        signUpPage = new SignUpPage();
        loginPage = new LoginPage();
        accountCreatedPage = new AccountCreatedPage();
        deleteAccount = new DeleteAccountPage();
    }

    public <T> T open(Class<T> pageClass) {
        driver.get("https://automationexercise.com/");
        return PageFactory.initElements(driver, pageClass);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.closeDriver();
    }

    public String formatText(String text) {
        return  text.substring(text.indexOf(':') + 1).trim();
    }
}
