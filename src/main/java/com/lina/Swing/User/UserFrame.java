package com.lina.Swing.User;

import com.lina.Swing.Login.AdminMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFrame extends JFrame {
    public UserFrame() {
        setTitle("用户管理");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton addUserButton = new JButton("新增用户");
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserAddFrame().setVisible(true);
            }
        });
        panel.add(addUserButton);

        JButton updateUserButton = new JButton("更新用户");
        updateUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserUpdateFrame().setVisible(true);
            }
        });
        panel.add(updateUserButton);

        JButton deleteUserButton = new JButton("删除用户");
        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserDeleteFrame().setVisible(true);
            }
        });
        panel.add(deleteUserButton);

        JButton queryUsersButton = new JButton("查询用户");
        queryUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserQueryFrame().setVisible(true);
            }
        });
        panel.add(queryUsersButton);

        JButton backButton = new JButton("返回主界面");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建并显示登录界面
//                new AdminMainFrame().setVisible(true);
                // 关闭当前主界面
                UserFrame.this.dispose();
            }
        });
        panel.add(backButton);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserFrame frame = new UserFrame();
            frame.setVisible(true);
        });
    }
}