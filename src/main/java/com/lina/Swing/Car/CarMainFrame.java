package com.lina.Swing.Car;

import com.lina.Swing.Login.AdminMainFrame;
import com.lina.Swing.User.UserFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarMainFrame extends JFrame {
    public CarMainFrame() {
        setTitle("汽车管理");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton addButton = new JButton("新增汽车");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CarAddFrame().setVisible(true);
            }
        });

        JButton updateButton = new JButton("更新汽车");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CarUpdateFrame().setVisible(true);
            }
        });

        JButton deleteButton = new JButton("删除汽车");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CarDeleteFrame().setVisible(true);
            }
        });

        JButton queryButton = new JButton("查询汽车");
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CarQueryFrame().setVisible(true);
            }
        });

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(queryButton);

        JButton backButton = new JButton("返回主界面");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建并显示登录界面
//                new AdminMainFrame().setVisible(true);
                // 关闭当前主界面
                CarMainFrame.this.dispose();
            }
        });
        panel.add(backButton);
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarMainFrame frame = new CarMainFrame();
            frame.setVisible(true);
        });
    }
}