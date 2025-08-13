package com.demoqa.listeners;

import com.demoqa.drivers.DriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.FileInputStream;
import java.io.IOException;

public class ScreenShotListener extends TestListenerAdapter {

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenShotsAsPNG() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenShotsAsPNG();
        CsvLogger.writeResult(result, "FAILED");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        CsvLogger.writeResult(tr, "PASSED");
    }

    @Override
    public void onFinish(ITestContext context) {
        try (FileInputStream fis = new FileInputStream("target/allure-results/test_results.csv")) {
            Allure.addAttachment("Test Results CSV", "text/csv", fis, ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
