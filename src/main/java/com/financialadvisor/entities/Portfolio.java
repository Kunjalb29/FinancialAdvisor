package com.financialadvisor.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", unique = true, nullable = false)
    private Client client;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Security> securities;

    // Constructor initializing all instance variables
    public Portfolio(Client client, LocalDateTime createdAt, List<Security> securities) {
        this.client = client;
        this.createdAt = createdAt;
        this.securities = securities;
    }

    // Default no-arg constructor (required by JPA)
    public Portfolio() {}

    // Getters
    public Long getPortfolioId() { return portfolioId; }
    public Client getClient() { return client; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<Security> getSecurities() { return securities; }

    // Setters (no setter for portfolioId / PK)
    public void setClient(Client client) { this.client = client; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}
