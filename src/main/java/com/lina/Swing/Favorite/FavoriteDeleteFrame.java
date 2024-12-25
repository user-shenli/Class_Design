package com.lina.Swing.Favorite;

import com.lina.Funcation.FavoriteFun;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FavoriteDeleteFrame extends JFrame {
    private JTextField favoriteIdField;

    public FavoriteDeleteFrame() {
        setTitle("删除收藏");
        setSize(200, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("收藏ID:"));
        favoriteIdField = new JTextField();
        panel.add(favoriteIdField);

        JButton deleteButton = new JButton("删除收藏");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int favoriteId = Integer.parseInt(favoriteIdField.getText());
                    FavoriteFun.deleteFavorite(favoriteId);
                    JOptionPane.showMessageDialog(null, "收藏删除成功！");
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "请输入有效的收藏ID！");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "收藏删除失败: " + ex.getMessage());
                }
            }
        });
        panel.add(deleteButton);

        getContentPane().add(panel);
    }
}