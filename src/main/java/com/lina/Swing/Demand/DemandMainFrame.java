package com.lina.Swing.Demand;

import com.lina.Swing.User.UserFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemandMainFrame extends JFrame {
    public DemandMainFrame() {
        setTitle("需求管理");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton addDemandButton = new JButton("新增需求");
        addDemandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DemandAddFrame().setVisible(true);
            }
        });
        panel.add(addDemandButton);

        JButton updateDemandButton = new JButton("更新需求");
        updateDemandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DemandUpdateFrame().setVisible(true);
            }
        });
        panel.add(updateDemandButton);

        JButton deleteDemandButton = new JButton("删除需求");
        deleteDemandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DemandDeleteFrame().setVisible(true);
            }
        });
        panel.add(deleteDemandButton);

        JButton queryDemandButton = new JButton("查询需求");
        queryDemandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DemandQueryFrame().setVisible(true);
            }
        });
        panel.add(queryDemandButton);
        JButton backButton = new JButton("返回主界面");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建并显示登录界面
//                new AdminMainFrame().setVisible(true);
                // 关闭当前主界面
                DemandMainFrame.this.dispose();
            }
        });
        panel.add(backButton);
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DemandMainFrame frame = new DemandMainFrame();
            frame.setVisible(true);
        });
    }
}