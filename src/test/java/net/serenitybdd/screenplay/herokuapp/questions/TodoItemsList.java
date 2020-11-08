package net.serenitybdd.screenplay.herokuapp.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static net.serenitybdd.screenplay.herokuapp.pages.TodoList.LIST_ITEMS;

public class TodoItemsList implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor) {
        return Text.of(LIST_ITEMS).viewedBy(actor).asList();
    }
    public static Question<List<String>> displayed() {
        return new TodoItemsList();
    }
}
