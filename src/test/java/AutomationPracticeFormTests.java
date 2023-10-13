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
      Configuration.pageLoadStrategy = "eager";
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
        String birthDay = "07";
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
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__day--0" + birthDay + ":not(.react-datepicker__day--outside-month)").click();
       // $(".react-datepicker__month").$(byText(birthDay)).click();
        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#subjectsInput").setValue(subject2).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#uploadPicture").uploadFromClasspath("images/" + img);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();
//
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(fullName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(birthDate));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjects));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbies));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(img));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(stateAndCity));

        /* old results verifying
        String tbody = "table tbody";
        $(tbody).$("tr", 0).$("td",1).shouldBe(text(fullName));
        $(tbody).$("tr", 1).$("td",1).shouldBe(text(userEmail));
        $(tbody).$("tr", 2).$("td",1).shouldBe(text(gender));
        $(tbody).$("tr", 3).$("td",1).shouldBe(text(userNumber));
        $(tbody).$("tr", 4).$("td",1).shouldBe(text(birthDate));
        $(tbody).$("tr", 5).$("td",1).shouldBe(text(subjects));
        $(tbody).$("tr", 6).$("td",1).shouldBe(text(hobbies));
        $(tbody).$("tr", 7).$("td",1).shouldBe(text(img));
        $(tbody).$("tr", 8).$("td",1).shouldBe(text(currentAddress));
        $(tbody).$("tr", 9).$("td",1).shouldBe(text(stateAndCity));
        */
    }
}
