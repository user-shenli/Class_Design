package com.lina.Swing.Demand;

import com.lina.Funcation.DemandFun;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DemandAddFrame extends JFrame {
    private JTextField userIdField, makeField, modelField, maxPriceField, descriptionField;

    public DemandAddFrame() {
        setTitle("新增需求");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("用户ID:"));
        userIdField = new JTextField();
        panel.add(userIdField);

        panel.add(new JLabel("品牌:"));
        makeField = new JTextField();
        panel.add(makeField);

        panel.add(new JLabel("型号:"));
        modelField = new JTextField();
        panel.add(modelField);

        panel.add(new JLabel("最高价格:"));
        maxPriceField = new JTextField();
        panel.add(maxPriceField);

        panel.add(new JLabel("描述:"));
        descriptionField = new JTextField();
        panel.add(descriptionField);

        JButton addButton = new JButton("添加需求");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DemandFun.addDemand(Integer.parseInt(userIdField.getText()), makeField.getText(), modelField.getText(), String.valueOf(Double.parseDouble(maxPriceField.getText())), descriptionField.getText());
                    JOptionPane.showMessageDialog(null, "需求添加成功！");
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "需求添加失败: " + ex.getMessage());
                }
            }
        });
        panel.add(addButton);

        getContentPane().add(panel);
    }
}