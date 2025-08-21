package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static starter.userinterface.HomePage.CLIENTS;
import static starter.userinterface.HomePage.CREATE;

public class Navigate implements Task {
    public static Navigate options() {
        return Tasks.instrumented(Navigate.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CREATE, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(CREATE).afterWaitingUntilEnabled(),
                Click.on(CLIENTS).afterWaitingUntilEnabled());
    }
}
