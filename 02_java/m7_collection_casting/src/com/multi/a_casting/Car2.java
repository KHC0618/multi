package com.multi.a_casting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Car2 {

    static JFrame f = new JFrame();

    public static void main(String[] args) {
        f.setSize(400, 800);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton red = new JButton("---차1---");
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car2.show("img/car01.png");
            }
        });
        JButton yellow = new JButton("---차2---");
        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car2.show("img/car02.png");
            }
        });
        JButton blue = new JButton("---차3---");
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car2.show("img/car03.png");
            }
        });
        f.add(red);
        f.add(yellow);
        f.add(blue);

        f.setVisible(true);
    }

    public static void show(String path) {
        ImageIcon icon = new ImageIcon(path);
        JLabel label = new JLabel();
        label.setIcon(icon);
        f.add(label);
        f.setVisible(true);
    }
}
