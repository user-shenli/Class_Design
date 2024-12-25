package com.lina.Swing.Feedback;

import com.lina.Funcation.FeedbackFun;
import com.lina.Entity.Feedback; // 确保导入正确的 Feedback 实体类

import com.lina.Swing.User.UserMainFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FeedbackQueryFrame extends JFrame {
    public FeedbackQueryFrame() {
        setTitle("反馈信息展示");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 获取反馈信息列表
        List<Feedback> feedbackList = FeedbackFun.getAllFeedbacks();

        // 创建表格模型
        DefaultTableModel tableModel = new DefaultTableModel();
        // 设置表头
        tableModel.setColumnIdentifiers(new Object[]{"反馈编号", "车辆编号", "用户编号", "评分", "评论", "创建时间"});
        // 遍历反馈列表，将数据添加到表格模型中
        for (Feedback feedback : feedbackList) {
            tableModel.addRow(new Object[]{
                    feedback.getFeedbackId(),
                    feedback.getCarId(),
                    feedback.getUserId(),
                    feedback.getRating(),
                    feedback.getComment(),
                    feedback.getCreatedAt()
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
            FeedbackQueryFrame frame = new FeedbackQueryFrame();
            frame.setVisible(true);
        });
    }
}