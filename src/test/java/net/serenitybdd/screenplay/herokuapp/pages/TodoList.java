package net.serenitybdd.screenplay.herokuapp.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class TodoList extends PageObject {
    public static Target TODO_FIELD = Target
            .the("'What needs to be done?' field")
            .locatedBy("//input[@placeholder='What needs to be done?']");

    public static Target LIST_ITEMS = Target
            .the("List of todo items")
            .locatedBy(".view label");
}
