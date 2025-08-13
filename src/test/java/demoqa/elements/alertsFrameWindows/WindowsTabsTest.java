package demoqa.elements.alertsFrameWindows;

import com.demoqa.drivers.DriverManager;
import demoqa.BaseTest;
import org.testng.annotations.Test;

public class WindowsTabsTest extends BaseTest {

    @Test
    public void testWindowTab() {
        DriverManager.getDriver().get("https://demoqa.com/browser-windows");
        browserWindows.clickTab();
        browserWindows.clickTab();
        browserWindows.clickTab();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        windowHelper.switchToParent();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        windowHelper.switchWindow(2);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
