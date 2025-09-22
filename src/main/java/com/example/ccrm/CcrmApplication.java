package com.example.ccrm;

import com.example.ccrm.config.AppConfig;
import com.example.ccrm.model.Customer;
import com.example.ccrm.model.CustomerStatus;

/**
 * Main application class for the CCRM (Customer Relationship Management) system.
 * This serves as the entry point for the application.
 */
public class CcrmApplication {
    
    public static void main(String[] args) {
        System.out.println("Starting CCRM Application...");
        
        // Load application configuration
        AppConfig config = AppConfig.getInstance();
        
        // Display application information
        System.out.println("Application: " + config.getAppName());
        System.out.println("Version: " + config.getAppVersion());
        System.out.println("Max customers per page: " + config.getMaxCustomersPerPage());
        
        // Demonstrate domain model usage
        Customer customer = new Customer("John", "Doe", "john.doe@example.com");
        customer.setCompany("Tech Corp");
        customer.setPhoneNumber("+1-555-0123");
        customer.setStatus(CustomerStatus.ACTIVE);
        
        System.out.println("\nSample Customer Created:");
        System.out.println(customer);
        System.out.println("Full Name: " + customer.getFullName());
        
        System.out.println("\nCCRM Application initialized successfully!");
        System.out.println("Ready for customer relationship management operations.");
    }
}