package helpers;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PageActions {

     public PageActions removeBanner(String element) {
        executeJavaScript(element + ".remove()");

        return this;
    }

}
