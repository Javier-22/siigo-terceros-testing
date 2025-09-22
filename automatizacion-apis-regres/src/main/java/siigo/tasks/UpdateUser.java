package siigo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import siigo.models.User;
import siigo.utils.DataGenerator;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static siigo.utils.Environment.APIKEY;

public class UpdateUser implements Task {
    private final int userId;
    private final String name;
    private final String job;

    public UpdateUser(int userId, String name, String job) {
        this.userId = userId;
        this.name = name;
        this.job = job;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/users/" + userId)
                        .with(request -> request
                                .header("X-API-Key", APIKEY)
                                .header("Content-Type", "application/json")
                                .body("{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}"))
        );
    }

    public static UpdateUser withRandomData(int userId) {
        User randomUser = DataGenerator.generateUser();
        return instrumented(UpdateUser.class, userId, randomUser.getName(), randomUser.getJob());
    }
}

