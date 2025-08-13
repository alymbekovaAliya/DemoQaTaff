package demoqa.elements.alertsFrameWindows;

import demoqa.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class iFrameTest extends BaseTest {

    @Test
    public void iframeTest() {
        browserManager.open("https://demoqa.com/frames");
        WebElement iframe = driver.findElement(By.id("frame1"));
        iframeManager.switchToFrame(iframe);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        iframeManager.switchToParent();
        System.out.println(driver.findElement(By.xpath("//h1[text()='Frames']")).getText());

        //если есть iframe то чтобы найти в нем элемент нужно на него перейти
        //iframe это внутри одного html документа есть другой html документ

    }
}
