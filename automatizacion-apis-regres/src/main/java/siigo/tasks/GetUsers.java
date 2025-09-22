package siigo.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import siigo.utils.ReportUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static siigo.utils.Environment.APIKEY;


public class GetUsers implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        String id = actor.recall("ResponseCreate");
        actor.attemptsTo(
                Get.resource("/users/" + 2)
                        .with(request -> request
                                .header("X-API-Key", APIKEY)
                                .header("Content-Type", "application/json"))

        );

        ReportUtils.saveResponseToReport(actor, "Response de obtener el Usuario");

    }

    public static GetUsers withId() {
        return instrumented(GetUsers.class);
    }


}
