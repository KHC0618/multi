package com.multi.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practice {

    static int now = 0;
    static boolean check = true;
    static int count = 0;

    public static void main(String[] args) {
        String[] titles = {"다만 악에서", "오케이 마담", "테넷", "짱구는 못말려", "캐리비안 해적"};
        String[] images = {"다만.png", "오케이.png", "테넷.png", "짱구.png", "해적.png"};
        String[] directors = {"홍원찬", "오케이감독", "크리스토퍼 놀란", "하시모토 마사카즈", "마리트 모움"};
        double[] rates = {7.79, 6.61, 8.88, 9.99, 5.65};

        JFrame f = new JFrame();
        f.setSize(450, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("영화 예매");
        f.getContentPane().setLayout(null);

        JPanel moviePanel = new JPanel(); // 영화 정보를 보여주는 패널
        moviePanel.setLayout(null);
        moviePanel.setBounds(0, 0, 450, 370);
        f.getContentPane().add(moviePanel);

        JLabel img = new JLabel();
        img.setIcon(new ImageIcon("img/" + images[now]));
        img.setBounds(205, 55, 195, 270);
        moviePanel.add(img);

        JLabel titleLabel = new JLabel("현재 상영작");
        titleLabel.setBounds(25, 40, 200, 50);
        titleLabel.setFont(new Font("굴림", Font.BOLD, 30));
        moviePanel.add(titleLabel);

        JLabel dirLabel = new JLabel("감독 : " + directors[now]);
        dirLabel.setBounds(25, 320, 300, 50);
        dirLabel.setFont(new Font("굴림", Font.BOLD, 20));
        moviePanel.add(dirLabel);

        JLabel rateLabel = new JLabel("평점 : " + rates[now]);
        rateLabel.setBounds(283, 320, 300, 50);
        rateLabel.setFont(new Font("굴림", Font.BOLD, 20));
        moviePanel.add(rateLabel);

        for (int i = 0; i < titles.length; i++) {
            JButton titleButton = new JButton(titles[i]);
            titleButton.setBackground(Color.DARK_GRAY);
            titleButton.setForeground(Color.WHITE);
            titleButton.setBounds(25, 80 + (i * 50), 170, 50);
            titleButton.setFont(new Font("굴림", Font.BOLD, 20));
            titleButton.setActionCommand(String.valueOf(i));
            moviePanel.add(titleButton);

            titleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    int titleNumber = Integer.parseInt(command);
                    dirLabel.setText("감독 : " + directors[titleNumber]);
                    rateLabel.setText("평점 : " + rates[titleNumber]);
                    ImageIcon icon = new ImageIcon(("img/" + images[titleNumber]));
                    img.setIcon(icon);
                }
            });
        }

        JButton ticketButton = new JButton("예매하기");
        ticketButton.setBounds(250, 370, 133, 50);
        ticketButton.setFont(new Font("굴림", Font.BOLD, 15));
        f.add(ticketButton);

        JPanel ticketPanel = new JPanel(); // 예매 화면을 보여주는 패널
        ticketPanel.setBounds(0, 0, 450, 370);
        f.getContentPane().add(ticketPanel);
        ticketPanel.setVisible(false);
        FlowLayout flow = new FlowLayout();
        ticketPanel.setLayout(flow);

        int[] seat = new int[80];
        for (int i = 0; i < seat.length; i++) {
            JButton b = new JButton((i + 1) + "");
            ticketPanel.add(b);

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
        ticketPanel.add(pay);

        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        ticketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 예매하기 버튼을 눌렀을 때, 예매 화면으로 전환
                if(check){
                    ticketButton.setText("뒤로가기");
                    moviePanel.setVisible(false);
                    ticketPanel.setVisible(true);
                    check = false;
                } else {
                    ticketButton.setText("예매하기");
                    moviePanel.setVisible(true);
                    ticketPanel.setVisible(false);
                    check = true;
                }
            }
        });

        f.setVisible(true);
    }
}
