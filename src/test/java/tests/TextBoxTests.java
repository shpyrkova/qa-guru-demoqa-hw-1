package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillTextBoxTest() {

        textBoxPage.openPage()
                .setUserName("Daria")
                .setEmail("daria@sur.kov")
                .setCurrentAddress("Lenina street 1")
                .setPermanentAddress("Another street 1")
                .submitClick()

                .checkResult("Name:", "Daria")
                .checkResult("Email:", "daria@sur.kov")
                .checkResult("Current Address :", "Lenina street 1")
                .checkResult("Permananet Address :", "Another street 1");


    }

}
