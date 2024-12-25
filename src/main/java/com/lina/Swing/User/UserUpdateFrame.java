package com.lina.Swing.User;

import com.lina.Funcation.UserFun; // 确保这个包和类名是正确的
import com.lina.Swing.Login.AdminMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserUpdateFrame extends JFrame {
    private JTextField userIdField;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField emailField;
    private JTextField phoneNumberField;
    private JTextField roleField;
    private JCheckBox isActiveCheckBox;

    public UserUpdateFrame() {
        setTitle("更新用户");
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        panel.add(new JLabel("用户ID:"));
        userIdField = new JTextField();
        panel.add(userIdField);

        panel.add(new JLabel("用户名:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("密码:"));
        passwordField = new JTextField();
        panel.add(passwordField);

        panel.add(new JLabel("邮箱:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("电话:"));
        phoneNumberField = new JTextField();
        panel.add(phoneNumberField);

        panel.add(new JLabel("角色:"));
        roleField = new JTextField();
        panel.add(roleField);

        panel.add(new JLabel("激活状态:"));
        isActiveCheckBox = new JCheckBox();
        panel.add(isActiveCheckBox);

        JButton updateButton = new JButton("更新用户");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUser();
            }
        });
        panel.add(updateButton);

        getContentPane().add(panel);
        JButton backButton = new JButton("返回");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 关闭当前界面，例如 UserAddFrame
                UserUpdateFrame.this.dispose();
                // 显示主界面
                new AdminMainFrame().setVisible(true);
            }
        });
        panel.add(backButton);
    }

    private void updateUser() {
        Integer userId = Integer.valueOf(userIdField.getText());
        String username = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        String role = roleField.getText();
        Boolean isActive = isActiveCheckBox.isSelected();

        try {
            UserFun.updateUser(userId, username, password, email, phoneNumber, role, isActive);
            JOptionPane.showMessageDialog(this, "用户信息更新成功！");
            clearFields();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "更新用户失败: " + e.getMessage());
        }
    }

    private void clearFields() {
        userIdField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        emailField.setText("");
        phoneNumberField.setText("");
        roleField.setText("");
        isActiveCheckBox.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserUpdateFrame frame = new UserUpdateFrame();
            frame.setVisible(true);
        });
    }
}