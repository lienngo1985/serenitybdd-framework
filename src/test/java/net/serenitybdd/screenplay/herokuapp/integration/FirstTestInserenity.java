package net.serenitybdd.screenplay.herokuapp.integration;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.herokuapp.questions.TodoItemsList;
import net.serenitybdd.screenplay.herokuapp.tasks.AddATodoItem;
import net.serenitybdd.screenplay.herokuapp.tasks.StartWith;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class FirstTestInserenity {
    Actor sonic = Actor.named("Sonic");

    @Managed(driver = "chrome")
    WebDriver theBrowser;

    @Before
    public void jeffCanBrowseTheWeb() {
        givenThat(sonic).can(BrowseTheWeb.with(theBrowser));
    }

    @Test
    public void should_be_able_to_add_the_first_todo_item() {
        givenThat(sonic).wasAbleTo(StartWith.anEmptyTodoList());
        when(sonic).attemptsTo(AddATodoItem.called("Digitize JLA vol 1 collection"));
        then(sonic).should(seeThat(TodoItemsList.displayed(), hasItem("Digitize JLA vol 1 collection")));
    }
}
