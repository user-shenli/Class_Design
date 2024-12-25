//package com.lina.Swing.Login;
//
//import com.lina.Funcation.User;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.SQLException;
//
//public class LoginFrame extends JFrame {
//    private JTextField usernameField;
//    private JPasswordField passwordField;
//
//    public LoginFrame() {
//        setTitle("登录");
//        setSize(300, 150);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(3, 2));
//
//        panel.add(new JLabel("用户名:"));
//        usernameField = new JTextField();
//        panel.add(usernameField);
//
//        panel.add(new JLabel("密码:"));
//        passwordField = new JPasswordField();
//        panel.add(passwordField);
//
//        JButton loginButton = new JButton("登录");
//        loginButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                login();
//            }
//        });
//        panel.add(loginButton);
//
//        getContentPane().add(panel);
//
//    }
//
//    private void login() {
//        String username = usernameField.getText();
//        String password = new String(passwordField.getPassword());
//
//        try {
//            if (User.login(username, password)) {
//                JOptionPane.showMessageDialog(this, "登录成功！");
//                new AdminMainFrame().setVisible(true);
//                this.dispose(); // 关闭登录界面
//            } else {
//                JOptionPane.showMessageDialog(this, "用户名或密码错误！");
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(this, "登录失败: " + e.getMessage());
//        }
//
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            LoginFrame frame = new LoginFrame();
//            frame.setVisible(true);
//        });
//    }
//}

package com.lina.Swing.Login;

import com.lina.Funcation.UserFun;
import com.lina.Swing.User.UserMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;

    public LoginFrame() {
        setTitle("登录");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("用户名:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("密码:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        panel.add(new JLabel("身份:"));
        roleComboBox = new JComboBox<>(new String[]{"管理员", "用户"});
        panel.add(roleComboBox);

        JButton loginButton = new JButton("登录");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        panel.add(loginButton);

        getContentPane().add(panel);

        JButton backButton = new JButton("关闭");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建并显示登录界面
//                new AdminMainFrame().setVisible(true);
                // 关闭当前主界面
                LoginFrame.this.dispose();
            }
        });
        panel.add(backButton);
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String role = (String) roleComboBox.getSelectedItem();

        try {
            if (UserFun.login(username, password)) {
                JOptionPane.showMessageDialog(this, "登录成功！");
                if ("管理员".equals(role)) {
                    new AdminMainFrame().setVisible(true);
                } else if ("用户".equals(role)) {
                    new UserMainFrame().setVisible(true);
                }
                this.dispose(); // 关闭登录界面
            } else {
                JOptionPane.showMessageDialog(this, "用户名或密码错误！");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "登录失败: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
        });
    }
}