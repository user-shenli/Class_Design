package com.lina.Swing.Demand;

import com.lina.Funcation.DemandFun;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DemandUpdateFrame extends JFrame {
    private JTextField demandIdField, userIdField, makeField, modelField, maxPriceField, descriptionField;

    public DemandUpdateFrame() {
        setTitle("更新需求");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        panel.add(new JLabel("需求ID:"));
        demandIdField = new JTextField();
        panel.add(demandIdField);

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

        JButton updateButton = new JButton("更新需求");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DemandFun.updateDemand(Integer.parseInt(demandIdField.getText()), Integer.parseInt(userIdField.getText()), makeField.getText(), modelField.getText(), String.valueOf(Double.parseDouble(maxPriceField.getText())), descriptionField.getText());
                    JOptionPane.showMessageDialog(null, "需求更新成功！");
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "需求更新失败: " + ex.getMessage());
                }
            }
        });
        panel.add(updateButton);

        getContentPane().add(panel);
    }
}