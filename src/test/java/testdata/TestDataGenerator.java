package testdata;

import com.github.javafaker.Faker;

import java.time.Month;
import java.util.Locale;


public class TestDataGenerator {

    static Faker faker = new Faker(new Locale("en-GB"));
    public String picture = "Student_register_form_test.jpg";

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateDayOfBirth() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public static String generateMonthOfBirth() {
        Month month = Month.of(faker.number().numberBetween(1, 12));
        return month.getDisplayName(java.time.format.TextStyle.FULL, Locale.ENGLISH);
    }

    public static String generateYearOfBirth() {
        return String.valueOf(faker.number().numberBetween(1900, 2100));

    }

    public static String generatePhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String generateHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    public static String generateSubject() {
        String[] subjects = {"Maths", "Art", "Accounting", "Physics", "Chemistry", "Economics", "English",
                "Biology", "History", "Civics", "Computer Science", "Social Studies", "Hindi", "Commerce"};
        return faker.options().option(subjects);
    }

    public static String generateAddress() {
        return faker.address().streetAddress();
    }

    public static String generateState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(states);

    }


    public static String generateCity(String state) {
        String city = "";

        switch (state) {
            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
        }
        
        return city;

    }

}
