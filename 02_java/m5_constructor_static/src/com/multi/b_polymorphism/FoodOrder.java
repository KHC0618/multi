package com.multi.b_polymorphism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrder {
//    private static int count;
//    private static final int PRICE = 5000;

//    public static void actionButton(String food, JLabel center, JLabel result, JTextField t1) {
//        count++;
//        center.setIcon(new ImageIcon("images/" + food + ".png"));
//        result.setText("결제금액 : " + (count * PRICE));
//        t1.setText(count + "개");
//    }

    public static void main(String[] args) {
        JFrame f = new JFrame("음식점 주문 화면");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.getContentPane().setBackground(Color.GREEN);
        f.setSize(823, 574);
        f.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("개수:");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
        lblNewLabel.setBounds(489, 37, 68, 46);


        JTextField t1 = new JTextField();
        t1.setBackground(Color.YELLOW);
        t1.setFont(new Font("굴림", Font.BOLD, 40));
        t1.setBounds(556, 32, 239, 44);
        t1.setColumns(10);

        JLabel center = new JLabel("");
        ImageIcon img = new ImageIcon("images/짜장면.png");
        center.setIcon(img);
        center.setBounds(124, 96, 559, 368);

        JLabel result = new JLabel("결제금액");
        result.setForeground(Color.RED);
        result.setFont(new Font("굴림", Font.BOLD, 30));
        result.setBounds(124, 464, 555, 61);

        JButton btnNewButton = new JButton("짬뽕");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                count++;
//                center.setIcon(new ImageIcon("images/짬뽕.png"));
//                result.setText("결제금액 : " + (count * PRICE));
//                t1.setText(count + "개");
//                FoodOrder.actionButton("짬뽕", center, result, t1);
                new ActionButton("짬뽕", center, result, t1);
            }
        });
        btnNewButton.setBackground(Color.MAGENTA);
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 27));
        btnNewButton.setBounds(12, 10, 142, 66);

        JButton btnNewButton_1 = new JButton("우동");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                count++;
//                center.setIcon(new ImageIcon("images/우동.png"));
//                result.setText("결제금액 : " + (count * PRICE));
//                t1.setText(count + "개");
//                FoodOrder.actionButton("우동", center, result, t1);
                new ActionButton("우동", center, result, t1);
            }
        });
        btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 27));
        btnNewButton_1.setBackground(Color.ORANGE);
        btnNewButton_1.setBounds(166, 10, 142, 66);

        JButton btnNewButton_2 = new JButton("짜장면");
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                count++;
//                center.setIcon(new ImageIcon("images/짜장면.png"));
//                result.setText("결제금액 : " + (count * PRICE));
//                t1.setText(count + "개");
//                FoodOrder.actionButton("짜장면", center, result, t1);
                new ActionButton("짜장면", center, result, t1);
            }
        });
        btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 27));
        btnNewButton_2.setBackground(Color.CYAN);
        btnNewButton_2.setBounds(320, 10, 142, 66);

        f.getContentPane().add(lblNewLabel);
        f.getContentPane().add(t1);
        f.getContentPane().add(center);
        f.getContentPane().add(result);
        f.getContentPane().add(btnNewButton);
        f.getContentPane().add(btnNewButton_1);
        f.getContentPane().add(btnNewButton_2);

        f.setVisible(true);
    }
}
