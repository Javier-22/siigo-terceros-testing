package siigo.actor;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import org.apache.commons.lang3.StringUtils;

public class Actor_name {

    private static final String DEFAULT_ACTOR_NAME = "Usuario";
    private static final String NAME_PROPERTY = "actor.name";

    /**
     * Crea un actor con nombre personalizado o por defecto
     * @return Actor configurado
     */
    public static Actor createActor() {
        String actorName = getConfiguredActorName();
        return Actor.named(actorName);
    }

    /**
     * Obtiene el nombre del actor desde propiedades del sistema o usa el valor por defecto
     * @return Nombre del actor
     */
    private static String getConfiguredActorName() {
        // 1. Intenta obtener de propiedad del sistema
        String nameFromProperty = System.getProperty(NAME_PROPERTY);

        // 2. Si no está definido, usa el nombre de usuario del sistema
        if (StringUtils.isBlank(nameFromProperty)) {
            nameFromProperty = System.getProperty("user.name");
        }

        // 3. Si todo falla, usa el valor por defecto
        return StringUtils.isNotBlank(nameFromProperty)
                ? nameFromProperty
                : DEFAULT_ACTOR_NAME;
    }

    /**
     * Versión alternativa que permite especificar habilidades al crear el actor
     * @param abilities Habilidades para asignar al actor
     * @return Actor configurado con habilidades
     */
    public static Actor createActorWithAbilities(Ability... abilities) {
        Actor actor = createActor();
        for (Ability ability : abilities) {
            actor.can(ability);
        }
        return actor;
    }
}
