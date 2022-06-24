package fr.yoann.architecturemodulaire.dal.jdbc;

import fr.yoann.architecturemodulaire.dal.DALException;

import java.io.IOException;
import java.util.Properties;

public class Settings {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(Settings.class.getResourceAsStream("/eu/unareil/dal/jdbc/settings.properties"));
        } catch (IOException e) {
            try {
                throw new DALException("Properties file not found", e);
            } catch (DALException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
