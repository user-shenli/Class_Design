package com.lina.Swing.Car;

import com.lina.Funcation.CarFun;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CarDeleteFrame extends JFrame {
    private JTextField carIdField;

    public CarDeleteFrame() {
        setTitle("删除汽车");
        setSize(200, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("汽车ID:"));
        carIdField = new JTextField();
        panel.add(carIdField);

        JButton deleteButton = new JButton("删除汽车");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CarFun.deleteCar(Integer.parseInt(carIdField.getText()));
                    JOptionPane.showMessageDialog(null, "汽车删除成功！");
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "汽车删除失败: " + ex.getMessage());
                }
            }
        });
        panel.add(deleteButton);

        getContentPane().add(panel);
    }
}