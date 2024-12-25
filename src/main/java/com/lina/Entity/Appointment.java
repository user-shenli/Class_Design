package com.lina.Entity;

import java.time.LocalDateTime;

public class Appointment {
    private Integer appointmentId;
    private Integer carId;
    private Integer userId;
    private LocalDateTime appointmentTime;

    private String CreatedAt;


    public Appointment() {

    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", carId=" + carId +
                ", userId=" + userId +
                ", appointmentTime=" + appointmentTime +
                '}';
    }

    // Constructors, getters and setters
    public Appointment(String createdAt) {
        CreatedAt = createdAt;
    }

    public Appointment(Integer appointmentId, Integer carId, Integer userId, LocalDateTime appointmentTime, String status, String createdAt) {
        this.appointmentId = appointmentId;
        this.carId = carId;
        this.userId = userId;
        this.appointmentTime = appointmentTime;

        CreatedAt = createdAt;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }


// Getters and setters
    // ...

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    public void setQuantity(int quantity) {
    }

    public Object getQuantity() {
        return null;
    }
}