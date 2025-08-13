package com.demoqa.drivers;

import com.demoqa.config.FileReader;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    //Taf - test automation framework

    private DriverManager() {

    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver == null) {
            switch (FileReader.getValue("browser").toLowerCase()) {
                case "chrome" :
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFireFoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Вы передали неправильный вид браузера");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if(driver != null) {
                driver.close();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            System.out.println("Error while closing driver");
        }
    }
}
