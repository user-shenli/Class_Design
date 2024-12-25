package com.lina.Swing.Appointment;

import com.lina.Funcation.AppointmentFun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AppointmentAddFrame extends JFrame {
    private JTextField userIdField, carIdField, appointmentDateField, timeField, statusField;

    public AppointmentAddFrame() {
        setTitle("新增预约");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("用户ID:"));
        userIdField = new JTextField();
        panel.add(userIdField);

        panel.add(new JLabel("汽车ID:"));
        carIdField = new JTextField();
        panel.add(carIdField);

        panel.add(new JLabel("预约日期:"));
        appointmentDateField = new JTextField();
        panel.add(appointmentDateField);

        panel.add(new JLabel("时间:"));
        timeField = new JTextField();
        panel.add(timeField);

        panel.add(new JLabel("状态:"));
        statusField = new JTextField();
        panel.add(statusField);

        JButton addButton = new JButton("添加预约");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AppointmentFun.addAppointment(Integer.parseInt(userIdField.getText()), carIdField.getText(), appointmentDateField.getText(), timeField.getText(), statusField.getText());
                    JOptionPane.showMessageDialog(null, "预约添加成功！");
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "预约添加失败: " + ex.getMessage());
                }
            }
        });
        panel.add(addButton);

        JButton backButton = new JButton("返回主界面");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建并显示登录界面
//                new AdminMainFrame().setVisible(true);
                // 关闭当前主界面
                AppointmentAddFrame.this.dispose();
            }
        });
        panel.add(backButton);

        getContentPane().add(panel);
    }
}