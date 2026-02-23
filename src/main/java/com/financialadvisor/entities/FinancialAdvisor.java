package com.financialadvisor.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "financial_advisor")
public class FinancialAdvisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisorId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Client> clients;

    // Constructor initializing all instance variables
    public FinancialAdvisor(String firstName, String lastName, String email,
                             String phoneNumber, LocalDateTime createdAt, List<Client> clients) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.clients = clients;
    }

    // Default no-arg constructor (required by JPA)
    public FinancialAdvisor() {}

    // Getters
    public Long getAdvisorId() { return advisorId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<Client> getClients() { return clients; }

    // Setters (no setter for advisorId / PK)
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setClients(List<Client> clients) { this.clients = clients; }
}
