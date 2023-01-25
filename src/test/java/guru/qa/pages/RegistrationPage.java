package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Practice Form";
    private final String IMG_FOLDER = "images/";
//
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
//
    private SelenideElement
    firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    genderChoice = $("#genterWrapper"),
    userNumberInput = $("#userNumber"),
    dateOfBirthInput = $("#dateOfBirthInput"),
    userSubjectsInput = $("#subjectsInput"),
    userHobbiesChoice = $("#hobbiesWrapper"),
    pictureUpload = $("#uploadPicture"),
    currentAddressInput = $("#currentAddress"),
    stateDropdown = $("#state"),
    cityDropdown = $("#city"),
    stateAndCityChoice = $("#stateCity-wrapper"),
    submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        genderChoice.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value){
        userSubjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value){
        userHobbiesChoice.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String value){
        pictureUpload.uploadFromClasspath(IMG_FOLDER + value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value){
        stateDropdown.click();
        stateAndCityChoice.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value){
        cityDropdown.click();
        stateAndCityChoice.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submit(){
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

}
