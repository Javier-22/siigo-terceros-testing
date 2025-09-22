package siigo.tasks;



import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import siigo.utils.ReportUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static siigo.utils.Environment.APIKEY;

public class CreateUser implements Task {
    private final String name;
    private final String job;

    public CreateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/users")
                        .with(request -> request.header("Content-Type", "application/json")
                                .header("X-API-Key", APIKEY)
                                .body("{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}"))
        );

        ReportUtils.saveResponseToReport(actor, "Response de Creación de Usuario");
    }


    public static CreateUser withRandomData() {
        siigo.models.User user = siigo.utils.DataGenerator.generateUser();
        return instrumented(CreateUser.class, user.getName(), user.getJob());
    }
}