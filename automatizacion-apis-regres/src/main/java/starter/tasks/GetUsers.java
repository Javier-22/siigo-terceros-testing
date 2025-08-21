package starter.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static starter.utils.Constants.PARAMETER_PAGE;
import static starter.utils.Constants.USERS_PAGE;

public class GetUsers implements Task {

    private final int page;

    public GetUsers(int page) {
        this.page = page;
    }

    public static GetUsers fromPage(int page) {
        return new GetUsers(page);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource(USERS_PAGE)
                        .with(request -> request.pathParam(PARAMETER_PAGE, page))
        );
        SerenityRest.lastResponse().prettyPrint();
    }
}
