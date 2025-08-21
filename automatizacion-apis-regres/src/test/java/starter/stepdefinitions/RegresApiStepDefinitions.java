package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import starter.models.User;
import starter.questions.ResponseCode;
import starter.questions.VerifyUserField;
import starter.tasks.CreateUser;
import starter.tasks.DeleteUser;
import starter.tasks.GetUsers;
import starter.tasks.UpdateUser;
import starter.utils.Constants;
import starter.utils.DataGenerator;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import static starter.utils.Constants.INFO_USER;

public class RegresApiStepDefinitions {

    private Actor actor;
    private int userId;

    @Before
    public void setUp() {
        actor = Actor.named("Tester");
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que quiero consumir los servicios de regres")
    public void queQuieroConsumirLosServiciosDeRegres() {
        OnStage.theActorCalled(actor.getName()).whoCan(CallAnApi.at(Constants.BASE_URL));
    }

    @When("realizo una peticion GET a la API con la pagina {int}")
    public void  realizoUnaPeticionGETALaAPI(int page) {
        OnStage.theActorInTheSpotlight().attemptsTo(GetUsers.fromPage(page));
    }

    @Then("recibo un codigo de respuesta {int}")
    public void reciboUnCodigoDeRespuesta(Integer statusCode) {
        OnStage.theActorInTheSpotlight().should(seeThat(ResponseCode.obtained(), equalTo(statusCode)));
    }

    @When("realizo una peticion POST a la API con los datos del usuario")
    public void realizoUnaPeticionPOSTALaAPIConLosDatosDelUsuario() {
        User generatedUser = DataGenerator.generateUser();
        OnStage.theActorInTheSpotlight().attemptsTo(CreateUser.withInfo(generatedUser));
        OnStage.theActorInTheSpotlight().remember(INFO_USER, generatedUser);
    }

    @Then("el usuario es creado con los datos correctos")
    public void elUsuarioEsCreadoConLosDatosCorrectos() {

        User expectedUser = OnStage.theActorInTheSpotlight().recall(INFO_USER);

        OnStage.theActorInTheSpotlight().should(
                seeThat("El id del usuario es correcto",
                        VerifyUserField.field("id"),
                        equalTo(String.valueOf(expectedUser.getId()))),
                seeThat("El email del usuario es correcto",
                        VerifyUserField.field("email"),
                        equalTo(expectedUser.getEmail())),
                seeThat("El first_name del usuario es correcto",
                        VerifyUserField.field("first_name"),
                        equalTo(expectedUser.getFirstName())),
                seeThat("El last_name del usuario es correcto",
                        VerifyUserField.field("last_name"),
                        equalTo(expectedUser.getLastName()))
        );
    }
    @Then("la lista de usuarios no esta vacia")
    public void laListaDeUsuariosNoEstaVacia() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La lista de usuarios",
                        response -> SerenityRest.lastResponse().jsonPath().getList("data"),
                        not(empty()))
        );
    }

    @When("realizo una peticion PUT a la API con los nuevos datos del usuario")
    public void realizoUnaPeticionPUTALaAPIConLosNuevosDatosDelUsuario() {
        User generatedUser = DataGenerator.generateUser();
        OnStage.theActorInTheSpotlight().attemptsTo(UpdateUser.withInfo(generatedUser));
        OnStage.theActorInTheSpotlight().remember(INFO_USER, generatedUser);
    }

    @Then("el usuario es actualizado correctamente")
    public void elUsuarioEsActualizadoCorrectamente() {

        User expectedUser = OnStage.theActorInTheSpotlight().recall(INFO_USER);

        OnStage.theActorInTheSpotlight().should(
                seeThat("El id del usuario es correcto",
                        VerifyUserField.field("id"),
                        equalTo(String.valueOf(expectedUser.getId()))),
                seeThat("El email del usuario es correcto",
                        VerifyUserField.field("email"),
                        equalTo(expectedUser.getEmail())),
                seeThat("El first_name del usuario es correcto",
                        VerifyUserField.field("first_name"),
                        equalTo(expectedUser.getFirstName())),
                seeThat("El last_name del usuario es correcto",
                        VerifyUserField.field("last_name"),
                        equalTo(expectedUser.getLastName()))
        );

    }
    @When("realizo una peticion DELETE a la API")
    public void realizoUnaPeticionDELETEALaAPI() {
        userId = 2;
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteUser.withId(userId));
    }

}
