package net.serenitybdd.screenplay.amazon.pages;

import net.serenitybdd.core.pages.PageObject;

public class HomePageLeftNavigation extends PageObject {
    public static String optBooklang = "//li[@aria-label='%s']//input";
    public static String booklang(String booklang) {
        return String.format(optBooklang, booklang);
    }
}
