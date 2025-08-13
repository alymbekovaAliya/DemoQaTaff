package com.demoqa.listeners;

import org.testng.ITestResult;
import org.testng.ITestContext;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvLogger {
    private static final String FILE_PATH = "target/allure-results/test_results.csv";
    private static boolean headerWritten = false;

    public static void writeResult(ITestResult result, String status) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            if (!headerWritten) {
                writer.append("DURATION IN MS,NAME,PARENT SUITE,START TIME,STATUS,STOP TIME,TEST CLASS,TEST METHOD\n");
                headerWritten = true;
            }

            long duration = result.getEndMillis() - result.getStartMillis();
            String name = result.getName();

            ITestContext context = result.getTestContext();
            String parentSuite = context.getSuite().getName();

            String startTime = formatDate(result.getStartMillis());
            String stopTime = formatDate(result.getEndMillis());

            String testClass = result.getTestClass().getName();
            String testMethod = result.getMethod().getMethodName();

            writer.append(String.join(",",
                    String.valueOf(duration),
                    escape(name),
                    escape(parentSuite),
                    escape(startTime),
                    escape(status.toLowerCase()),
                    escape(stopTime),
                    escape(testClass),
                    escape(testMethod)
            ));
            writer.append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String formatDate(long millis) {
        return new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").format(new Date(millis));
    }

    private static String escape(String value) {
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }
}