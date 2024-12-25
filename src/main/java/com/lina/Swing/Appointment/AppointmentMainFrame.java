package com.lina.Swing.Appointment;

import com.lina.Swing.User.UserFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmentMainFrame extends JFrame {
    public AppointmentMainFrame() {
        setTitle("预约管理");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton addAppointmentButton = new JButton("新增预约");
        addAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AppointmentAddFrame().setVisible(true);
            }
        });
        panel.add(addAppointmentButton);

        JButton updateAppointmentButton = new JButton("更新预约");
        updateAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AppointmentUpdateFrame().setVisible(true);
            }
        });
        panel.add(updateAppointmentButton);

        JButton deleteAppointmentButton = new JButton("删除预约");
        deleteAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AppointmentDeleteFrame().setVisible(true);
            }
        });
        panel.add(deleteAppointmentButton);

        JButton queryAppointmentButton = new JButton("查询预约");
        queryAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AppointmentQueryFrame().setVisible(true);
            }
        });
        panel.add(queryAppointmentButton);

        JButton backButton = new JButton("返回主界面");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建并显示登录界面
//                new AdminMainFrame().setVisible(true);
                // 关闭当前主界面
                AppointmentMainFrame.this.dispose();
            }
        });
        panel.add(backButton);
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppointmentMainFrame frame = new AppointmentMainFrame();
            frame.setVisible(true);
        });
    }
}