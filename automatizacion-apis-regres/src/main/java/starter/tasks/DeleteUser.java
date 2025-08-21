package starter.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteUser implements Task {
    private int userId;

    public DeleteUser(int userId) {
        this.userId = userId;
    }

    public static DeleteUser withId(int userId) {
        return new DeleteUser(userId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/users/{id}")
                        .with(request -> request.pathParam("id", userId)
                                .header("x-api-key", "reqres-free-v1"))

        );
    }
}
