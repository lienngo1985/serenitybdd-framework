package net.serenitybdd.screenplay.amazon.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.amazon.actions.SortListBy;
import net.serenitybdd.screenplay.amazon.pages.HomePageSearchResult;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.pages.PageObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PublicationDateList extends PageObject implements Question<Boolean> {
    public static Question<Boolean> beSortedByLatestDate() {
        return new PublicationDateList();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        SortListBy result = new SortListBy();

        //Get List of Publication Date
        List<String> pubDateStringList = Text.of(HomePageSearchResult.publicationDateList).viewedBy(actor).asList();

        //Format Date based on returned result
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");

        // Convert List<String> to List<Date> so that we can compare dates in order
        List<Date> pubDateList = new ArrayList<>(pubDateStringList.size());
        for (String pubDateString : pubDateStringList) {
            try {
                pubDateList.add(simpleDateFormat.parse(pubDateString));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result.isSortedByLatestDate(pubDateList);
    }
}
