package net.serenitybdd.screenplay.amazon.tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.amazon.pages.HomePageHeader;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SortByCondition implements Task {
    private final String option;

    public SortByCondition (String option){
        this.option = option;
    }

    public static SortByCondition with(String option){
        return instrumented(SortByCondition .class, option);
    }

    @Step("{0} Sort Search Result By a Condition")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePageHeader.ddbSortBy),
                Click.on(By.xpath(HomePageHeader.sortopt(option)))
        );
    }
}
