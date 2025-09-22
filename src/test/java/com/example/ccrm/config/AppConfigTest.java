package com.example.ccrm.config;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the AppConfig configuration class.
 */
public class AppConfigTest {
    
    @Test
    void testSingletonInstance() {
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();
        
        assertSame(config1, config2);
    }
    
    @Test
    void testDefaultConfiguration() {
        AppConfig config = AppConfig.getInstance();
        
        assertNotNull(config.getAppName());
        assertNotNull(config.getAppVersion());
        assertTrue(config.getMaxCustomersPerPage() > 0);
        assertTrue(config.getContactReminderDays() > 0);
    }
    
    @Test
    void testConfigurationValues() {
        AppConfig config = AppConfig.getInstance();
        
        assertEquals("CCRM - Customer Relationship Management", config.getAppName());
        assertEquals("1.0.0", config.getAppVersion());
        assertEquals(50, config.getMaxCustomersPerPage());
        assertEquals(7, config.getContactReminderDays());
        assertEquals("INFO", config.getLogLevel());
    }
    
    @Test
    void testPropertyAccess() {
        AppConfig config = AppConfig.getInstance();
        
        String appName = config.getProperty("app.name");
        assertNotNull(appName);
        assertEquals("CCRM - Customer Relationship Management", appName);
    }
    
    @Test
    void testPropertyWithDefault() {
        AppConfig config = AppConfig.getInstance();
        
        String nonExistentProperty = config.getProperty("non.existent.property", "default_value");
        assertEquals("default_value", nonExistentProperty);
    }
    
    @Test
    void testIntProperty() {
        AppConfig config = AppConfig.getInstance();
        
        int maxCustomers = config.getIntProperty("max.customers.per.page", 25);
        assertEquals(50, maxCustomers);
        
        int nonExistentInt = config.getIntProperty("non.existent.int", 100);
        assertEquals(100, nonExistentInt);
    }
    
    @Test
    void testBooleanProperty() {
        AppConfig config = AppConfig.getInstance();
        
        boolean defaultTrue = config.getBooleanProperty("non.existent.boolean", true);
        assertTrue(defaultTrue);
        
        boolean defaultFalse = config.getBooleanProperty("non.existent.boolean", false);
        assertFalse(defaultFalse);
    }
}