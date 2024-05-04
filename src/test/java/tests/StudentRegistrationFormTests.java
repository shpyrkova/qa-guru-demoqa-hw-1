package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class StudentRegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillAllFieldsRegistrationTest() {

        registrationPage.openPage()
                .setFirstName("Mary")
                .setLastName("White")
                .setEmail("test@more.ru")
                .setGender("Female")
                .setUserNumber("8800200600")
                .setDateOfBirth("11", "May", "2000")
                .setSubject("Ma", "Maths")
                .setSubject("En", "English")
                .setHobby("Sports")
                .setHobby("Reading")
                .uploadPicture("Student_register_form_test.jpg")
                .setAddress("Walking street")
                .setState("Haryana")
                .setCity("Karnal")
                .submitForm()

                .checkResult("Student Name", "Mary White")
                .checkResult("Student Email", "test@more.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8800200600")
                .checkResult("Date of Birth", "11 May,2000")
                .checkResult("Subjects", "Maths, English")
                .checkResult("Hobbies", "Sports, Reading")
                .checkResult("Picture", "Student_register_form_test.jpg")
                .checkResult("Address", "Walking street")
                .checkResult("State and City", "Haryana Karnal");
    }

    @Test
    void fillRequiredFieldsRegistrationTest() {

        registrationPage.openPage()
                .setFirstName("Jane")
                .setLastName("Air")
                .setGender("Female")
                .setUserNumber("8800300500")
                .setDateOfBirth("15", "April", "2005") // обязательность неизвестна. при очистке поля краш страницы
                .submitForm()

                .checkResult("Student Name", "Jane Air")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8800300500")
                .checkResult("Date of Birth", "15 April,2005");
    }

    @Test
    void notFillRequiredFieldsRegistrationTest() {

        registrationPage.openPage()
                .setFirstName("Jane")
                .setLastName("Air")
                .submitForm()

                .checkRegistrationFormHeader();
    }

}
