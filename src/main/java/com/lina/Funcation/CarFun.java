package com.lina.Funcation;



import com.lina.Entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarFun {
    private static final String URL = "jdbc:mysql://localhost:3306/class_design";
    private static final String USER = "root";
    private static final String PASSWORD = "170121";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 添加汽车信息
    public static void addCar(int userId, String make, String model, int year, int mileage, double price, String description) throws SQLException {
        String sql = "INSERT INTO Cars (user_id, make, model, year, mileage, price, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, make);
            pstmt.setString(3, model);
            pstmt.setInt(4, year);
            pstmt.setInt(5, mileage);
            pstmt.setDouble(6, price);
            pstmt.setString(7, description);
            pstmt.executeUpdate();
        }
    }

    // 更新汽车信息
    public static void updateCar(int carId, int userId, String make, String model, int year, int mileage, double price, String description) throws SQLException {
        String sql = "UPDATE Cars SET user_id = ?, make = ?, model = ?, year = ?, mileage = ?, price = ?, description = ? WHERE car_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, make);
            pstmt.setString(3, model);
            pstmt.setInt(4, year);
            pstmt.setInt(5, mileage);
            pstmt.setDouble(6, price);
            pstmt.setString(7, description);
            pstmt.setInt(8, carId);
            pstmt.executeUpdate();
        }
    }

    // 删除汽车信息
    public static void deleteCar(int carId) throws SQLException {
        String sql = "DELETE FROM Cars WHERE car_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, carId);
            pstmt.executeUpdate();
        }
    }

    // 查询所有汽车信息
    public static List<Car> getAllCars() {
        List<Car> carList = new ArrayList<>();
        String sql = "SELECT car_id, make, model, year, mileage, price, description FROM Cars"; // 确保 SQL 语句正确

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Car car = new Car();
                car.setCarId(rs.getInt("car_id"));
                car.setMake(rs.getString("make"));
                car.setModel(rs.getString("model"));
                car.setYear(rs.getInt("year"));
                car.setMileage(rs.getInt("mileage"));
                car.setPrice(rs.getDouble("price"));
                car.setDescription(rs.getString("description"));
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    // 根据用户ID查询汽车信息
    public static ResultSet queryCarsByUser(int userId) throws SQLException {
        String sql = "SELECT * FROM Cars WHERE user_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            return pstmt.executeQuery();
        }
    }
}