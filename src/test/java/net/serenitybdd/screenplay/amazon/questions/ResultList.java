package net.serenitybdd.screenplay.amazon.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.amazon.pages.HomePageSearchResult;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

public class ResultList implements Question<List<String>> {
    @Override
    public List<String> answeredBy(Actor actor) {
        return Text.of(HomePageSearchResult.crdItem).viewedBy(actor).asList();
    }
    public static Question<List<String>> displayed() {
        return new ResultList();
    }
}
