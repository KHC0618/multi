package com.multi.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practice0418_2 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.green);
        f.setSize(525, 650);
        f.getContentPane().setLayout(null);

        JLabel nameLabel = new JLabel("아이디: ");
        nameLabel.setFont(new Font("굴림", Font.BOLD, 20));
        nameLabel.setBounds(25, 40, 105, 43);
        f.getContentPane().add(nameLabel);

        JTextField textField1 = new JTextField();
        textField1.setForeground(Color.blue);
        textField1.setBackground(Color.yellow);
        textField1.setFont(new Font("굴림", Font.BOLD, 20));
        textField1.setBounds(137, 40, 284, 37);
        f.getContentPane().add(textField1);

        JLabel nameLabel2 = new JLabel("패스워드: ");
        nameLabel2.setFont(new Font("굴림", Font.BOLD, 20));
        nameLabel2.setBounds(25, 115, 105, 43);
        f.getContentPane().add(nameLabel2);

        JTextField textField2 = new JTextField();
        textField2.setForeground(Color.blue);
        textField2.setBackground(Color.yellow);
        textField2.setFont(new Font("굴림", Font.BOLD, 20));
        textField2.setBounds(137, 115, 284, 37);
        f.getContentPane().add(textField2);

        JLabel loginLabel = new JLabel();
        loginLabel.setFont(new Font("굴림", Font.PLAIN, 20));
        loginLabel.setBounds(40, 200, 475, 100);
        f.getContentPane().add(loginLabel);

        JButton jButton = new JButton("로그인 확인");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().equals("root") && textField2.getText().equals("1234")) {
                    loginLabel.setText("로그인 성공");
                    loginLabel.setForeground(Color.blue);
                } else {
                    loginLabel.setText("로그인 실패");
                    loginLabel.setForeground(Color.red);
                }
            }
        });
        jButton.setBackground(Color.pink);
        jButton.setFont(new Font("굴림", Font.BOLD, 20));
        jButton.setBounds(40, 175, 150, 56);
        f.getContentPane().add(jButton);

        JButton jButton2 = new JButton("지우기");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
            }
        });
        jButton2.setBackground(Color.pink);
        jButton2.setFont(new Font("굴림", Font.BOLD, 20));
        jButton2.setBounds(215, 175, 100, 56);
        f.getContentPane().add(jButton2);

        f.setVisible(true);
    }
}
