package com.lina.Swing.Favorite;

import com.lina.Funcation.FavoriteFun;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoriteQueryFrame extends JFrame {
    private JTextArea queryResult;

    public FavoriteQueryFrame() {
        setTitle("查询收藏");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton queryButton = new JButton("查询所有收藏");
        queryButton.addActionListener(e -> queryFavorites());
        panel.add(queryButton, BorderLayout.SOUTH);

        queryResult = new JTextArea();
        queryResult.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(queryResult);
        panel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(panel);
    }

    private void queryFavorites() {
        StringBuilder favoriteInfo = new StringBuilder();
        try (ResultSet rs = FavoriteFun.queryFavorites()) {
            while (rs.next()) {
                int id = rs.getInt("favorite_id");
                int userId = rs.getInt("user_id");
                String carId = rs.getString("car_id");
                double price = rs.getDouble("price");
                String make = rs.getString("make");

                favoriteInfo.append("收藏ID: ").append(id)
                        .append(", 用户ID: ").append(userId)
                        .append(", 汽车ID: ").append(carId)
                        .append(", 价格: ").append(price)
                        .append(", 品牌: ").append(make)
                        .append("\n\n");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "查询失败: " + e.getMessage());
            return;
        }

        queryResult.setText(favoriteInfo.toString());
    }
}