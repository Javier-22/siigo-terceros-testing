package siigo.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import siigo.tasks.CreateUser;
import siigo.tasks.DeleteUser;
import siigo.tasks.GetUsers;
import siigo.tasks.UpdateUser;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static siigo.utils.Environment.ENDPOINT;

public class RegresApiStepDefinitions {

    @Dado("que se va a consumir la API de seqRes")
    public void queSeVaAConsumirLaAPIDeSeqRes() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(ENDPOINT));
    }

    @Cuando("creo un usuario con datos aleatorios")
    public void creoUnUsuarioConDatosAleatorios() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CreateUser.withRandomData()
        );
    }



    @Cuando("consulta la informacion del usuario creado")
    public void consultaLaInformacionDelUsuarioCreado() {
        theActorInTheSpotlight().attemptsTo(
                GetUsers.withId()
        );
    }

    @Cuando("actualizo el usuario {int} con datos aleatorios")
    public void actualizoElUsuarioConDatosAleatorios(int userId) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                UpdateUser.withRandomData(userId)
        );
    }

    @Cuando("se elmina el Usuario con el Id {int}")
    public void seElminaElUsuarioConElId(int id) {
        theActorInTheSpotlight().attemptsTo(
                DeleteUser.withId(id)
        );
    }
    @Entonces("valido el codigo de estado {int}")
    public void validoElCodigoDeEstado(int statusCode) {
        theActorInTheSpotlight().should(
                ResponseConsequence.seeThatResponse("El código de estado debe ser " + statusCode,
                        response -> response.statusCode(statusCode))
        );
    }


}
