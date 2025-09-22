package com.example.ccrm.model;

/**
 * Enumeration representing different types of contact interactions in the CRM system.
 */
public enum ContactType {
    PHONE_CALL("Phone Call"),
    EMAIL("Email"),
    MEETING("Meeting"),
    FOLLOW_UP("Follow-up"),
    SUPPORT("Support"),
    SALES("Sales"),
    OTHER("Other");

    private final String displayName;

    ContactType(String displayName) {
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