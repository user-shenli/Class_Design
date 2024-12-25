package com.lina.Swing.Appointment;

import com.lina.Funcation.AppointmentFun;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AppointmentDeleteFrame extends JFrame {
    private JTextField appointmentIdField;

    public AppointmentDeleteFrame() {
        setTitle("删除预约");
        setSize(200, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("预约ID:"));
        appointmentIdField = new JTextField();
        panel.add(appointmentIdField);

        JButton deleteButton = new JButton("删除预约");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AppointmentFun.deleteAppointment(Integer.parseInt(appointmentIdField.getText()));
                    JOptionPane.showMessageDialog(null, "预约删除成功！");
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "预约删除失败: " + ex.getMessage());
                }
            }
        });
        panel.add(deleteButton);

        getContentPane().add(panel);
    }
}