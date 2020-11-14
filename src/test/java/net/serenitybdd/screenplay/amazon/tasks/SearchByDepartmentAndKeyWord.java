package net.serenitybdd.screenplay.amazon.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Settable;
import net.serenitybdd.screenplay.amazon.actions.UpdateDropdownBoxFieldValue;
import net.serenitybdd.screenplay.amazon.actions.UpdateTextFieldValue;
import net.serenitybdd.screenplay.amazon.pages.HomePageHeader;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchByDepartmentAndKeyWord implements Performable {

    private final String department;
    String keyword;

    public SearchByDepartmentAndKeyWord(String department){
        this.department = department;
    }

    public static Settable department() { return instrumented(UpdateDropdownBoxFieldValue.class, HomePageHeader.ddbSearch); }
    public static Settable keyword() { return instrumented(UpdateTextFieldValue.class, HomePageHeader.txtSearch); }
    public static Settable sortby() { return instrumented(UpdateDropdownBoxFieldValue.class, HomePageHeader.ddbSortBy); }

    public static SearchByDepartmentAndKeyWord fromDepartment(String department) {
        return instrumented(SearchByDepartmentAndKeyWord.class, department);
    }

    public SearchByDepartmentAndKeyWord withKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    @Step("{0} Perform a Search By Department And Keyword")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SearchByDepartmentAndKeyWord.department().to(department),
                SearchByDepartmentAndKeyWord.keyword().to(keyword),
                Click.on(HomePageHeader.btnSearch)
                );
    }
}
