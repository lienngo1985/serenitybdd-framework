package net.serenitybdd.screenplay.herokuapp.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.herokuapp.pages.TodoList;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.openqa.selenium.Keys.RETURN;

public class AddATodoItem implements Task {
    private String item;

    public AddATodoItem(String item) {
        this.item = item;
    }

    @Override
    @Step("{0} adds an item called '#item'")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TodoList.TODO_FIELD, isVisible()),
                Enter.theValue(item).into(TodoList.TODO_FIELD).thenHit(RETURN)
        );
    }

    public static AddATodoItem called(String item) {
        return instrumented(AddATodoItem.class, item);
    }
}
