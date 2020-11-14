package net.serenitybdd.screenplay.amazon.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.amazon.model.LoginAccount;
import net.serenitybdd.screenplay.amazon.pages.LoginPage;
import net.thucydides.core.annotations.Step;

public class LoginAmazonSite implements Performable {

    LoginAccount loginAccount = new LoginAccount("lien.ngo.titan@gmail.com", "Amazon@123");

    @Step("{0} Longin Amazon Site")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(loginAccount.getUsername()).into(LoginPage.TXTEMAIL),
                Click.on(LoginPage.BTNCONTINUE),
                Enter.theValue(loginAccount.getPassword()).into(LoginPage.TXTPASSWORD),
                Click.on(LoginPage.BTNSIGNIN));
    }
}
