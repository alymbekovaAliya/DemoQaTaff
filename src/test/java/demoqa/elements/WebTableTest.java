package demoqa.elements;
import demoqa.BaseTest;
import org.testng.annotations.Test;

public class WebTableTest extends BaseTest {

    @Test
    public void testWebTable() {
        browserManager.open("https://demoqa.com/webtables");

        for(int i = 0; i < 3; i++) {
            webElementActions.click(webTablesPage.addNewRecordButton)
                    .type(webTablesPage.firstName, dataService.generateRandomFirstName())
                    .type(webTablesPage.lastName, dataService.generateRandomLastName())
                    .type(webTablesPage.userEmail, dataService.generateRandomEmail())
                    .type(webTablesPage.age, dataService.generateRandomAge())
                    .type(webTablesPage.salary, dataService.generateRandomDigits())
                    .type(webTablesPage.department, "it")
                    .click(webTablesPage.submit);
        }

        webTablesPage.addEntity().forEach(e -> {
            System.out.println("firstName: " + e.getFirstName() +
                    "\nlastName: " + e.getLastName() +
                    "\nuserEmail: " + e.getEmail() +
                    "\nage: " + e.getAge() +
                    "\nsalary: " + e.getSalary() +
                    "\ndepartment: " + e.getDepartment());
            System.out.println("----------------------------------------------");
        });
    }
}
