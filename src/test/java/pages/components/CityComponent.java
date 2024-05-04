package pages.components;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class CityComponent {
    public void setCity(String value){
        $("#stateCity-wrapper").$(byText(value)).click();
    }
}