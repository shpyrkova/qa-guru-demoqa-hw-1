package pages.components;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class StateComponent {
    public void setState(String value){
        $("#stateCity-wrapper").$(byText(value)).click();
    }
}