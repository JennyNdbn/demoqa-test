package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

public class RegistrationFormWithAllureAndJenkinsTests extends TestBaseExtended {

    @Test
    @DisplayName("Testing of registration form filling on demoqa.com")
    @Owner("Evgeniia Nadobnaia")
    @Feature("Testing of demoqa.com")
    @Story("Testing Student Registration Form filling")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("remote")
    void fillPracticeFormTest() {
        step("Open Student Registration Form", () -> {
        registrationPage.openPage();
        });
        step("Fill Student Registration Form", () -> {
        registrationPage.setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setBirthDate(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubjects(testData.subject1)
                .setSubjects(testData.subject2)
                .setHobbies(testData.hobby)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city);

        if (!Configuration.browser.equalsIgnoreCase("firefox")){
            registrationPage.setPicture(testData.img);
        }

        });
        step("Press submit button", () ->
        registrationPage.submit()
        );
        step("Verify results", () -> {
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", testData.fullName)
                .verifyResult("Student Email", testData.userEmail)
                .verifyResult("Gender", testData.gender)
                .verifyResult("Mobile", testData.userNumber)
                .verifyResult("Date of Birth", testData.birthDate)
                .verifyResult("Subjects", testData.subjects)
                .verifyResult("Hobbies", testData.hobby)
                .verifyResult("Address", testData.currentAddress)
                .verifyResult("State and City", testData.stateAndCity);

            if (!Configuration.browser.equalsIgnoreCase("firefox")){
                registrationPage.verifyResult("Picture", testData.img);
            }
        });
    }
}
