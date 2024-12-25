package com.lina.Swing.Login;

import com.lina.Swing.Appointment.AppointmentAddFrame;
import com.lina.Swing.Appointment.AppointmentQueryFrame;
import com.lina.Swing.Car.CarAddFrame;
import com.lina.Swing.Car.CarMainFrame;
import com.lina.Swing.Demand.DemandQueryFrame;
import com.lina.Swing.User.UserFrame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainFrame extends JFrame {
    public AdminMainFrame() {
        setTitle("管理员主界面");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 3)); // 动态添加组件

        JButton manageUsersButton = new JButton("管理用户");
        manageUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开管理用户界面
                new UserFrame().setVisible(true);
            }
        });
        panel.add(manageUsersButton);

        JButton manageCarsButton = new JButton("管理汽车");
        manageCarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开管理汽车界面
                new CarMainFrame().setVisible(true);
            }
        });
        panel.add(manageCarsButton);

        JButton addCarButton = new JButton("发布车辆");
        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开新增汽车界面
                new CarAddFrame().setVisible(true);
            }
        });
        panel.add(addCarButton);

        JButton viewDemandsButton = new JButton("查看用户需求");
        viewDemandsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开查看需求界面
                new DemandQueryFrame().setVisible(true);
            }
        });
        panel.add(viewDemandsButton);

        JButton addAppointmentButton = new JButton("车辆预售");
        addAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开新增预约界面
                new AppointmentAddFrame().setVisible(true);
            }
        });
        panel.add(addAppointmentButton);

        JButton viewAppointmentsButton = new JButton("查询用户预约购车");
        viewAppointmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开查询预约界面
                new AppointmentQueryFrame().setVisible(true);
            }
        });
        panel.add(viewAppointmentsButton);

        JButton backButton = new JButton("返回登录");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建并显示登录界面
                new LoginFrame().setVisible(true);
                // 关闭当前主界面
                AdminMainFrame.this.dispose();
            }
        });
        panel.add(backButton);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminMainFrame frame = new AdminMainFrame();
            frame.setVisible(true);
        });
    }
}