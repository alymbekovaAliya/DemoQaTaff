package com.demoqa.pages.elements.widgets;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectMenuPage extends BasePage {

    @FindBy(id = "oldSelectMenu")
    public WebElement oldSelectMenu;

    @FindBy(id = "react-select-2-input")
    public WebElement selectValueInput;

    @FindBy(id = "react-select-3-input")
    public WebElement selectOneInput;

    public void selectValueByText(String value) {
     actions.type(selectValueInput,value);
        selectValueInput.sendKeys(Keys.ENTER);
    }

    public void selectOneByText(String value) {
        actions.type(selectOneInput,value);
        selectOneInput.sendKeys(Keys.ENTER);
    }

}
