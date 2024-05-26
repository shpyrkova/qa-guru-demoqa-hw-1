package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import testdata.TestDataGenerator;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;


@Tag("demoqa")
public class StudentRegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Успешная регистрация с заполнением всех полей")
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
        String subject = TestDataGenerator.generateSubject();
        String state = TestDataGenerator.generateState();
        String city = TestDataGenerator.generateCity(state);
        String picture = new TestDataGenerator().picture;

        step("Открыть форму регистрации и закрыть рекламные баннеры", () -> {
            registrationPage.openPage();
        });
        step("Заполнить все поля формы, нажать Submit", () -> {
            registrationPage
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                    .setSubject(subject)
                    .setHobby(hobby)
                    .uploadPicture(picture)
                    .setAddress(userAddress)
                    .setState(state)
                    .setCity(city)
                    .submitForm();
        });
        step("Убедиться, что данные в таблице верные", () -> {
            registrationPage
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", userNumber)
                    .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobby)
                    .checkResult("Picture", picture)
                    .checkResult("Address", userAddress)
                    .checkResult("State and City", state + " " + city);
        });
    }


    @Test
    @DisplayName("Успешная регистрация с заполнением только обязательных полей")
    void fillRequiredFieldsRegistrationTest() {

        String firstName = TestDataGenerator.generateFirstName();
        String lastName = TestDataGenerator.generateLastName();
        String userNumber = TestDataGenerator.generatePhoneNumber();
        String gender = TestDataGenerator.generateGender();
        String dayOfBirth = TestDataGenerator.generateDayOfBirth();
        String monthOfBirth = TestDataGenerator.generateMonthOfBirth();
        String yearOfBirth = TestDataGenerator.generateYearOfBirth();


        step("Открыть форму регистрации и закрыть рекламные баннеры", () -> {
            registrationPage.openPage();
        });
        step("Заполнить обязательные поля формы, нажать Submit", () -> {
            registrationPage
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth) // обязательность неизвестна. при очистке поля краш страницы
                    .submitForm();
        });
        step("Убедиться, что данные в таблице верные", () -> {
            registrationPage
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", userNumber)
                    .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth);
        });
    }

    @Test
    @DisplayName("Попытка регистрации без заполнения обязательных полей")
    void notFillRequiredFieldsRegistrationTest() {

        String firstName = TestDataGenerator.generateFirstName();
        String lastName = TestDataGenerator.generateLastName();

        step("Открыть форму регистрации и закрыть рекламные баннеры", () -> {
            registrationPage.openPage();
        });
        step("Заполнить только фамилию и имя, нажать Submit", () -> {
            registrationPage
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .submitForm();
                });
        step("Убедиться, что остались на форме регистрации", () -> {
            registrationPage.checkRegistrationFormHeader();
        });
    }

}
