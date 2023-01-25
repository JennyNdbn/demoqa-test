package guru.qa.tests;

import org.junit.jupiter.api.Test;

public class RegistrationFormWithPOAndJavaFakerTests extends TestBase {

    @Test
    void fillPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
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
    }
}
