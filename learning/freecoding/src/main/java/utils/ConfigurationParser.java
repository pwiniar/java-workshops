package utils;


import org.json.simple.parser.JSONParser;

/**
 * Created by Winiar on 02.07.2017.
 */
public class ConfigurationParser {

    private static final ConfigurationParser INSTANCE = new ConfigurationParser();
    private final JSONParser parser = new JSONParser();

    public static ConfigurationParser getInstance() {
        return INSTANCE;
    }

    public void readConfigurationFromFile(String fileName) {

    }

}
