package com.lina.Entity;

import java.sql.Timestamp;

public class Favorite {
    private int favoriteId;
    private int userId;
    private int carId;
    private Timestamp addedAt;
    private double price;
    private String make;

    @Override
    public String toString() {
        return "Favorite{" +
                "favoriteId=" + favoriteId +
                ", userId=" + userId +
                ", carId=" + carId +
                ", addedAt=" + addedAt +
                ", price=" + price +
                ", make='" + make + '\'' +
                '}';
    }

    // Getters and Setters
    public int getFavoriteId() { return favoriteId; }
    public void setFavoriteId(int favoriteId) { this.favoriteId = favoriteId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getCarId() { return carId; }
    public void setCarId(int carId) { this.carId = carId; }

    public Timestamp getAddedAt() { return addedAt; }
    public void setAddedAt(Timestamp addedAt) { this.addedAt = addedAt; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }
}