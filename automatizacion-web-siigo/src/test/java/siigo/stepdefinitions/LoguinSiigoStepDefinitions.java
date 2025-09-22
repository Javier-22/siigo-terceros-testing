package siigo.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import siigo.questions.VerifyMessage;
import siigo.tasks.Login;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;
import static siigo.userinterface.HomePage.SUCCESS_LOGIN_MESSAGE;
import static siigo.userinterface.LoguinPage.INVALID_CREDENTIALS_MESSAGE;
import static siigo.utils.Constants.BASE_URL_LOGUIN;

public class LoguinSiigoStepDefinitions {
    @Managed
    WebDriver driver;

    @Dado("que javier quiere ingresar a la pagina de siigo")
    public void queJavierQuiereIngresarALaPaginaDeSiigo() {
        Actor actor = Actor.named("Tester");
        OnStage.theActorCalled(actor.getName()).can(BrowseTheWeb.with(driver));
        OnStage.theActorCalled(actor.getName()).wasAbleTo(Open.url(BASE_URL_LOGUIN));
    }

    @Cuando("el se autentica con el {string} y {string}")
    public void elSeAutenticaConElUsuarioYContrasena(String user, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.withCredentials(user,password));
    }

    @Entonces("el verifica el loguin existoso con el mensaje {string}")
    public void elVerificaElLoguinExistosoConElMensaje(String messageExpected) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(SUCCESS_LOGIN_MESSAGE, isVisible()).forNoMoreThan(5).seconds());
        OnStage.theActorInTheSpotlight().should(seeThat(VerifyMessage.expected(SUCCESS_LOGIN_MESSAGE), equalTo(messageExpected)));
    }

    @Entonces("el verifica el mensaje de login fallido con el mensaje {string}")
    public void elVerificaElMensajeUsuarioOContrasenaInvalidos(String messageExpected) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(INVALID_CREDENTIALS_MESSAGE, isVisible()).forNoMoreThan(5).seconds());
        OnStage.theActorInTheSpotlight().should(seeThat(VerifyMessage.expected(INVALID_CREDENTIALS_MESSAGE), equalTo(messageExpected)));
    }
}
