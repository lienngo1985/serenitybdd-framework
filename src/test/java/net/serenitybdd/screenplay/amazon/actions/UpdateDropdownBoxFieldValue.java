package net.serenitybdd.screenplay.amazon.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Settable;
import net.serenitybdd.screenplay.targets.Target;

public class UpdateDropdownBoxFieldValue implements Settable {

    Target field;
    String newValue;

    public UpdateDropdownBoxFieldValue(Target field) {
        this.field = field;
    }

    public <T extends Actor> void performAs(T theUser) {
        theUser.attemptsTo(SelectFromOptions.byVisibleText(newValue).from(field));
    }

    public Performable to(String newValue) {
        this.newValue = newValue;
        return this;
    }
}
