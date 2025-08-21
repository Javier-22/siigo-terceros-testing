package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import starter.models.ThirdParty;
import starter.userinterface.ThirdProfilePage;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static starter.userinterface.CreateClientPage.*;

public class CreateClient implements Task {
    private final ThirdParty thirdParty;

    public CreateClient(ThirdParty thirdParty) {
        this.thirdParty = thirdParty;
    }

    public static CreateClient withInfo(ThirdParty thirdParty) {
        return Tasks.instrumented(CreateClient.class, thirdParty);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> ciudadesColombia = Arrays.asList(
                "Bogotá", "Medellín", "Cali", "Barranquilla", "Cartagena",
                "Montería", "Bucaramanga", "Pereira", "Santa Marta", "Cúcuta",
                "Ibagué", "Villavicencio", "Neiva", "Manizales", "Armenia"
        );

        String ciudad = ciudadesColombia.get(new Random().nextInt(ciudadesColombia.size()));

        actor.attemptsTo(
                Click.on(CLICK_TYPE),
                Click.on(typeOfPerson(thirdParty.getPersonType())),
                Click.on(TYPE_IDENTIFICATION),
                Click.on(typeOfIdentification(thirdParty.getIdentificationType())),
                SendKeys.of(thirdParty.getIdentification()).into(IDENTIFICATION),
                SendKeys.of(thirdParty.getFirstName()).into(NAMES),
                SendKeys.of(thirdParty.getLastName()).into(LAST_NAME),
                SendKeys.of(thirdParty.getCommercialName()).into(COMERCIAL),
                SendKeys.of(thirdParty.getAddress()).into(ADRESS),
                Click.on(CITY_CLICK),
                SendKeys.of(ciudad).into(CITY),
                Click.on(SELECT_CITY),
                Click.on(SAVE),
                WaitUntil.the(ThirdProfilePage.THIRD_PROFILE, isVisible())
        );
    }
}
