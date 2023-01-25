package guru.qa.tests;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;

public class TestData {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String fullName = firstName + " " + lastName;
    String userEmail = faker.internet().emailAddress();
    String gender = faker.options().option("Male", "Female", "Other");
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String birthYear = faker.number().numberBetween(1940,2005) + "";
    String birthMonth = faker.options().option("January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December");
    String birthDay = setRandomDay(birthMonth, birthYear);
    String birthDate = birthDay + " " + birthMonth + "," + birthYear;
    String subject1 = faker.options().option("History", "Arts", "Biology", "Maths", "Commerce", "Social Studies", "Civics", "Hindi");
    String subject2 = faker.options().option("Physics","English", "Chemistry", "Computer Science", "Accounting", "Economics");
    String subjects = subject1 + ", " + subject2;
    String hobby = faker.options().option("Sports", "Reading", "Music");
    String img = "cat.jpg";
    String currentAddress = faker.address().fullAddress();
    String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String city = setRandomCity(state);
    String stateAndCity = state + " " + city;


    public String setRandomDay(String birthMonth, String birthYear){
        int day;
        int year = Integer.parseInt(birthYear);
        if (birthMonth.equals("January") || birthMonth.equals("March") || birthMonth.equals("May") || birthMonth.equals("July")
                || birthMonth.equals("August") || birthMonth.equals("October") || birthMonth.equals("December")) {
            day = faker.number().numberBetween(1,31);
        } else if (birthMonth.equals("April") || birthMonth.equals("June") || birthMonth.equals("September")
                || birthMonth.equals("November")) {
            day = faker.number().numberBetween(1,30);
        } else if ((year % 100 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 > 0) ){
            day = faker.number().numberBetween(1,29);
        } else {
            day = faker.number().numberBetween(1,28);
        }

        if (day < 10) {
            return "0" + day;
        }
        else {
            return day + "";
        }
    }

    public String setRandomCity (String state){
        String city;
        ArrayList<String> values = new ArrayList<>();
        switch (state) {
            case "NCR":
                Collections.addAll(values,"Delhi", "Gurgaon", "Noida");
                city = values.get(faker.random().nextInt(0,values.size()-1));
                break;
            case "Uttar Pradesh":
                Collections.addAll(values,"Agra", "Lucknow", "Merrut");
                city = values.get(faker.random().nextInt(0,values.size()-1));
                break;
            case "Haryana":
                Collections.addAll(values,"Karnal", "Panipat");
                city = values.get(faker.random().nextInt(0,values.size()-1));
                break;
            case "Rajasthan":
                Collections.addAll(values,"Jaipur", "Jaiselmer");
                city = values.get(faker.random().nextInt(0,values.size()-1));
                break;
            default:
                city = null;
                break;
        }
        return city;
    }
}
