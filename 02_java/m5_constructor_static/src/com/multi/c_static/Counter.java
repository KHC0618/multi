package com.multi.c_static;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter {
    public static int count;

    public static void main(String[] args) {
        JFrame f = new JFrame("나의 카운터 프로그램");
        f.setSize(400, 300);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton plus = new JButton("1더하기");
        JButton reset = new JButton("0으로 초기화");
        JButton minus = new JButton("1빼기");
        JLabel number = new JLabel("0");

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                number.setText(count + "");
            }
        });

        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                number.setText(count + "");
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = 0;
                number.setText(count + "");
            }
        });

        number.setForeground(Color.red);

        Font font = new Font("궁서", Font.BOLD, 15);
        plus.setFont(font);
        reset.setFont(font);
        minus.setFont(font);

        number.setFont(new Font("궁서", Font.BOLD, 150));

        f.add(plus);
        f.add(reset);
        f.add(minus);
        f.add(number);

        f.setVisible(true);
    }
}
