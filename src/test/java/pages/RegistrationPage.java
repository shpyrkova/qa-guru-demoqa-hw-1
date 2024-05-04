package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CityComponent;
import pages.components.StateComponent;
import pages.components.SuccessfulRegistrationTable;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput =  $("#subjectsInput"),
            pictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            formHeader = $(".practice-form-wrapper").$(byText("Student Registration Form"));

    private SelenideElement hobbyInput(String hobby) {

        switch (hobby) {
            case "Sports":
                return $("label[for=hobbies-checkbox-1]");
            case "Reading":
                return $("label[for=hobbies-checkbox-2]");
            case "Music":
                return $("label[for=hobbies-checkbox-3]");
            default:
                System.out.println("INVALID HOBBY");
                break;
        }

        return null;
    }

    CalendarComponent calendarComponent = new CalendarComponent();
    StateComponent stateComponent = new StateComponent();
    CityComponent cityComponent = new CityComponent();
    SuccessfulRegistrationTable successfulRegistrationTable = new SuccessfulRegistrationTable();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value, String subject) {
        subjectInput.setValue(value);
        $(byText(subject)).click();

        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbyInput(hobby).click();

        return this;
    }

    public RegistrationPage uploadPicture(String picture) {
        pictureInput.uploadFromClasspath(picture);

        return this;
    }

    public RegistrationPage setAddress(String address) {
        currentAddressInput.setValue(address);

        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.scrollIntoView(true);
        stateInput.click();
        stateComponent.setState(state);

        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.scrollIntoView(true);
        cityInput.click();
        cityComponent.setCity(city);

        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.scrollIntoView(true);
        submitButton.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        successfulRegistrationTable.checkValueInARow(key, value);

        return this;
    }


    public RegistrationPage checkRegistrationFormHeader() {
        formHeader.shouldBe(visible);

        return this;
    }
}