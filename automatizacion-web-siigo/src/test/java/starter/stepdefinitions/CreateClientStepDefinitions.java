package starter.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import starter.models.ThirdParty;
import starter.tasks.CreateClient;
import starter.tasks.Navigate;
import static starter.userinterface.ThirdProfilePage.*;
import starter.utils.DataGenerator;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static starter.utils.Constants.INFO_THIRD_PARTY;

public class CreateClientStepDefinitions {
    @Cuando("el realiza la creación de un tercero con su informacion")
    public void elRealizaLaCreacionDeUnTerceroConSuInformacion() {
        ThirdParty thirdParty = DataGenerator.generateThirdParty();
        OnStage.theActorInTheSpotlight().attemptsTo(
                Navigate.options(),
                CreateClient.withInfo(thirdParty)
        );
        OnStage.theActorInTheSpotlight().remember(INFO_THIRD_PARTY,thirdParty);
    }
    @Entonces("el verifica la creación  del tercero con sus datos")
    public void elVerificaLaCreacionDelTerceroConSusDatos() {
        ThirdParty thirdParty = OnStage.theActorInTheSpotlight().recall(INFO_THIRD_PARTY);
        OnStage.theActorInTheSpotlight().should(seeThat(
                Text.of(NAME_AND_LAST_NAME), equalTo(thirdParty.getFirstName()+ " " +thirdParty.getLastName())));
        OnStage.theActorInTheSpotlight().should(seeThat(
                Text.of(IDENTIFICATION_EXPECTED), equalTo(thirdParty.getIdentification())
                ));
    }
    @Y("el verifica que el estado del tercero sea {string}")
    public void elVerificaQueElEstadoDelTerceroSeaActivo(String status) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                Text.of(ACTIVE_STATUS), equalTo(status)));
    }
}
