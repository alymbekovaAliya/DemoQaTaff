package demoqa.elements;

import demoqa.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBoxText extends BaseTest {

    @BeforeClass
    public void setUp() {
        browserManager.open("https://demoqa.com/checkbox");
        checkBoxPage.clickTextBoxElement(checkBoxPage.expandAll);

        Assert.assertTrue(checkBoxPage.desktop.isDisplayed());
        Assert.assertTrue(checkBoxPage.notes.isDisplayed());
        Assert.assertTrue(checkBoxPage.commands.isDisplayed());
    }


    @Test(priority = 1)
//    @Test
    public void homeTest() {
       checkBoxPage.clickTextBoxElement(checkBoxPage.home);
       Assert.assertEquals(checkBoxPage.resultHome.getText(), "home", "home не выбран");
       Assert.assertEquals(checkBoxPage.resultExelFile.getText(), "excelFile", "home полностью не выбран");
        checkBoxPage.clickTextBoxElement(checkBoxPage.home);
    }

    @Test(priority = 2)
//    @Test
    public void desktopTest() {
        checkBoxPage.clickTextBoxElement(checkBoxPage.desktop);
        Assert.assertEquals(checkBoxPage.resultDesktop.getText(), "desktop", "desktop не выбран");
        Assert.assertEquals(checkBoxPage.resultNotes.getText(), "notes", "notes не выбран");
        Assert.assertEquals(checkBoxPage.resultCommands.getText(), "commands", "commands не выбран");
    }

    @Test(priority = 3)
//    @Test
    public void documentsTest() {
        checkBoxPage.clickTextBoxElement(checkBoxPage.documents);
        Assert.assertEquals(checkBoxPage.resultDocuments.getText(), "documents", "документс не выбран");
        Assert.assertEquals(checkBoxPage.resultWorkspace.getText(), "workspace", "workspace не выбран");
        Assert.assertEquals(checkBoxPage.resultReact.getText(), "react", "react не выбран");
        Assert.assertEquals(checkBoxPage.resultAngular.getText(), "angular", "angular не выбран");
        Assert.assertEquals(checkBoxPage.resultVeu.getText(), "veu", "veu не выбран");

        Assert.assertEquals(checkBoxPage.resultOffice.getText(), "office", "office не выбран");
        Assert.assertEquals(checkBoxPage.resultPublic.getText(), "public", "public не выбран");
        Assert.assertEquals(checkBoxPage.resultPrivate.getText(), "private", "private не выбран");
        Assert.assertEquals(checkBoxPage.resultClassified.getText(), "classified", "classified не выбран");
        Assert.assertEquals(checkBoxPage.resultGeneral.getText(), "general", "general не выбран");
    }

    @Test(priority = 4)
//    @Test
    public void downloadTest() {
        checkBoxPage.clickTextBoxElement(checkBoxPage.downloads);
        Assert.assertEquals(checkBoxPage.resultDownloads.getText(), "downloads", "downloads не выбран");
        Assert.assertEquals(checkBoxPage.resultWordFile.getText(), "wordFile", "wordFile не выбран");
        Assert.assertEquals(checkBoxPage.resultExelFile.getText(), "excelFile", "excelFile не выбран");
    }
}
