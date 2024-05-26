package pages;

import com.codeborne.selenide.SelenideElement;
import helpers.PageActions;
import pages.components.CalendarComponent;
import pages.components.SuccessfulRegistrationTable;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement subjectInput =  $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement pictureInput = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement formHeader = $(".practice-form-wrapper").$(byText("Student Registration Form"));

    CalendarComponent calendarComponent = new CalendarComponent();
    SuccessfulRegistrationTable successfulRegistrationTable = new SuccessfulRegistrationTable();
    PageActions pageActions = new PageActions();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        pageActions.removeBanner("$('#fixedban')");
        pageActions.removeBanner("$('footer')");

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


    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
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
        stateInput.click();
        stateCityWrapper.$(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.click();
        stateCityWrapper.$(byText(city)).click();

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