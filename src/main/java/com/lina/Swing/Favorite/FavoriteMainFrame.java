package com.lina.Swing.Favorite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FavoriteMainFrame extends JFrame {
    public FavoriteMainFrame() {
        setTitle("收藏管理");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton addFavoriteButton = new JButton("新增收藏");
        addFavoriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FavoriteAddFrame().setVisible(true);
            }
        });
        panel.add(addFavoriteButton);

        JButton deleteFavoriteButton = new JButton("删除收藏");
        deleteFavoriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FavoriteDeleteFrame().setVisible(true);
            }
        });
        panel.add(deleteFavoriteButton);

        JButton queryFavoriteButton = new JButton("查询收藏");
        queryFavoriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FavoriteQueryFrame().setVisible(true);
            }
        });
        panel.add(queryFavoriteButton);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FavoriteMainFrame frame = new FavoriteMainFrame();
            frame.setVisible(true);
        });
    }
}