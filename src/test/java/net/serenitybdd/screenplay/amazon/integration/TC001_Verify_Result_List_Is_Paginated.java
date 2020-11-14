package net.serenitybdd.screenplay.amazon.integration;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.amazon.actions.ClickElement;
import net.serenitybdd.screenplay.amazon.model.BookLang;
import net.serenitybdd.screenplay.amazon.pages.HomePage;
import net.serenitybdd.screenplay.amazon.pages.HomePageSearchResult;
import net.serenitybdd.screenplay.amazon.questions.ResultList;
import net.serenitybdd.screenplay.amazon.tasks.FilterByBookLanguage;
import net.serenitybdd.screenplay.amazon.tasks.SearchByDepartmentAndKeyWord;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SerenityRunner.class)
public class TC001_Verify_Result_List_Is_Paginated {
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
    public void verifyResultListIsPaginated() {
        // 1 - Check first page show 16 items in result list
        dana.attemptsTo(
                SearchByDepartmentAndKeyWord.fromDepartment("Books").withKeyword("apple"),
                FilterByBookLanguage.with(BookLang.English.get())
        );
        then(dana).should(seeThat(ResultList.displayed(), hasSize(16)));

        // 2 - Check next pages and make sure it also has 16 items per page
        and(dana).attemptsTo(
                    ClickElement.name(HomePageSearchResult.btnNextPage));
        then(dana).should(seeThat(ResultList.displayed(), hasSize(16)));

        // 3 - Check random page and make sure it also has 16 items per page
        and(dana).attemptsTo(
                ClickElement.name(HomePageSearchResult.btnPageNo3));
        then(dana).should(seeThat(ResultList.displayed(), hasSize(16)));

        // 4 - Check previous page and make sure it also has 16 items per page
        and(dana).attemptsTo(
                ClickElement.name(HomePageSearchResult.btnPreviousPage));
        then(dana).should(seeThat(ResultList.displayed(), hasSize(16)));
    }
}
