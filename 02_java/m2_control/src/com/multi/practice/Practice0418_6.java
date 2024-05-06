package com.multi.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practice0418_6 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.GRAY);
        f.setSize(525, 650);
        f.getContentPane().setLayout(null);

        // 상단 텍스트 박스
        JLabel nameLabel = new JLabel("K-pop 인기 투표");
        nameLabel.setFont(new Font("굴림", Font.PLAIN, 50));
        nameLabel.setBounds(50, 40, 475, 100);
        f.getContentPane().add(nameLabel);

        ImageIcon iconIU = new ImageIcon("src/com/multi/practice/img/lilac.jpg");
        ImageIcon iconPN = new ImageIcon("src/com/multi/practice/img/we_go.jpg");
        ImageIcon iconSC = new ImageIcon("src/com/multi/practice/img/asap.jpg");

        Image imgIU = iconIU.getImage();
        Image imgPN = iconPN.getImage();
        Image imgSC = iconSC.getImage();

        Image changeIU = imgIU.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Image changePN = imgPN.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Image changeSC = imgSC.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        // 아이유
        JButton imgButton1 = new JButton();
        imgButton1.setIcon(new ImageIcon(changeIU));
        imgButton1.setBounds(38, 150, 100, 100);
        f.getContentPane().add(imgButton1);
        JLabel lilacLabel = new JLabel("1. 아이유 - 라일락");
        lilacLabel.setFont(new Font("굴림", Font.PLAIN, 20));
        lilacLabel.setBounds(190, 120, 475, 100);
        f.getContentPane().add(lilacLabel);
        JLabel lilacVoteLabel = new JLabel();
        lilacVoteLabel.setFont(new Font("굴림", Font.PLAIN, 20));
        lilacVoteLabel.setBounds(260, 175, 475, 100);
        f.getContentPane().add(lilacVoteLabel);
        imgButton1.addActionListener(new ActionListener() {
            int iu = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                iu++;
                lilacVoteLabel.setText(iu+"표");
            }
        });

        // 프로미스나인
        JButton imgButton2 = new JButton();
        imgButton2.setIcon(new ImageIcon(changePN));
        imgButton2.setBounds(38, 300, 100, 100);
        f.getContentPane().add(imgButton2);
        JLabel weGoLabel = new JLabel("2. 프로미스나인 - We Go");
        weGoLabel.setFont(new Font("굴림", Font.PLAIN, 20));
        weGoLabel.setBounds(190, 270, 475, 100);
        f.getContentPane().add(weGoLabel);
        JLabel weGoVoteLabel = new JLabel();
        weGoVoteLabel.setFont(new Font("굴림", Font.PLAIN, 20));
        weGoVoteLabel.setBounds(260, 325, 475, 100);
        f.getContentPane().add(weGoVoteLabel);
        imgButton2.addActionListener(new ActionListener() {
            int proNine = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                proNine++;
                weGoVoteLabel.setText(proNine +"표");
            }
        });

        // 스테이씨
        JButton imgButton3 = new JButton();
        imgButton3.setIcon(new ImageIcon(changeSC));
        imgButton3.setBounds(38, 450, 100, 100);
        f.getContentPane().add(imgButton3);
        JLabel asapLabel = new JLabel("3. 스테이씨 - ASAP");
        asapLabel.setFont(new Font("굴림", Font.PLAIN, 20));
        asapLabel.setBounds(190, 420, 475, 100);
        f.getContentPane().add(asapLabel);
        JLabel asapVoteLabel = new JLabel();
        asapVoteLabel.setFont(new Font("굴림", Font.PLAIN, 20));
        asapVoteLabel.setBounds(260, 475, 475, 100);
        f.getContentPane().add(asapVoteLabel);
        imgButton3.addActionListener(new ActionListener() {
            int stayC = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                stayC++;
                asapVoteLabel.setText(stayC +"표");
            }
        });

        f.setVisible(true);

    }
}
