package net.serenitybdd.screenplay.amazon.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePageHeader extends PageObject {

    //## SEARCH SECTION
    public static Target ddbSearch = Target.the("Search Dropdown").locatedBy("#searchDropdownBox");
    public static Target txtSearch = Target.the("Search Textbox").locatedBy("#twotabsearchtextbox");
    public static Target btnSearch = Target.the("Search Submit Button").locatedBy("#nav-search-submit-text");

    public static String optSort = "//li[@class='a-dropdown-item']//a[contains(text(),'%s')]";

    //## SORT BY SECTION
    public static Target ddbSortBy = Target.the("Sort By Dropdown").locatedBy("//span[@class='a-dropdown-label']");

    //Dynamic Sort Option Control
    public static String sortopt(String sortopt) {
        return String.format(optSort, sortopt);
    }
}
