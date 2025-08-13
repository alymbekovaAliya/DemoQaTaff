package com.demoqa.pages.elements;

import com.demoqa.entities.Employee;
import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WebTablesPage extends BasePage {

    @FindBy(xpath = "//div[@role='gridcell']")
    public List<WebElement> allElementInRow;

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewRecordButton;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "age")
    public WebElement age;

    @FindBy(id = "salary")
    public WebElement salary;

    @FindBy(id = "department")
    public WebElement department;

    @FindBy(id = "submit")
    public WebElement submit;


    public List<Employee> addEntity() {
        List<Employee> employeeList = new ArrayList<>();

        for(int i = 0; i < allElementInRow.size(); i+=7) {
            if(!allElementInRow.get(i).getText().equals(" ")) {
                employeeList.add(new Employee(
                        allElementInRow.get(i).getText(),
                        allElementInRow.get(i + 1).getText(),
                        Integer.parseInt(allElementInRow.get(i + 2).getText()),
                        allElementInRow.get(i + 3).getText(),
                        Integer.parseInt(allElementInRow.get(i + 4).getText()),
                        allElementInRow.get(i + 5).getText()
                ));
            }

        }

        return employeeList;

    }

}
