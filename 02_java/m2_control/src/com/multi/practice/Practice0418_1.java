package com.multi.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Practice0418_1 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(450, 600);
        FlowLayout flow = new FlowLayout();
        f.getContentPane().setLayout(flow);

        Random random = new Random();
        int ranNum = random.nextInt(10) + 1;

        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton((i + 1) + "번");
            f.getContentPane().add(btn);
            if (ranNum == i) {
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(f, "당첨");
                    }
                });
            } else {
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(f, "꽝");
                    }
                });
            }

        }

        f.setVisible(true);
    }
}
