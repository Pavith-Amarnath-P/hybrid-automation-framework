package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private ConfigLoader(){}

    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream(FrameworkConstants.CONFIG_PATH)){
            properties.load(fis);
        } catch (IOException e){
            throw new RuntimeException("Failed to load config file: " + e.getMessage());
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }

    public static Integer getInt(String key){
        return Integer.parseInt(properties.getProperty(key));
    }

    public static Boolean getBoolean(String key){
        return Boolean.parseBoolean(properties.getProperty(key));
    }
}
