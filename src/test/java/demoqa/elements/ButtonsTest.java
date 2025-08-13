package demoqa.elements;

import demoqa.BaseTest;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Test
    public void buttonTest() throws InterruptedException {
        browserManager.open("https://demoqa.com/buttons");

        webElementActions.doubleClick(buttons.doubleClickBtn);

        webElementActions.rightClick(buttons.rightClickBtn);

        webElementActions.click(buttons.dynamicBtn);
        Thread.sleep(3000);

    }
}
