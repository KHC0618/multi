package com.multi.e_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exec04 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.ORANGE);
        f.setSize(525, 650);
        f.getContentPane().setLayout(null);

        JLabel nameLabel = new JLabel("숫자1");
        nameLabel.setFont(new Font("굴림", Font.BOLD, 20));
        nameLabel.setBounds(25, 40, 105, 43);
        f.getContentPane().add(nameLabel);

        JTextField textField1 = new JTextField();
        textField1.setForeground(Color.BLUE);
        textField1.setFont(new Font("굴림", Font.BOLD, 20));
        textField1.setBounds(137, 40, 284, 37);
        f.getContentPane().add(textField1);

        JLabel nameLabel2 = new JLabel("숫자2");
        nameLabel2.setFont(new Font("굴림", Font.BOLD, 20));
        nameLabel2.setBounds(25, 115, 105, 43);
        f.getContentPane().add(nameLabel2);

        JTextField textField2 = new JTextField();
        textField2.setForeground(Color.BLUE);
        textField2.setFont(new Font("굴림", Font.BOLD, 20));
        textField2.setBounds(137, 115, 284, 37);
        f.getContentPane().add(textField2);

        JButton jButton = new JButton("+");

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "플러스 버튼을 누르셨군요.");

                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());

                f.setTitle("더한 결과는 " + (num1 + num2));

                textField1.setText("");
                textField2.setText("");
            }
        });
        jButton.setForeground(Color.WHITE);
        jButton.setBackground(Color.GREEN);
        jButton.setFont(new Font("굴림", Font.BOLD, 20));
        jButton.setBounds(23, 175, 107, 56);
        f.getContentPane().add(jButton);

        JButton jButton2 = new JButton("-");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "마이너스 버튼을 누르셨군요.");

                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());

                f.setTitle("뺀 결과는 " + (num1 - num2));
                JOptionPane.showMessageDialog(f, (num1 - num2));

                textField1.setText("");
                textField2.setText("");
            }
        });
        jButton2.setForeground(Color.WHITE);
        jButton2.setBackground(Color.YELLOW);
        jButton2.setFont(new Font("굴림", Font.BOLD, 20));
        jButton2.setBounds(142, 175, 107, 56);
        f.getContentPane().add(jButton2);

        JButton jButton3 = new JButton("x");
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "곱하기 버튼을 누르셨군요.");

                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());

                f.setTitle("곱한 결과는 " + (num1 * num2));
                JOptionPane.showMessageDialog(f, (num1 * num2));

                textField1.setText("");
                textField2.setText("");
            }
        });
        jButton3.setForeground(Color.WHITE);
        jButton3.setBackground(Color.BLUE);
        jButton3.setFont(new Font("굴림", Font.BOLD, 20));
        jButton3.setBounds(266, 175, 107, 56);
        f.getContentPane().add(jButton3);

        JButton jButton4 = new JButton("/");
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "나누기 버튼을 누르셨군요.");

                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());

                f.setTitle("나눈 결과는 " + (num1 / num2));
                JOptionPane.showMessageDialog(f, (num1 / num2));

                textField1.setText("");
                textField2.setText("");
            }
        });
        jButton4.setForeground(Color.WHITE);
        jButton4.setBackground(Color.RED);
        jButton4.setFont(new Font("굴림", Font.BOLD, 20));
        jButton4.setBounds(385, 175, 107, 56);
        f.getContentPane().add(jButton4);

        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(new ImageIcon("img/giphy.gif"));
        imgLabel.setBounds(38, 241, 422, 321);
        f.getContentPane().add(imgLabel);

        f.setVisible(true);
    }
}
