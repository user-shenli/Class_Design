package com.lina.Funcation;

import com.lina.Entity.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentFun {
    private static final String URL = "jdbc:mysql://localhost:3306/class_design";
    private static final String USER = "root";
    private static final String PASSWORD = "170121";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 添加预约信息
    public static void addAppointment(int userId, String carId, String appointmentDate, String time, String status) throws SQLException {
        String sql = "INSERT INTO Appointments (user_id, car_id, appointment_date, time, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, carId);
            pstmt.setString(3, appointmentDate);
            pstmt.setString(4, time);
            pstmt.setString(5, status);
            pstmt.executeUpdate();
        }
    }

    // 更新预约信息
    public static void updateAppointment(int appointmentId, int userId, String carId, String appointmentDate, String time, String status) throws SQLException {
        String sql = "UPDATE Appointments SET user_id = ?, car_id = ?, appointment_date = ?, time = ?, status = ? WHERE appointment_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, carId);
            pstmt.setString(3, appointmentDate);
            pstmt.setString(4, time);
            pstmt.setString(5, status);
            pstmt.setInt(6, appointmentId);
            pstmt.executeUpdate();
        }
    }

    // 删除预约信息
    public static void deleteAppointment(int appointmentId) throws SQLException {
        String sql = "DELETE FROM Appointments WHERE appointment_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            pstmt.executeUpdate();
        }
    }

    // 查询所有预约信息


        public static List<Appointment> getAllAppointments() {
            List<Appointment> appointmentList = new ArrayList<>();
            String sql = "SELECT appointment_id, car_id, user_id, appointment_time, created_at, quantity FROM Appointments"; // 确保 SQL 语句正确

            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    Appointment appointment = new Appointment();
                    appointment.setAppointmentId(rs.getInt("appointment_id"));
                    appointment.setCarId(rs.getInt("car_id"));
                    appointment.setUserId(rs.getInt("user_id"));
                    appointment.setAppointmentTime(rs.getTimestamp("appointment_time").toLocalDateTime());
                    appointment.setCreatedAt(String.valueOf(rs.getTimestamp("created_at")));
                    appointment.setQuantity(rs.getInt("quantity"));
                    appointmentList.add(appointment);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return appointmentList;
        }
    // 根据用户ID查询预约信息
    public static ResultSet queryAppointmentsByUser(int userId) throws SQLException {
        String sql = "SELECT * FROM Appointments WHERE user_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            return pstmt.executeQuery();
        }
    }
}