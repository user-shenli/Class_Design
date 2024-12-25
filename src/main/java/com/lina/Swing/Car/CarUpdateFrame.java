package com.lina.Swing.Car;

import com.lina.Funcation.CarFun;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CarUpdateFrame extends JFrame {
    private JTextField carIdField, userIdField, makeField, modelField, yearField, mileageField, priceField, descriptionField;

    public CarUpdateFrame() {
        setTitle("更新汽车");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        panel.add(new JLabel("汽车ID:"));
        carIdField = new JTextField();
        panel.add(carIdField);

        panel.add(new JLabel("用户ID:"));
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

        JButton updateButton = new JButton("更新汽车");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CarFun.updateCar(Integer.parseInt(carIdField.getText()), Integer.parseInt(userIdField.getText()), makeField.getText(), modelField.getText(), Integer.parseInt(yearField.getText()), Integer.parseInt(mileageField.getText()), Double.parseDouble(priceField.getText()), descriptionField.getText());
                    JOptionPane.showMessageDialog(null, "汽车信息更新成功！");
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "汽车信息更新失败: " + ex.getMessage());
                }
            }
        });
        panel.add(updateButton);

        getContentPane().add(panel);
    }
}