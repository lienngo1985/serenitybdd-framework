package net.serenitybdd.screenplay.amazon.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.amazon.pages.HomePageLeftNavigation;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FilterByBookLanguage extends PageObject implements Task {
    private final String booklang;

    public FilterByBookLanguage(String booklang){
        this.booklang = booklang;
    }

    public static FilterByBookLanguage with(String booklang){
        return instrumented(FilterByBookLanguage.class,booklang);
    }

    @Step("Filter Search Result By Book Language")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
               // Click.on(By.xpath(HomePageLeftNavigation.booklang(booklang)))
                Hit.the(Keys.SPACE).into(By.xpath(HomePageLeftNavigation.booklang(booklang)))
        );
    }
}
