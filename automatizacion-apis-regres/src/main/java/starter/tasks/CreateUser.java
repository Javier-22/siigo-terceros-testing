package starter.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpHeaders;
import starter.models.User;
import starter.utils.DataGenerator;

import java.util.Map;

import static starter.utils.Constants.CREATE_USER;

public class CreateUser implements Task {

    private final User user;

    public CreateUser(User user) {
        this.user = user;
    }

    public static CreateUser withInfo(User user) {
        return new CreateUser(user);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String, Object> userJson = DataGenerator.generateUserJson(user);

        actor.attemptsTo(
                Post.to(CREATE_USER)
                        .with(request -> request
                                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                                .header("x-api-key", "reqres-free-v1")
                                .body(userJson))
        );
        SerenityRest.lastResponse().prettyPrint();
    }
}
