package com.example.ccrm.model;

/**
 * Enumeration representing the status of a customer in the CRM system.
 */
public enum CustomerStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    PROSPECT("Prospect"),
    LEAD("Lead"),
    SUSPENDED("Suspended");

    private final String displayName;

    CustomerStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}