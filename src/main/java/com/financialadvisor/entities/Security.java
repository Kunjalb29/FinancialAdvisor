package com.financialadvisor.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "security")
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "purchase_price", precision = 15, scale = 2)
    private BigDecimal purchasePrice;

    @Column(name = "quantity")
    private Integer quantity;

    // Constructor initializing all instance variables
    public Security(Portfolio portfolio, String name, String category,
                    LocalDate purchaseDate, BigDecimal purchasePrice, Integer quantity) {
        this.portfolio = portfolio;
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    // Default no-arg constructor (required by JPA)
    public Security() {}

    // Getters
    public Long getSecurityId() { return securityId; }
    public Portfolio getPortfolio() { return portfolio; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public BigDecimal getPurchasePrice() { return purchasePrice; }
    public Integer getQuantity() { return quantity; }

    // Setters (no setter for securityId / PK)
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
    public void setPurchasePrice(BigDecimal purchasePrice) { this.purchasePrice = purchasePrice; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
