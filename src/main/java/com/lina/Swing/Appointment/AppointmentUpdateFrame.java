package com.lina.Swing.Appointment;

import com.lina.Funcation.AppointmentFun;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AppointmentUpdateFrame extends JFrame {
    private JTextField appointmentIdField, userIdField, carIdField, appointmentDateField, timeField, statusField;

    public AppointmentUpdateFrame() {
        setTitle("更新预约");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        panel.add(new JLabel("预约ID:"));
        appointmentIdField = new JTextField();
        panel.add(appointmentIdField);

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

        JButton updateButton = new JButton("更新预约");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AppointmentFun.updateAppointment(Integer.parseInt(appointmentIdField.getText()), Integer.parseInt(userIdField.getText()), carIdField.getText(), appointmentDateField.getText(), timeField.getText(), statusField.getText());
                    JOptionPane.showMessageDialog(null, "预约信息更新成功！");
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "预约信息更新失败: " + ex.getMessage());
                }
            }
        });
        panel.add(updateButton);

        getContentPane().add(panel);
    }
}