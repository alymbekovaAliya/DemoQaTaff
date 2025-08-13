package com.demoqa.pages.elements;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends BasePage {

    @FindBy(xpath = "//button[@title='Expand all']")
    public WebElement expandAll;

    @FindBy(xpath = "//span[text()='Home']")
    public WebElement home;

    @FindBy(xpath = "//span[text()='Desktop']")
    public WebElement desktop;

    @FindBy(xpath = "//span[text()='Documents']")
    public WebElement documents;

    @FindBy(xpath = "//span[text()='Downloads']")
    public WebElement downloads;

    //то что в desktop
    @FindBy(xpath = "//span[text()='Notes']")
    public WebElement notes;

    @FindBy(xpath = "//span[text()='Commands']")
    public WebElement commands;

    //то что в documents
    @FindBy(xpath = "//span[text()='WorkSpace']")
    public WebElement workSpace;

    //documents -> workSpace -
    @FindBy(xpath = "//span[text()='React']")
    public WebElement react;

    @FindBy(xpath = "//span[text()='Angular']")
    public WebElement angular;

    @FindBy(xpath = "//span[text()='Veu']")
    public WebElement veu;

    //documents
    @FindBy(xpath = "//span[text()='Office']")
    public WebElement office;

    //documents -> office
    @FindBy(xpath = "//span[text()='Public']")
    public WebElement publicFile;

    @FindBy(xpath = "//span[text()='Private']")
    public WebElement privateFile;

    @FindBy(xpath = "//span[text()='Classified']")
    public WebElement classified;

    @FindBy(xpath = "//span[text()='General']")
    public WebElement general;

    //downloads
    @FindBy(xpath = "//span[text()='Word File.doc']")
    public WebElement wordFile;

    @FindBy(xpath = "//span[text()='Excel File.doc']")
    public WebElement excelFile;

    @FindBy(xpath = "//div[@id='result']/descendant::span[text()='home']")
    public WebElement resultHome;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='desktop']")
    public WebElement resultDesktop;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='notes']")
    public WebElement resultNotes;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='commands']")
    public WebElement resultCommands;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='documents']")
    public WebElement resultDocuments;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='workspace']")
    public WebElement resultWorkspace;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='react']")
    public WebElement resultReact;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='angular']")
    public WebElement resultAngular;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='veu']")
    public WebElement resultVeu;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='office']")
    public WebElement resultOffice;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='public']")
    public WebElement resultPublic;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='private']")
    public WebElement resultPrivate;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='classified']")
    public WebElement resultClassified;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='general']")
    public WebElement resultGeneral;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='downloads']")
    public WebElement resultDownloads;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='wordFile']")
    public WebElement resultWordFile;

    @FindBy(xpath = "//div[contains(@id, 'result')]//span[text()='excelFile']")
    public WebElement resultExelFile;

    public CheckBoxPage clickTextBoxElement(WebElement element) {
        actions.click(element);
        return this;
    }

}
