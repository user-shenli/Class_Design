package com.lina.Swing.Appointment;

import com.lina.Funcation.AppointmentFun;
import com.lina.Entity.Appointment; // 确保导入正确的 Appointment 实体类
import com.lina.Swing.User.UserMainFrame;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AppointmentQueryFrame extends JFrame {
    public AppointmentQueryFrame() {
        setTitle("预约信息展示");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 获取预约信息列表
        List<Appointment> appointmentList = AppointmentFun.getAllAppointments();

        // 创建表格模型
        DefaultTableModel tableModel = new DefaultTableModel();
        // 设置表头
        tableModel.setColumnIdentifiers(new Object[]{"预约编号", "车辆编号", "用户编号", "预约时间", "创建时间", "数量"});
        // 遍历预约列表，将数据添加到表格模型中
        for (Appointment appointment : appointmentList) {
            tableModel.addRow(new Object[]{
                    appointment.getAppointmentId(),
                    appointment.getCarId(),
                    appointment.getUserId(),
                    appointment.getAppointmentTime(),
                    appointment.getCreatedAt(),
                    appointment.getQuantity()
            });
        }

        // 创建表格组件
        JTable table = new JTable(tableModel);
        // 创建滚动面板，用于在表格内容较多时可以滚动查看
        JScrollPane scrollPane = new JScrollPane(table);

        // 将滚动面板添加到窗口
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("返回主界面");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 这里需要一个主界面的类，假设为 MainFrame
                UserMainFrame mainView = new UserMainFrame();
                mainView.setVisible(true);
                dispose();
            }
        });

        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.add(backButton);

        add(panel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppointmentQueryFrame frame = new AppointmentQueryFrame();
            frame.setVisible(true);
        });
    }
}