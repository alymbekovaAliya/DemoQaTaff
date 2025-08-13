package demoqa.elements;

import demoqa.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.qameta.allure.Allure.step;

public class TextBoxTest extends BaseTest {

    @Test
    public void textBoxTest() {
        driver.get("https://demoqa.com/text-box");

        String randomName = dataService.generateRandomFirstName();
        String randomEmail = dataService.generateRandomEmail();
        String randomAddress = "Moskovskaya";
        String randomPermanentAddress = "Moskovskaya 101";

        textBoxPage.inputUserName("alllll")
                .inputUserEmail(randomEmail)
                .inputCurrentAddress(randomAddress)
                .inputPermanentAddress(randomPermanentAddress)
                .clickSubmit();

        //hard assertions -> если значения не совпадают , то программа дальше не идет
//        step("Проверка имени", () -> {
//                    Assert.assertEquals(formatText(textBoxPage.resultName.getText()), randomName, "Имена не совпадают");
//                }
//        );
//
//        step("Проверка email", () -> {
//                    Assert.assertEquals(formatText(textBoxPage.resultEmail.getText()), randomEmail, "Email не совпадает");
//                }
//        );
//
//        step("Проверка адреса", () -> {
//                    Assert.assertEquals(formatText(textBoxPage.resultCurrentAddress.getText()), randomAddress, "Адреса не совпадают");
//                }
//        );
//
//        step("Проверка адреса", () -> {
//                    Assert.assertEquals(formatText(textBoxPage.resultPermanentAddress.getText()), randomPermanentAddress, "Адреса не совпадают");
//                }
//        );

        //soft assert - не прирывает выполнения теста поле первого fail
        SoftAssert softAssert = new SoftAssert();
        step("Проверка имени", () -> {
                    softAssert.assertEquals(formatText(textBoxPage.resultName.getText()), randomName, "Имена не совпадают");
                }
        );

        step("Проверка email", () -> {
            softAssert.assertEquals(formatText(textBoxPage.resultEmail.getText()), randomEmail, "Email не совпадает");
                }
        );

        step("Проверка адреса", () -> {
            softAssert.assertEquals(formatText(textBoxPage.resultCurrentAddress.getText()), randomAddress, "Адреса не совпадают");
                }
        );

        step("Проверка адреса", () -> {
            softAssert.assertEquals(formatText(textBoxPage.resultPermanentAddress.getText()), randomPermanentAddress, "Адреса не совпадают");
                }
        );

        //выводит все накопленные ошибки , если забудем все тесты будут зеленые
        softAssert.assertAll();
    }

}
