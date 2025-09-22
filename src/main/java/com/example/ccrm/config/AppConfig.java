package com.example.ccrm.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Application configuration class for managing CCRM system settings.
 * This class loads configuration from properties files and provides
 * centralized access to application settings.
 */
public class AppConfig {
    private static final String DEFAULT_CONFIG_FILE = "application.properties";
    private static AppConfig instance;
    private Properties properties;

    private AppConfig() {
        loadConfiguration();
    }

    /**
     * Get the singleton instance of AppConfig.
     * @return the AppConfig instance
     */
    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    /**
     * Load configuration from the default properties file.
     */
    private void loadConfiguration() {
        properties = new Properties();
        
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(DEFAULT_CONFIG_FILE)) {
            if (input != null) {
                properties.load(input);
            } else {
                // Load default configuration if file doesn't exist
                loadDefaultConfiguration();
            }
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
            loadDefaultConfiguration();
        }
    }

    /**
     * Load default configuration values.
     */
    private void loadDefaultConfiguration() {
        properties.setProperty("app.name", "CCRM - Customer Relationship Management");
        properties.setProperty("app.version", "1.0.0");
        properties.setProperty("database.url", "jdbc:h2:mem:ccrm");
        properties.setProperty("database.driver", "org.h2.Driver");
        properties.setProperty("database.username", "sa");
        properties.setProperty("database.password", "");
        properties.setProperty("max.customers.per.page", "50");
        properties.setProperty("contact.reminder.days", "7");
        properties.setProperty("log.level", "INFO");
    }

    /**
     * Get a configuration property value.
     * @param key the property key
     * @return the property value, or null if not found
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Get a configuration property value with a default.
     * @param key the property key
     * @param defaultValue the default value if key is not found
     * @return the property value or default value
     */
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Get an integer configuration property.
     * @param key the property key
     * @param defaultValue the default value if key is not found or invalid
     * @return the integer property value or default value
     */
    public int getIntProperty(String key, int defaultValue) {
        String value = properties.getProperty(key);
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer value for property " + key + ": " + value);
            }
        }
        return defaultValue;
    }

    /**
     * Get a boolean configuration property.
     * @param key the property key
     * @param defaultValue the default value if key is not found
     * @return the boolean property value or default value
     */
    public boolean getBooleanProperty(String key, boolean defaultValue) {
        String value = properties.getProperty(key);
        if (value != null) {
            return Boolean.parseBoolean(value);
        }
        return defaultValue;
    }

    // Convenient getter methods for common properties
    public String getAppName() {
        return getProperty("app.name", "CCRM");
    }

    public String getAppVersion() {
        return getProperty("app.version", "1.0.0");
    }

    public String getDatabaseUrl() {
        return getProperty("database.url");
    }

    public String getDatabaseDriver() {
        return getProperty("database.driver");
    }

    public String getDatabaseUsername() {
        return getProperty("database.username");
    }

    public String getDatabasePassword() {
        return getProperty("database.password");
    }

    public int getMaxCustomersPerPage() {
        return getIntProperty("max.customers.per.page", 50);
    }

    public int getContactReminderDays() {
        return getIntProperty("contact.reminder.days", 7);
    }

    public String getLogLevel() {
        return getProperty("log.level", "INFO");
    }

    /**
     * Reload configuration from the properties file.
     */
    public void reload() {
        loadConfiguration();
    }
}