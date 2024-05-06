package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement dayLocator(String day) {
        return $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)");
    }

    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        dayLocator(day).click();
    }
}