package guru.qa.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationFormWithAllureAndJenkinsTests extends TestBaseExtended {

    @Test
    @DisplayName("Testing of registration form filling on demoqa.com")
    @Owner("Evgeniia Nadobnaia")
    @Feature("Testing of demoqa.com")
    @Story("Testing Student Registration Form filling")
    @Severity(SeverityLevel.BLOCKER)
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
                .setPicture(testData.img)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .submit();
        });
        step("Verify results", () -> {
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", testData.fullName)
                .verifyResult("Student Email", testData.userEmail)
                .verifyResult("Gender", testData.gender)
                .verifyResult("Mobile", testData.userNumber)
                .verifyResult("Date of Birth", testData.birthDate)
                .verifyResult("Subjects", testData.subjects)
                .verifyResult("Hobbies", testData.hobby)
                .verifyResult("Picture", testData.img)
                .verifyResult("Address", testData.currentAddress)
                .verifyResult("State and City", testData.stateAndCity);
        });
    }
}
