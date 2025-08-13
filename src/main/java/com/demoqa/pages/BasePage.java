package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebElementActions actions = new WebElementActions();

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
