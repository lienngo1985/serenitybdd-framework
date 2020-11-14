package net.serenitybdd.screenplay.amazon.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class HomePageSearchResult extends PageObject {

    public static String publicationDateList = "//div[@data-component-type='s-search-result']//span[@class='a-size-base a-color-secondary a-text-normal']";
    public static Target crdItem = Target.the("Item Card").locatedBy("//div[@data-component-type='s-search-result']");

    @FindBy(xpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[@data-index='15']")
    public static WebElementFacade crdLastItem;

    // ##Pagination
    public static final By btnNextPage = By.xpath("//li[@class='a-last']");
    public static final By btnPreviousPage = By.xpath("//ul[@class='a-pagination']/li[1]");
    public static final By btnPageNo3 = By.xpath("//ul[@class='a-pagination']/li[4]");
}
