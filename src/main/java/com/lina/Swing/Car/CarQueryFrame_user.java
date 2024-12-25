package com.lina.Swing.Car;

import com.lina.Funcation.CarFun;
import com.lina.Entity.Car; // 确保导入正确的 Car 实体类
import com.lina.Swing.User.UserMainFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CarQueryFrame_user extends JFrame {
    public CarQueryFrame_user() {
        setTitle("汽车信息展示");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 获取汽车信息列表
        List<Car> carList = CarFun.getAllCars();

        // 创建表格模型
        DefaultTableModel tableModel = new DefaultTableModel();
        // 设置表头
        tableModel.setColumnIdentifiers(new Object[]{"汽车编号", "品牌", "型号", "年份", "里程", "价格", "描述"});
        // 遍历汽车列表，将数据添加到表格模型中
        for (Car car : carList) {
            tableModel.addRow(new Object[]{
                    car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear(),
                    car.getMileage(),
                    car.getPrice(),
                    car.getDescription()
            });
        }

        // 创建表格组件
        JTable table = new JTable(tableModel);
        // 创建滚动面板，用于在表格内容较多时可以滚动查看
        JScrollPane scrollPane = new JScrollPane(table);

        // 将滚动面板添加到窗口
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("返回汽车管理");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserMainFrame adminView = new UserMainFrame();
                adminView.setVisible(true);
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
            CarQueryFrame frame = new CarQueryFrame();
            frame.setVisible(true);
        });
    }
}