package com.lina.Funcation;

import com.lina.Entity.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackFun {
    private static final String URL = "jdbc:mysql://localhost:3306/class_design";
    private static final String USER = "root";
    private static final String PASSWORD = "170121";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 查询所有反馈信息
    public static List<Feedback> getAllFeedbacks() {
        List<Feedback> feedbackList = new ArrayList<>();
        String sql = "SELECT feedback_id, car_id, user_id, rating, comment, created_at FROM Feedback"; // 确保 SQL 语句正确

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Feedback feedback = new Feedback();
                feedback.setFeedbackId(rs.getInt("feedback_id"));
                feedback.setCarId(rs.getInt("car_id"));
                feedback.setUserId(rs.getInt("user_id"));
                feedback.setRating(rs.getInt("rating"));
                feedback.setComment(rs.getString("comment"));
                feedback.setCreatedAt(rs.getTimestamp("created_at"));
                feedbackList.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbackList;
    }

    // 根据用户ID查询反馈信息
    public static ResultSet queryFeedbacksByUser(int userId) throws SQLException {
        String sql = "SELECT * FROM Feedback WHERE user_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            return pstmt.executeQuery();
        }
    }

    // 根据汽车ID查询反馈信息
    public static ResultSet queryFeedbacksByCar(int carId) throws SQLException {
        String sql = "SELECT * FROM Feedback WHERE car_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, carId);
            return pstmt.executeQuery();
        }
    }
}