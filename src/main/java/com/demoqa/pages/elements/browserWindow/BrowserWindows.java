package com.demoqa.pages.elements.browserWindow;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindows extends BasePage {

    @FindBy(id = "tabButton")
     public WebElement tabButton;

    public BrowserWindows clickTab() {
        actions.click(tabButton);
        return this;
    }
}
