package com.lina.Swing.User;

import com.lina.Funcation.UserFun;
import com.lina.Swing.Login.AdminMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserAddFrame extends JFrame {
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField emailField;
    private JTextField phoneNumberField;
    private JTextField roleField;
    private JCheckBox isActiveCheckBox;

    public UserAddFrame() {
        setTitle("新增用户");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 创建输入面板
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        // 添加输入字段
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

        // 添加提交按钮
        JButton submitButton = new JButton("新增用户");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });
        panel.add(submitButton);

        // 添加面板到框架
        getContentPane().add(panel);
        JButton backButton = new JButton("返回");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 关闭当前界面，例如 UserAddFrame
                UserAddFrame.this.dispose();
                // 显示主界面
                new AdminMainFrame().setVisible(true);
            }
        });
        panel.add(backButton);
    }

    private void addUser() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        String role = roleField.getText();
        Boolean isActive = isActiveCheckBox.isSelected();

        try {
            UserFun.addUser(username, password, email, phoneNumber, role, isActive);
            JOptionPane.showMessageDialog(this, "用户新增成功！");
            clearFields(); // 清空输入框
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "新增用户失败: " + e.getMessage());
        }
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        emailField.setText("");
        phoneNumberField.setText("");
        roleField.setText("");
        isActiveCheckBox.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserAddFrame frame = new UserAddFrame();
            frame.setVisible(true);
        });
    }
}