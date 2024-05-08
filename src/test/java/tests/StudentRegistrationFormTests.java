package tests;

import helpers.TestDataGenerator;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class StudentRegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillAllFieldsRegistrationTest() {

        String firstName = TestDataGenerator.generateFirstName();
        String lastName = TestDataGenerator.generateLastName();
        String gender = TestDataGenerator.generateGender();
        String email = TestDataGenerator.generateEmail();
        String dayOfBirth = TestDataGenerator.generateDayOfBirth();
        String monthOfBirth = TestDataGenerator.generateMonthOfBirth();
        String yearOfBirth = TestDataGenerator.generateYearOfBirth();
        String userNumber = TestDataGenerator.generatePhoneNumber();
        String userAddress = TestDataGenerator.generateAddress();
        String hobby = TestDataGenerator.generateHobby();
        String state = TestDataGenerator.generateState();
        String city = TestDataGenerator.generateCity(state);
        String picture = new TestDataGenerator().picture;

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject("Ma", "Maths") // как сделать именно такую проверку фейкером?
                .setSubject("En", "English") // это наиболее приближенно к действию юзера
                .setHobby(hobby)
                .uploadPicture(picture)
                .setAddress(userAddress)
                .setState(state)
                .setCity(city)
                .submitForm()

                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", "Maths, English")
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", userAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void fillRequiredFieldsRegistrationTest() {

        String firstName = TestDataGenerator.generateFirstName();
        String lastName = TestDataGenerator.generateLastName();
        String userNumber = TestDataGenerator.generatePhoneNumber();
        String gender = TestDataGenerator.generateGender();
        String dayOfBirth = TestDataGenerator.generateDayOfBirth();
        String monthOfBirth = TestDataGenerator.generateMonthOfBirth();
        String yearOfBirth = TestDataGenerator.generateYearOfBirth();


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth) // обязательность неизвестна. при очистке поля краш страницы
                .submitForm()

                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth);
    }

    @Test
    void notFillRequiredFieldsRegistrationTest() {

        String firstName = TestDataGenerator.generateFirstName();
        String lastName = TestDataGenerator.generateLastName();

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .submitForm()

                .checkRegistrationFormHeader();
    }

}
