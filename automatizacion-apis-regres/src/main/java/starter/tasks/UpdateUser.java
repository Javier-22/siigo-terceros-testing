package starter.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.apache.http.HttpHeaders;
import starter.models.User;
import starter.utils.DataGenerator;

import java.util.Map;

public class UpdateUser implements Task {

    private User user;

    public UpdateUser(User user) {
        this.user = user;
    }

    public static UpdateUser withInfo(User user) {
        return new UpdateUser(user);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String, Object> userJson = DataGenerator.generateUserJson(user);

        actor.attemptsTo(
                Put.to("/users/{id}")
                        .with(request -> request
                                .pathParam("id", userJson.get("id"))
                                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                                .header("x-api-key", "reqres-free-v1")
                                .body(userJson))
        );
        SerenityRest.lastResponse().prettyPrint();
    }
}
