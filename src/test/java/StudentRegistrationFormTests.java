import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillRegistrationFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Mary");
        $("#lastName").setValue("White");
        $("#userEmail").setValue("test@more.ru");
        $(byText("Female")).click();
        $("#userNumber").setValue("8800200600");
        $("#dateOfBirthInput").click();
        $("#submit").scrollIntoView(true);
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--011").click();
        $("#subjectsInput").setValue("Ma");
        $(byText("Maths")).click();
        $("#subjectsInput").setValue("En");
        $(byText("English")).click();
        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFromClasspath("Student_register_form_test.jpg");
        $("#currentAddress").setValue("Walking street");
        $(byText("Select State")).click();
        $(byText("Haryana")).scrollIntoView(true);
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Karnal")).scrollIntoView(true);
        $(byText("Karnal")).click();
        $("#submit").click();

        $x("//table/tbody/tr[1]/td[2]").shouldHave(text("Mary White"));
        $x("//table/tbody/tr[2]/td[2]").shouldHave(text("test@more.ru"));
        $x("//table/tbody/tr[3]/td[2]").shouldHave(text("Female"));
        $x("//table/tbody/tr[4]/td[2]").shouldHave(text("8800200600"));
        $x("//table/tbody/tr[5]/td[2]").shouldHave(text("11 May,2000"));
        $x("//table/tbody/tr[6]/td[2]").shouldHave(text("Maths, English"));
        $x("//table/tbody/tr[7]/td[2]").shouldHave(text("Sports, Reading"));
        $x("//table/tbody/tr[8]/td[2]").shouldHave(text("Student_register_form_test.jpg"));
        $x("//table/tbody/tr[9]/td[2]").shouldHave(text("Walking street"));
        $x("//table/tbody/tr[10]/td[2]").shouldHave(text("Haryana Karnal"));
    }
}
