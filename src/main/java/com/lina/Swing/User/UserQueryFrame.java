package com.lina.Swing.User;

import com.lina.Funcation.UserFun;
import com.lina.Entity.User; // 确保导入正确的 User 实体类
import com.lina.Swing.Login.AdminMainFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserQueryFrame extends JFrame {
    public UserQueryFrame() {
        setTitle("用户信息展示");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 获取用户信息列表
        List<User> userList = UserFun.getAllUsers();

        // 创建表格模型
        DefaultTableModel tableModel = new DefaultTableModel();
        // 设置表头
        tableModel.setColumnIdentifiers(new Object[]{"用户编号", "用户名", "用户密码"});
        // 遍历用户列表，将数据添加到表格模型中
        for (User user : userList) {
            tableModel.addRow(new Object[]{
                    user.getUserId(),
                    user.getUsername(),
                    user.getPassword()
            });
        }

        // 创建表格组件
        JTable table = new JTable(tableModel);
        // 创建滚动面板，用于在表格内容较多时可以滚动查看
        JScrollPane scrollPane = new JScrollPane(table);

        // 将滚动面板添加到窗口
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("返回管理员界面");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMainFrame adminView = new AdminMainFrame();
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
            UserQueryFrame frame = new UserQueryFrame();
            frame.setVisible(true);
        });
    }
}