package com.multi.d_add;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDiary {
    public void open() {
        JFrame f = new JFrame();
        f.getContentPane().setBackground(Color.YELLOW);
        f.setSize(503, 458);
        f.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("오늘날짜");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
        lblNewLabel.setBounds(25, 24, 145, 38);
        f.getContentPane().add(lblNewLabel);

        JTextField t1 = new JTextField();
        t1.setBackground(Color.GREEN);
        t1.setFont(new Font("굴림", Font.BOLD, 30));
        t1.setBounds(197, 24, 267, 38);
        f.getContentPane().add(t1);

        JLabel lblNewLabel_2 = new JLabel("오늘제목");
        lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 30));
        lblNewLabel_2.setBounds(25, 96, 145, 38);
        f.getContentPane().add(lblNewLabel_2);

        JTextField t2 = new JTextField();
        t2.setFont(new Font("굴림", Font.BOLD, 30));
        t2.setColumns(10);
        t2.setBackground(Color.GREEN);
        t2.setBounds(197, 96, 267, 38);
        f.getContentPane().add(t2);

        JLabel lblNewLabel_2_1 = new JLabel("오늘내용");
        lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 30));
        lblNewLabel_2_1.setBounds(25, 168, 145, 38);
        f.getContentPane().add(lblNewLabel_2_1);

        JTextArea t3 = new JTextArea();
        t3.setFont(new Font("Monospaced", Font.BOLD, 30));
        t3.setBackground(Color.GREEN);
        t3.setBounds(197, 180, 267, 134);
        f.getContentPane().add(t3);

        JButton btnSave = new JButton("파일에 일기 저장");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = t1.getText();
                String s2 = t2.getText();
                String s3 = t3.getText();
                FileWriter file = null;
                // 컴파일 에러, 개발자가 exception 을 해줘야 함
                try {
                    file = new FileWriter(s1 + ".txt");

                    file.write(s1 + "\n"); //\n이면 엔터를 넣어준다.
                    file.write(s2 + "\n");
                    file.write(s3 + "\n");
                } catch (Exception ex) {
                    // e.printStackTrace();
                    System.out.println("파일 저장 중 에러 발생");
                } finally {
                    if(file != null) {
                        try {
                            file.close();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
        btnSave.setBackground(Color.MAGENTA);
        btnSave.setFont(new Font("굴림", Font.BOLD, 30));
        btnSave.setBounds(44, 337, 387, 70);
        f.getContentPane().add(btnSave);

        f.setVisible(true);
    }
}
