package com.multi.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practice0418_3 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.green);
        f.setSize(525, 650);
        f.getContentPane().setLayout(null);

        JLabel nameLabel = new JLabel("먹고 싶은 음식 ");
        nameLabel.setFont(new Font("굴림", Font.BOLD, 20));
        nameLabel.setBounds(25, 40, 200, 43);
        f.getContentPane().add(nameLabel);

        JTextField textField1 = new JTextField();
        textField1.setBackground(Color.orange);
        textField1.setFont(new Font("굴림", Font.BOLD, 20));
        textField1.setBounds(200, 40, 170, 37);
        f.getContentPane().add(textField1);

        JButton jButton = new JButton("어디로 갈까?");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String drink = textField1.getText();
                if(drink.equals("커피") || drink.equals("아메리카노") || drink.equals("아이스 아메리카노") || drink.equals("홍차")) {
                    JOptionPane.showMessageDialog(f, "카페로 갑시다.");
                    textField1.setText("");
                } else {
                    JOptionPane.showMessageDialog(f, "물이나 마셔요.");
                    textField1.setText("");
                }
            }
        });
        jButton.setFont(new Font("굴림", Font.BOLD, 20));
        jButton.setBounds(40, 90, 400, 50);
        f.getContentPane().add(jButton);


        JLabel nameLabel2 = new JLabel("당신의 나이는 ");
        nameLabel2.setFont(new Font("굴림", Font.BOLD, 20));
        nameLabel2.setBounds(25, 150, 200, 43);
        f.getContentPane().add(nameLabel2);

        JTextField textField2 = new JTextField();
        textField2.setBackground(Color.LIGHT_GRAY);
        textField2.setFont(new Font("굴림", Font.BOLD, 20));
        textField2.setBounds(200, 150, 170, 37);
        f.getContentPane().add(textField2);

        JButton jButton2 = new JButton("나의 내년 나이는? ");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int age = Integer.parseInt(textField2.getText());
                JOptionPane.showMessageDialog(f, age + 1);
                textField2.setText("");
            }
        });
        jButton2.setFont(new Font("굴림", Font.BOLD, 20));
        jButton2.setBounds(40, 200, 400, 50);
        f.getContentPane().add(jButton2);


        JLabel nameLabel3 = new JLabel("국어 점수 ");
        nameLabel3.setFont(new Font("굴림", Font.BOLD, 20));
        nameLabel3.setBounds(25, 260, 200, 43);
        f.getContentPane().add(nameLabel3);

        JTextField textField3 = new JTextField();
        textField3.setBackground(Color.cyan);
        textField3.setFont(new Font("굴림", Font.BOLD, 20));
        textField3.setBounds(200, 260, 170, 37);
        f.getContentPane().add(textField3);

        JLabel nameLabel4 = new JLabel("수학 점수 ");
        nameLabel4.setFont(new Font("굴림", Font.BOLD, 20));
        nameLabel4.setBounds(25, 310, 200, 43);
        f.getContentPane().add(nameLabel4);

        JTextField textField4 = new JTextField();
        textField4.setBackground(Color.cyan);
        textField4.setFont(new Font("굴림", Font.BOLD, 20));
        textField4.setBounds(200, 310, 170, 37);
        f.getContentPane().add(textField4);

        JButton jButton3 = new JButton("두 과목 점수의 평균은? ");
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(textField3.getText());
                int num2 = Integer.parseInt(textField4.getText());
                JOptionPane.showMessageDialog(f, "평균 점수는 " + ((num1 + num2) / 2) + "점 입니다.");
                textField3.setText("");
                textField4.setText("");
            }
        });
        jButton3.setFont(new Font("굴림", Font.BOLD, 20));
        jButton3.setBounds(40, 360, 400, 50);
        f.getContentPane().add(jButton3);

        f.setVisible(true);
    }
}
