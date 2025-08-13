package demoqa.elements;
import demoqa.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {

    @Test
    @Description("Select Random State")
    @Owner("Aliia")
    @Issue("Jira 123")
    @Link("www.google.com")
    @Severity(SeverityLevel.CRITICAL)
    public void dateOfBirthTest() {
        browserManager.open("https://demoqa.com/automation-practice-form");

        practiceFormPage.selectRandomState();
    }
}
