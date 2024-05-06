package com.multi.c_app02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exec01 {
    private static int count = 0;

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 1000);

        FlowLayout flow = new FlowLayout();
        f.setLayout(flow);

        int[] seat = new int[500];
        for (int i = 0; i < seat.length; i++) {
            JButton b = new JButton((i + 1) + "");
            f.add(b);

            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = e.getActionCommand();
                    JOptionPane.showMessageDialog(f, s + "번 예약됨");

                    b.setBackground(Color.red);
                    b.setEnabled(false);

                    int idx = Integer.parseInt(s);
                    seat[idx] = 1;
                    count++;
                }
            });
        }

        JButton pay = new JButton("결제하기");
        f.add(pay);

        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int count = 0;
//                for (int i : seat) {
//                    if (i == 1) {
//                        count++;
//                    }
//                }
                JOptionPane.showMessageDialog(f, "예약된 좌석은 " + count + "개");
                int sum = count * 13000;
                JOptionPane.showMessageDialog(f, "결제금액은  " + sum + "원");
                for(int i : seat) {
                    if (i == 1) {
                        count--;
                    }
                }
            }
        });

        f.setVisible(true);
    }
}
