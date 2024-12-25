package com.lina.Swing.User;

import com.lina.Funcation.UserFun; // 确保这个包和类名是正确的
import com.lina.Swing.Login.AdminMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserDeleteFrame extends JFrame {
    private JTextField userIdField;

    public UserDeleteFrame() {
        setTitle("删除用户");
        setSize(200, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("用户ID:"));
        userIdField = new JTextField();
        panel.add(userIdField);

        JButton deleteButton = new JButton("删除用户");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });
        panel.add(deleteButton);

        getContentPane().add(panel);
        JButton backButton = new JButton("返回");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 关闭当前界面，例如 UserAddFrame
                UserDeleteFrame.this.dispose();
                // 显示主界面
                new AdminMainFrame().setVisible(true);
            }
        });
        panel.add(backButton);
    }

    private void deleteUser() {
        Integer userId = Integer.valueOf(userIdField.getText());

        try {
            UserFun.deleteUser(userId);
            JOptionPane.showMessageDialog(this, "用户删除成功！");
            userIdField.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "删除用户失败: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserDeleteFrame frame = new UserDeleteFrame();
            frame.setVisible(true);
        });
    }
}