package com.lina.Swing.Favorite;

import com.lina.Funcation.FavoriteFun;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FavoriteAddFrame extends JFrame {
    private JTextField userIdField, carIdField, priceField, makeField;

    public FavoriteAddFrame() {
        setTitle("新增收藏");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("用户ID:"));
        userIdField = new JTextField();
        panel.add(userIdField);

        panel.add(new JLabel("汽车ID:"));
        carIdField = new JTextField();
        panel.add(carIdField);

        panel.add(new JLabel("价格:"));
        priceField = new JTextField();
        panel.add(priceField);

        panel.add(new JLabel("品牌:"));
        makeField = new JTextField();
        panel.add(makeField);

        JButton addButton = new JButton("添加收藏");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double price = Double.parseDouble(priceField.getText());
                    FavoriteFun.addFavorite(Integer.parseInt(userIdField.getText()), Integer.parseInt(carIdField.getText()), price, makeField.getText());
                    JOptionPane.showMessageDialog(null, "收藏添加成功！");
                    dispose();
                } catch (SQLException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "收藏添加失败: " + ex.getMessage());
                }
            }
        });
        panel.add(addButton);

        getContentPane().add(panel);
    }
}