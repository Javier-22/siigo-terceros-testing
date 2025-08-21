package starter.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

public class GetUserForRegister implements Question<Map<String, Object>> {

    private final int idUsuario;

    public GetUserForRegister(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public static GetUserForRegister conId(int idUsuario) {
        return new GetUserForRegister(idUsuario);
    }
    @Override
    public Map<String, Object> answeredBy(Actor actor) {
        List<Map<String, Object>> listaUsuarios = SerenityRest.lastResponse()
                .jsonPath()
                .getList("data");

        return listaUsuarios.stream()
                .filter(usuario -> ((Integer) usuario.get("id")) == idUsuario)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuario con id " + idUsuario + " no encontrado"));
    }
}
