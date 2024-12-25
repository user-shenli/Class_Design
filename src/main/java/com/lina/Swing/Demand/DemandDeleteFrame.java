package com.lina.Swing.Demand;

import com.lina.Funcation.DemandFun;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DemandDeleteFrame extends JFrame {
    private JTextField demandIdField;

    public DemandDeleteFrame() {
        setTitle("删除需求");
        setSize(200, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("需求ID:"));
        demandIdField = new JTextField();
        panel.add(demandIdField);

        JButton deleteButton = new JButton("删除需求");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DemandFun.deleteDemand(Integer.parseInt(demandIdField.getText()));
                    JOptionPane.showMessageDialog(null, "需求删除成功！");
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "需求删除失败: " + ex.getMessage());
                }
            }
        });
        panel.add(deleteButton);

        getContentPane().add(panel);
    }
}