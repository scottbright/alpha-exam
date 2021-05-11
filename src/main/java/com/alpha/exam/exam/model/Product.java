package com.alpha.exam.exam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private UUID id;
    private BigDecimal price;
    private String continent;
    private BigDecimal multiplier;
    private LocalDateTime createdAt;

    @Transient
    private BigDecimal multipliedValue;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(BigDecimal multiplier) {
        this.multiplier = multiplier;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getMultipliedValue() {
        return multipliedValue;
    }

    public void setMultipliedValue(BigDecimal multipliedValue) {
        this.multipliedValue = multipliedValue;
    }
}
