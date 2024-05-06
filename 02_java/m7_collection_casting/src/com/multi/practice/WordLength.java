package com.multi.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordLength {
    public static void main(String[] args) {
        JFrame f = new JFrame("글자 수 판독기");
        f.setSize(300, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        Font font = new Font("굴림", Font.BOLD, 30);

        JLabel label = new JLabel("글을 적어주세요.");
        JTextArea area = new JTextArea(7, 10);
        area.setAutoscrolls(true);
        area.setLineWrap(true);
        JButton b1 = new JButton("글자수 카운트");
        JButton b2 = new JButton("배경색 바꾸기");
        JButton b3 = new JButton("글자색 바꾸기");

        label.setFont(font);
        area.setFont(font);
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);

        f.add(label);
        f.add(area);
        f.add(b1);
        f.add(b2);
        f.add(b3);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = area.getText();
                JOptionPane.showMessageDialog(f, "글자수는 " + text.length());
            }
        });

        b2.addActionListener(new ActionListener() {
            boolean color = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!color) {
                    area.setBackground(Color.red);
                } else {
                    area.setBackground(Color.white);
                }
                color = !color;
            }
        });

        b3.addActionListener(new ActionListener() {
            boolean color = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!color) {
                    area.setForeground(Color.blue);
                } else {
                    area.setForeground(Color.black);
                }
                color = !color;
            }
        });

        f.setVisible(true);
    }
}
