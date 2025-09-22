package siigo.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import siigo.actor.Actor_name;

import static siigo.utils.ConfigProperties.*;
import static siigo.utils.Environment.*;


public class PreparedStage {
    @Before(order = 1)
    public void setEnviroment()
    {

        ENVIROMENT = getEnviroment();
        ENDPOINT = getEndpoint();
        APIKEY = getApiKey();
    }

    @Before(order = 2)
    public void settheActorAbility()
    {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled(Actor_name.createActor().getName());
    }


}
