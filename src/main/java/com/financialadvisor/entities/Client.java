package com.financialadvisor.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id", nullable = false)
    private FinancialAdvisor advisor;

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

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Portfolio portfolio;

    // Constructor initializing all instance variables
    public Client(FinancialAdvisor advisor, String firstName, String lastName,
                  String email, String phoneNumber, LocalDateTime createdAt, Portfolio portfolio) {
        this.advisor = advisor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.portfolio = portfolio;
    }

    // Default no-arg constructor (required by JPA)
    public Client() {}

    // Getters
    public Long getClientId() { return clientId; }
    public FinancialAdvisor getAdvisor() { return advisor; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Portfolio getPortfolio() { return portfolio; }

    // Setters (no setter for clientId / PK)
    public void setAdvisor(FinancialAdvisor advisor) { this.advisor = advisor; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
}
