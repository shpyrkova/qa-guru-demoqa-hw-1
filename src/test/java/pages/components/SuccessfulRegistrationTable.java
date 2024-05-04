package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SuccessfulRegistrationTable {

    private SelenideElement tableWithStudentData = $(".table-responsive");

    private SelenideElement tableRowKey(String key) {
        return tableWithStudentData.$(byText(key));
    }

    private SelenideElement tableRowValue(String key) {
        return tableRowKey(key).sibling(0);
    }


    public SuccessfulRegistrationTable checkValueInARow(String key, String value) {
        tableRowValue(key)
                .shouldHave(text(value));

        return this;
    }

}
