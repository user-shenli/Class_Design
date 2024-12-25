package com.lina.Swing.Car;

import com.lina.Funcation.CarFun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CarAddFrame extends JFrame {
    private JTextField userIdField, makeField, modelField, yearField, mileageField, priceField, descriptionField;

    public CarAddFrame() {
        setTitle("新增汽车");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        panel.add(new JLabel("汽车ID:"));
        userIdField = new JTextField();
        panel.add(userIdField);

        panel.add(new JLabel("品牌:"));
        makeField = new JTextField();
        panel.add(makeField);

        panel.add(new JLabel("型号:"));
        modelField = new JTextField();
        panel.add(modelField);

        panel.add(new JLabel("年份:"));
        yearField = new JTextField();
        panel.add(yearField);

        panel.add(new JLabel("里程:"));
        mileageField = new JTextField();
        panel.add(mileageField);

        panel.add(new JLabel("价格:"));
        priceField = new JTextField();
        panel.add(priceField);

        panel.add(new JLabel("描述:"));
        descriptionField = new JTextField();
        panel.add(descriptionField);

        JButton addButton = new JButton("添加汽车");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CarFun.addCar(Integer.parseInt(userIdField.getText()), makeField.getText(), modelField.getText(), Integer.parseInt(yearField.getText()), Integer.parseInt(mileageField.getText()), Double.parseDouble(priceField.getText()), descriptionField.getText());
                    JOptionPane.showMessageDialog(null, "汽车添加成功！");
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "汽车添加失败: " + ex.getMessage());
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
                CarAddFrame.this.dispose();
            }
        });
        panel.add(backButton);

        getContentPane().add(panel);
    }
}