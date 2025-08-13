package demoqa.elements.widgets;

import demoqa.BaseTest;
import org.testng.annotations.Test;

public class SelectMenuTest extends BaseTest {

    @Test
    public void selectMenuTest() throws InterruptedException {
        browserManager.open("https://demoqa.com/select-menu");

//        webElementActions.selectByText(selectMenuPage.oldSelectMenu, "Purple");
//        webElementActions.selectedByIndex(selectMenuPage.oldSelectMenu, 2);
//        Thread.sleep(3000);
//
//        webElementActions.selectedByValue(selectMenuPage.oldSelectMenu, "10");
//        Thread.sleep(3000);
//
//        webElementActions.getAllDropdownValues(selectMenuPage.oldSelectMenu).forEach(System.out::println);

        selectMenuPage.selectValueByText("Group 1, option 1");
        selectMenuPage.selectOneByText("Dr.");
    }

}
