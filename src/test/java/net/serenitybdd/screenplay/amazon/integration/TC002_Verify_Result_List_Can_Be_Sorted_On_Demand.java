package net.serenitybdd.screenplay.amazon.integration;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.amazon.model.BookLang;
import net.serenitybdd.screenplay.amazon.model.SortOption;
import net.serenitybdd.screenplay.amazon.pages.HomePage;
import net.serenitybdd.screenplay.amazon.questions.PublicationDateList;
import net.serenitybdd.screenplay.amazon.tasks.FilterByBookLanguage;
import net.serenitybdd.screenplay.amazon.tasks.SearchByDepartmentAndKeyWord;
import net.serenitybdd.screenplay.amazon.tasks.SortByCondition;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class TC002_Verify_Result_List_Can_Be_Sorted_On_Demand {
    @Managed
    WebDriver browser;
    HomePage homePage = new HomePage();

    Actor dana = new Actor("Dana");

    @Before
    public void prepareBrowser() {
        givenThat(dana.can(BrowseTheWeb.with(browser)));
        dana.attemptsTo(
                Open.browserOn().the(homePage));
    }

    @Test
    public void verifyResultListIsPaginated(){
        dana.attemptsTo(
                SearchByDepartmentAndKeyWord.fromDepartment("Books").withKeyword("apple"),
                FilterByBookLanguage.with(BookLang.English.get()),
                SortByCondition.with(SortOption.PublicationDate.get())
        );
       then(dana).should(seeThat(PublicationDateList.beSortedByLatestDate(), is(equalTo(true))));
    }
}
