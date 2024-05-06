package com.multi.d_practice;

import javax.swing.*;
import java.awt.*;

public class Exec01 {
    public static void main(String[] args) {
        JFrame j = new JFrame();
        j.getContentPane().setLayout(new BorderLayout(0, 0));

        JButton btn1 = new JButton("중앙");
        j.getContentPane().add(btn1, BorderLayout.CENTER);

        JButton btn2 = new JButton("동쪽");
        j.getContentPane().add(btn2, BorderLayout.EAST);

        JButton btn3 = new JButton("서쪽");
        j.getContentPane().add(btn3, BorderLayout.WEST);

        JButton btn4 = new JButton("남쪽");
        j.getContentPane().add(btn4, BorderLayout.SOUTH);

        JButton btn5 = new JButton("북쪽");
        j.getContentPane().add(btn5, BorderLayout.NORTH);

        j.setSize(700, 500);
        j.setVisible(true);
    }
}
