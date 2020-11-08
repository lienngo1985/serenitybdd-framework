package net.serenitybdd.screenplay.herokuapp.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.herokuapp.pages.ApplicationHomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartWith implements Task {
    ApplicationHomePage applicationHomePage = new ApplicationHomePage();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(applicationHomePage));
    }

    public static StartWith anEmptyTodoList() {
        return instrumented(StartWith.class);
    }
}
