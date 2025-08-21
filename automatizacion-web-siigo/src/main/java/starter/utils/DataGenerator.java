package starter.utils;

import net.datafaker.Faker;
import starter.models.ThirdParty;

public class DataGenerator {
    private static final Faker faker = new Faker();

    public static ThirdParty generateThirdParty() {
        String personType = faker.options().option("Es persona");
        String identificationType = faker.options().option(
                "Cédula de ciudadanía");
        String identification = generateIdentificationNumber();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String commercialName = faker.company().name();
        String address = faker.address().streetAddress();
        String city = faker.address().city();

        return new ThirdParty(
                personType,
                identificationType,
                identification,
                firstName,
                lastName,
                commercialName,
                address,
                city
        );
    }

    private static String generateIdentificationNumber() {
        String prefix = "1064";
        int numberOfDigits = 6; // You can adjust the number of digits as needed
        StringBuilder idNumber = new StringBuilder(prefix);
        for (int i = 0; i < numberOfDigits; i++) {
            idNumber.append(faker.number().digit());
        }
        return idNumber.toString();
    }
}
