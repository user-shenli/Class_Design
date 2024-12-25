package com.lina.Funcation;

import com.lina.Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserFun {
    private static final String URL = "jdbc:mysql://localhost:3306/class_design";
    private static final String USER = "root";
    private static final String PASSWORD = "170121";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void addUser(String username, String password, String email, String phoneNumber, String role, Boolean isActive) throws SQLException {
        String sql = "INSERT INTO Users (username, password, email, phone_number, role, is_active) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, phoneNumber);
            pstmt.setString(5, role);
            pstmt.setBoolean(6, isActive);
            pstmt.executeUpdate();
        }
    }

    public static void updateUser(Integer id, String username, String password, String email, String phoneNumber, String role, Boolean isActive) throws SQLException {
        String sql = "UPDATE Users SET username = ?, password = ?, email = ?, phone_number = ?, role = ?, is_active = ? WHERE User_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, phoneNumber);
            pstmt.setString(5, role);
            pstmt.setBoolean(6, isActive);
            pstmt.setInt(7, id);
            pstmt.executeUpdate();
        }
    }

    public static void deleteUser(Integer id) throws SQLException {
        String sql = "DELETE FROM Users WHERE User_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public static List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT user_id, username, password FROM Users"; // 确保 SQL 语句正确

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


    public static boolean login(String username, String password) throws SQLException {
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // 如果有记录返回true，否则返回false
        }
    }
}
