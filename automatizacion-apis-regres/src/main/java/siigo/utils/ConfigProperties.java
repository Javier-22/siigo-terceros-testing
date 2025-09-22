package siigo.utils;

import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class ConfigProperties {

    private static final String CONFIG_FILE = "config.properties";


    public static String getEnviroment() {
        return getValorProperties("enviroment");
    }



    public static String getEndpoint() {
        switch (getEnviroment()) {
            case "qa":
                return getValorProperties("qa.endpoint");
            case "uat":
                return getValorProperties("uat.endpoint");
            default:
                return null;
        }
    }

    public static String getApiKey() {
        switch (getEnviroment()) {
            case "qa":
                return getValorProperties("qa.apiKey");
            case "uat":
                return getValorProperties("uat.apiKey");
            default:
                return null;
        }
    }


    public static String getValorProperties(String variable) {
        return Optional.ofNullable(System.getenv(variable)).orElse((String) loadPropertiesFile().get(variable));
    }

    @SneakyThrows
    public static Properties loadPropertiesFile() {
        Properties prop = new Properties();
        try (InputStream input = ConfigProperties.class.getClassLoader()
                .getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new FileNotFoundException("Archivo " + CONFIG_FILE + " no encontrado");
            }
            prop.load(input);
        }
        return prop;
    }

}
