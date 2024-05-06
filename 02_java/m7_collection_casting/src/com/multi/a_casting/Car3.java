package com.multi.a_casting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Car3 {

    static JFrame f = new JFrame();

    static HashMap<String, String> map;

    public static void main(String[] args) {
        f.setSize(400, 800);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton red = new JButton("---차1---");
        JButton yellow = new JButton("---차2---");
        JButton blue = new JButton("---차3---");

        f.add(red);
        f.add(yellow);
        f.add(blue);

        map = new HashMap<>();
        map.put("---차1---","img/car01.png");
        map.put("---차2---","img/car02.png");
        map.put("---차3---","img/car03.png");

        System.out.println(map);

        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = e.getActionCommand();
                Car3.show(path);
            }
        });

        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = e.getActionCommand();
                Car3.show(path);
            }
        });

        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = e.getActionCommand();
                Car3.show(path);
            }
        });
        f.setVisible(true);
    }

    public static void show(String path) {
//        if (path.equals("---차1---")) {
//            path = "img/car01.png";
//        } else if (path.equals("---차2---")) {
//            path = "img/car02.png";
//        } else if (path.equals("---차3---")) {
//            path = "img/car03.png";
//        } else {
//            System.out.println("뭔가 잘못 됐습니다.");
//            return;
//        }
        String img = map.get(path);
        ImageIcon icon = new ImageIcon(img);
        JLabel label = new JLabel();
        label.setIcon(icon);
        f.add(label);
        f.setVisible(true);
    }
}
