package net.serenitybdd.screenplay.amazon.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickElement extends PageObject implements Task {
    private By by;
    //private WebElementFacade displayedElement;

    private int timeout = 15;
    private int interval = 3;

    public ClickElement(By by) {
        this.by = by;
    }

    public static ClickElement name(By by){
        return instrumented(ClickElement.class, by);
    }

    public ClickElement withTimeOut(int timeout){
        this.timeout = timeout;
        return this;
    }

    public ClickElement andInterval(int interval){
        this.interval = interval;
        return this;
    }

   /* public ClickElement andWaitFor(WebElementFacade displayedElement){
        this.displayedElement = displayedElement;
        return this;
    }*/

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (by != null) {
            waitForCondition().withTimeout(
                    Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofSeconds(interval))
                    .until(ExpectedConditions.elementToBeClickable(by))
                    .click();
        }

        // ##OPTIMIZATION - Add time to wait for the page is loaded completely, need to be optimized next time
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
