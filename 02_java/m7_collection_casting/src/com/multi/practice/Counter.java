package com.multi.practice;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Counter {
    JFrame f = new JFrame();

    JLabel day = new JLabel("시각 : ");
    JLabel timer = new JLabel("사용 시간 : ");

    DateThread date = new DateThread();
    TimeOut time = new TimeOut();

    public Counter() {
        f.setSize(800, 400);
        f.setLayout(null);
        Font font = new Font("궁서", Font.BOLD, 30);

        day.setBounds(10, 300, 800, 50);
        timer.setBounds(10, 100, 800, 50);

        day.setFont(font);
        timer.setFont(font);

        f.add(day);
        f.add(timer);
        f.setVisible(true);

        date.start();
        time.start();

    }

    class DateThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Date date = new Date();
                day.setText("시각 >> " + date);
                Font font = new Font("궁서", Font.BOLD, 30);
                day.setFont(font);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }

            }
        }
    }

    class TimeOut extends Thread {
        @Override
        public void run() {
            int i = 0;
            int j = 0;

            while (j < 5) {
                i++;
                if (i < 60) {
                    timer.setText("사용 시간 : " + j + "분 " + i + "초");
                } else {
                    j++;
                    timer.setText("사용 시간 : " + j + "분 " + (i % 60) + "초");
                    i = 0;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "너무 오래 켜두셨습니다. 강제 종료합니다.");
            f.setVisible(false);
        }
    }
}
