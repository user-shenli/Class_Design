package com.lina.Swing.User;

import com.lina.Swing.Appointment.AppointmentMainFrame;

import com.lina.Swing.Car.CarQueryFrame;
import com.lina.Swing.Car.CarQueryFrame_user;
import com.lina.Swing.Demand.DemandMainFrame;
import com.lina.Swing.Feedback.FeedbackQueryFrame;
import com.lina.Swing.Login.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMainFrame extends JFrame {
    public UserMainFrame() {
        setTitle("用户主界面");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 3)); // 动态添加组件

        JButton appointmentButton = new JButton("预约买车");
        appointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AppointmentMainFrame().setVisible(true);
            }
        });
        panel.add(appointmentButton);

        JButton carButton = new JButton("看车");
        carButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CarQueryFrame_user().setVisible(true);
            }
        });
        panel.add(carButton);

        JButton demandButton = new JButton("我要订车");
        demandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DemandMainFrame().setVisible(true);
            }
        });
        panel.add(demandButton);

        JButton feedbackButton = new JButton("售后服务");
        feedbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FeedbackQueryFrame().setVisible(true);
            }
        });
        panel.add(feedbackButton);

        JButton FavoriteButton = new JButton("我的收藏");
        feedbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FeedbackQueryFrame().setVisible(true);
            }
        });
        panel.add(feedbackButton);

        JButton queryCarButton = new JButton("根据汽车找商家");
        queryCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CarQueryFrame_user().setVisible(true);
                //todo
            }
        });
        panel.add(queryCarButton);

        JButton backButton = new JButton("返回登录");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建并显示登录界面
                new LoginFrame().setVisible(true);
                // 关闭当前主界面
                UserMainFrame.this.dispose();
            }
        });
        panel.add(backButton);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserMainFrame frame = new UserMainFrame();
            frame.setVisible(true);
        });
    }
}