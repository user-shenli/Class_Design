package com.lina.Entity;

import java.math.BigDecimal;

public class Demand {
    private int demandId;
    private int userId;
    private String make;
    private String model;
    private BigDecimal maxPrice;
    private String description;

    @Override
    public String toString() {
        return "Demand{" +
                "demandId=" + demandId +
                ", userId=" + userId +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", maxPrice=" + maxPrice +
                ", description='" + description + '\'' +
                '}';
    }
// Getters and Setters

    public int getDemandId() { return demandId; }
    public void setDemandId(int demandId) { this.demandId = demandId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public BigDecimal getMaxPrice() { return maxPrice; }
    public void setMaxPrice(BigDecimal maxPrice) { this.maxPrice = maxPrice; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}