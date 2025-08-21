package starter.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerifyUserField implements Question<String> {

    private final String fieldName;

    public VerifyUserField(String fieldName) {
        this.fieldName = fieldName;
    }
    public static VerifyUserField field(String fieldName) {
        return new VerifyUserField(fieldName);
    }
    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().jsonPath().getString(fieldName);
    }
}
