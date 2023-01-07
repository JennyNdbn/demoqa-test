import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {
    @BeforeAll
    static void beforeAll() {
      Configuration.browserSize = "1920x1080";
      Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
//
        String firstName = "Barsik";
        String lastName = "Kotikov";
        String fullName = firstName + " " + lastName;
        String userEmail = "barsikot@gmail.com";
        String gender = "Male";
        String userNumber = "9876543210";
        String birthYear = "2011";
        String birthMonth = "July";
        String birthDay = "7";
        String birthDate = birthDay + " " + birthMonth + "," + birthYear;
        String currentAddress = "Buckingham Palace";
        String subject1 = "Arts";
        String subject2 = "Physics";
        String subjects = subject1 + ", " + subject2;
        String hobby1 = "Music";
        String hobby2 = "Reading";
        String hobbies = hobby1 + ", " + hobby2;
        String img = "cat.jpg";
        String state = "Haryana";
        String city = "Panipat";
        String stateAndCity = state + " " + city;
//
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__month").$(byText(birthDay)).click();
        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#subjectsInput").setValue(subject2).pressEnter();
        $(byText(hobby1)).click();
        $(byText(hobby2)).click();
        $("#uploadPicture").uploadFromClasspath("images/cat.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $(byText("Submit")).click();
//
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(fullName), (text(userEmail)), (text(userNumber)),
                (text(currentAddress)), (text(gender)), (text(birthDate)), (text(subjects)),
                (text(hobbies)), (text(img)), (text(stateAndCity)));
    }
}
