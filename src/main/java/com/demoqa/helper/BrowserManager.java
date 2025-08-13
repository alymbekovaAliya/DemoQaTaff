package com.demoqa.helper;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedList;
import java.util.Set;

public class BrowserManager {

    private WebDriver driver;

    public BrowserManager(WebDriver driver) {
        this.driver = driver;
    }

    //когда открываем страницу через метод get то история посещений не сохраняется
    //когда открываем страницу через метод navigate.to то история посещений сохраняется
    public void open(final String URL) {
        driver.navigate().to(URL);
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public void refreshThePage() {
        driver.navigate().refresh();
    }

    public static class WindowHelper {
        private WebDriver driver;
        private WebDriverWait wait;

        public WindowHelper(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        }

        public Set<String> getWindowTabs() {
            return driver.getWindowHandles(); //метод берет все вкладки в браусере и сохраняет его в set
        }

        public void switchWindow(int index) {
            LinkedList<String> windowId = new LinkedList<>(getWindowTabs());
            if(index < 0 || index > windowId.size())  {
                throw new IllegalArgumentException("вы указали неправильный индекс");
            }

            driver.switchTo().window(windowId.get(index));
        }

        public void switchToParent() {
            LinkedList<String> windowId = new LinkedList<>(getWindowTabs());

            driver.switchTo().window(windowId.getFirst());
        }

        public void switchToParentWithChildClose() {
            switchToParent();
            LinkedList<String> windowId = new LinkedList<>(getWindowTabs());
            for (int i = 0; i < windowId.size(); i++) {
                driver.switchTo().window(windowId.get(i));
                driver.close(); // закрывает вкладку
            }
        }
    }

    public static class IframeManager {
        private WebDriver driver;
        private WebDriverWait webDriverWait;

        public IframeManager(WebDriver driver) {
            this.driver = driver;
            this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public IframeManager switchToFrame(WebElement element) {
            try {
                webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            return this;
        }

        public IframeManager switchToParent() {
            driver.switchTo().parentFrame();
            return this;
        }

        public IframeManager switchToFrameByIndex(int index) {
            driver.switchTo().frame(index);
            return this;
        }
    }
}
