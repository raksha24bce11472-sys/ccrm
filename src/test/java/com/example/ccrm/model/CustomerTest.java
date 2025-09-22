package com.example.ccrm.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Customer domain model.
 */
public class CustomerTest {
    
    private Customer customer;
    
    @BeforeEach
    void setUp() {
        customer = new Customer("John", "Doe", "john.doe@example.com");
    }
    
    @Test
    void testCustomerCreation() {
        assertNotNull(customer);
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals("john.doe@example.com", customer.getEmail());
        assertEquals(CustomerStatus.ACTIVE, customer.getStatus());
        assertNotNull(customer.getCreatedAt());
        assertNotNull(customer.getUpdatedAt());
    }
    
    @Test
    void testFullName() {
        assertEquals("John Doe", customer.getFullName());
    }
    
    @Test
    void testCustomerStatusUpdate() {
        customer.setStatus(CustomerStatus.PROSPECT);
        assertEquals(CustomerStatus.PROSPECT, customer.getStatus());
    }
    
    @Test
    void testCustomerEquality() {
        Customer customer1 = new Customer("Jane", "Smith", "jane@example.com");
        Customer customer2 = new Customer("Jane", "Smith", "jane@example.com");
        
        customer1.setId(1L);
        customer2.setId(1L);
        
        assertEquals(customer1, customer2);
        assertEquals(customer1.hashCode(), customer2.hashCode());
    }
    
    @Test
    void testCustomerInequality() {
        Customer customer1 = new Customer("Jane", "Smith", "jane@example.com");
        Customer customer2 = new Customer("Bob", "Johnson", "bob@example.com");
        
        assertNotEquals(customer1, customer2);
    }
    
    @Test
    void testToString() {
        customer.setId(1L);
        customer.setCompany("Tech Corp");
        
        String result = customer.toString();
        assertTrue(result.contains("John"));
        assertTrue(result.contains("Doe"));
        assertTrue(result.contains("john.doe@example.com"));
        assertTrue(result.contains("Tech Corp"));
    }
    
    @Test
    void testCustomerWithAllFields() {
        Customer fullCustomer = new Customer("Alice", "Johnson", "alice@example.com");
        fullCustomer.setPhoneNumber("+1-555-0123");
        fullCustomer.setCompany("Innovate Inc");
        fullCustomer.setStatus(CustomerStatus.LEAD);
        
        assertEquals("Alice Johnson", fullCustomer.getFullName());
        assertEquals("+1-555-0123", fullCustomer.getPhoneNumber());
        assertEquals("Innovate Inc", fullCustomer.getCompany());
        assertEquals(CustomerStatus.LEAD, fullCustomer.getStatus());
    }
}