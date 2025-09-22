package siigo.utils;

import net.datafaker.Faker;
import siigo.models.User;

public class DataGenerator {

    private static final Faker faker = new Faker();

    public static User generateUser() {

        String name = faker.name().firstName();
        String job = faker.job().title();
        return new User(name, job);
    }
}
