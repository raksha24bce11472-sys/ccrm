package com.example.ccrm.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Contact domain model representing a contact interaction in the CRM system.
 */
public class Contact {
    private Long id;
    private Long customerId;
    private ContactType type;
    private String subject;
    private String notes;
    private LocalDateTime contactDate;
    private String contactedBy;
    private LocalDateTime createdAt;

    public Contact() {
        this.contactDate = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

    public Contact(Long customerId, ContactType type, String subject) {
        this();
        this.customerId = customerId;
        this.type = type;
        this.subject = subject;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getContactDate() {
        return contactDate;
    }

    public void setContactDate(LocalDateTime contactDate) {
        this.contactDate = contactDate;
    }

    public String getContactedBy() {
        return contactedBy;
    }

    public void setContactedBy(String contactedBy) {
        this.contactedBy = contactedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", type=" + type +
                ", subject='" + subject + '\'' +
                ", contactDate=" + contactDate +
                ", contactedBy='" + contactedBy + '\'' +
                '}';
    }
}