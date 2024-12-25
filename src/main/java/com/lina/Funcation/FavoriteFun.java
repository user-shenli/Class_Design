package com.lina.Funcation;

import java.sql.*;

public class FavoriteFun {
    private static final String URL = "jdbc:mysql://localhost:3306/class_design";
    private static final String USER = "root";
    private static final String PASSWORD = "170121";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 添加收藏信息
    public static void addFavorite(int userId, int carId, double price, String make) throws SQLException {
        String sql = "INSERT INTO Favorites (user_id, car_id, price, make) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, carId);
            pstmt.setDouble(3, price);
            pstmt.setString(4, make);
            pstmt.executeUpdate();
        }
    }

    // 删除收藏信息
    public static void deleteFavorite(int favoriteId) throws SQLException {
        String sql = "DELETE FROM Favorites WHERE favorite_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, favoriteId);
            pstmt.executeUpdate();
        }
    }

    // 查询所有收藏信息
    public static ResultSet queryFavorites() throws SQLException {
        String sql = "SELECT * FROM Favorites";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            return pstmt.executeQuery();
        }
    }

    // 根据用户ID查询收藏信息
    public static ResultSet queryFavoritesByUser(int userId) throws SQLException {
        String sql = "SELECT * FROM Favorites WHERE user_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            return pstmt.executeQuery();
        }
    }
}