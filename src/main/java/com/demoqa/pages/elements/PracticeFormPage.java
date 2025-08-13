package com.demoqa.pages.elements;

import com.demoqa.drivers.DriverManager;
import com.demoqa.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class PracticeFormPage extends BasePage {

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;

    @FindBy(css = ".react-datepicker__month-select")
    public WebElement monthSelect;

    @FindBy(css = ".react-datepicker__year-select")
    public WebElement yearSelect;

    @FindBy(xpath = "//div[text()='Select State']")
    public WebElement selectState;

    @FindBy(xpath = "//div[contains(@id, 'react-select-3-option')]")
    public List<WebElement> listOfSelectStates;

    @FindBy(xpath = "//div[text()='Select City']")
    public WebElement selectCity;

    @FindBy(xpath = "//div[contains(@id, 'react-select-4-option')]")
    public List<WebElement> listOfSelectCity;

    public PracticeFormPage selectRandomState() {
        actions.click(selectState);

        Random random = new Random();

        if(!listOfSelectStates.isEmpty()) {
            int randomNumber = random.nextInt(listOfSelectStates.size());
            System.out.println(listOfSelectStates.get(randomNumber).getText());
            actions.click(listOfSelectStates.get(randomNumber));
        }

        actions.click(selectCity);

        if(!listOfSelectCity.isEmpty()) {
            int randomNumber2 = random.nextInt(listOfSelectCity.size());
            System.out.println(listOfSelectCity.get(randomNumber2).getText());
            actions.click(listOfSelectCity.get(randomNumber2));
        }

        return this;
    }

    public PracticeFormPage selectDateMonthYearCalendar(String dateMonthYear) {

        String[] dateMonthYearParts = dateMonthYear.split(" ");
        String day = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];

        actions.click(dateOfBirthInput);
        actions.selectByText(monthSelect, month);
        actions.selectByText(yearSelect, year);

        WebElement dayElement = DriverManager.getDriver().findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and not(contains(@class, 'react-datepicker__day--outside-month')) and text()='" + day + "']"));

        actions.click(dayElement);

        return this;
    }
}
