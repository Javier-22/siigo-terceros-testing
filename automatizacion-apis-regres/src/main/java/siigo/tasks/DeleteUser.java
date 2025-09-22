package siigo.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import siigo.utils.ReportUtils;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static siigo.utils.Environment.APIKEY;

public class DeleteUser implements Task {
    private final int userId;

    public DeleteUser(int userId) {
        this.userId = userId;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/users/" + userId)
                        .with(request -> request
                                .header("X-API-Key", APIKEY)
                                .header("Content-Type", "application/json"))
        );
        ReportUtils.saveResponseToReport(actor, "Response de la Eliminacion de Usuario");
    }

    public static DeleteUser withId(int userId) {
        return instrumented(DeleteUser.class, userId);
    }
}
