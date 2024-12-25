package com.lina.Swing.Demand;

import com.lina.Funcation.DemandFun;
import com.lina.Entity.Demand; // 确保导入正确的 Demand 实体类
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

public class DemandQueryFrame extends JFrame {
    public DemandQueryFrame() {
        setTitle("需求信息展示");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 获取需求信息列表
        List<Demand> demandList = DemandFun.getAllDemands();

        // 创建表格模型
        DefaultTableModel tableModel = new DefaultTableModel();
        // 设置表头
        tableModel.setColumnIdentifiers(new Object[]{"需求编号", "用户编号", "品牌", "型号", "最高价格", "描述"});
        // 遍历需求列表，将数据添加到表格模型中
        for (Demand demand : demandList) {
            tableModel.addRow(new Object[]{
                    demand.getDemandId(),
                    demand.getUserId(),
                    demand.getMake(),
                    demand.getModel(),
                    demand.getMaxPrice(),
                    demand.getDescription()
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
                DemandMainFrame mainView = new DemandMainFrame();
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
            DemandQueryFrame frame = new DemandQueryFrame();
            frame.setVisible(true);
        });
    }
}