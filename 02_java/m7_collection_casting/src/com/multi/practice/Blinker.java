package com.multi.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Blinker {
    static JFrame f = new JFrame();
    static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {

        f.setSize(800, 800);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("궁서", Font.BOLD, 30);

        JButton red = new JButton("빨간 신호");
        JButton yellow = new JButton("노란 신호");
        JButton green = new JButton("초록 신호");
        JButton counter = new JButton("카운터 호출");

        red.setBackground(Color.red);
        yellow.setBackground(Color.yellow);
        green.setBackground(Color.green);

        red.setFont(font);
        yellow.setFont(font);
        green.setFont(font);
        counter.setFont(font);

        map.put(red.getText(), "src/com/multi/practice/img/redlight.png");
        map.put(yellow.getText(), "src/com/multi/practice/img/yellowlight.png");
        map.put(green.getText(), "src/com/multi/practice/img/greenlight.png");

        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Blinker.show(red.getText());
            }
        });
        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Blinker.show(yellow.getText());
            }
        });
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Blinker.show(green.getText());
            }
        });
        counter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Counter co = new Counter();
            }
        });

        f.add(red);
        f.add(yellow);
        f.add(green);
        f.add(counter);

        f.setVisible(true);
    }

    public static void show(String text) {
        ImageIcon icon = new ImageIcon(map.get(text));
        JLabel label = new JLabel();
        label.setIcon(icon);
        f.add(label);
        f.setVisible(true);
    }
}
