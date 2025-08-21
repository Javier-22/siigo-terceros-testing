package starter.utils;

import net.datafaker.Faker;
import starter.models.User;

import java.util.HashMap;
import java.util.Map;

public class DataGenerator {

    private static final Faker faker = new Faker();

    public static User generateUser() {
        int id = faker.number().numberBetween(1, 1000);
        String email = faker.internet().emailAddress();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        return new User(id, email, firstName, lastName);
    }

    public static Map<String, Object> generateUserJson(User user) {
        Map<String, Object> userJson = new HashMap<>();
        userJson.put("id", user.getId());
        userJson.put("email", user.getEmail());
        userJson.put("first_name", user.getFirstName());
        userJson.put("last_name", user.getLastName());
        return userJson;
    }
}
