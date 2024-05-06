package com.multi.todolist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TodoMain {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(340, 290);
        f.setTitle("오늘의 할 일");
        f.setLayout(null);

        Font font = new Font("굴림", Font.BOLD, 30);

        JButton check = new JButton("오늘의 할 일 조회");
        JButton addList = new JButton("오늘의 할 일 추가");
        JButton rewrite = new JButton("오늘의 할 일 수정");
        JButton removeList = new JButton("오늘의 할 일 삭제");

        ArrayList<JButton> btnList = new ArrayList<>();

        btnList.add(check);
        btnList.add(addList);
        btnList.add(rewrite);
        btnList.add(removeList);

        for (int i = 0; i < btnList.size(); i++) {
            btnList.get(i).setFont(font);
            btnList.get(i).setBounds(10, 10 + (i * 60), 300, 50);
            f.add(btnList.get(i));
            btnList.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = e.getActionCommand();
                    String subText = text.substring(text.length() - 2);
                    TodoList todoList = new TodoList(subText);
                }
            });
        }

        f.setVisible(true);
    }
}
