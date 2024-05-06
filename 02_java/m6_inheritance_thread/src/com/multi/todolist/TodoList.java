package com.multi.todolist;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TodoList {

    static ArrayList<String> list = new ArrayList<>();
    static JFrame f = new JFrame();

    public TodoList(String text) {

        f.setSize(340, 290);

        switch (text) {
            case "조회":

                f.setTitle("오늘의 할 일 목록");
                f.setLayout(null);
                Font font = new Font("굴림", Font.BOLD, 15);
                JLabel label = new JLabel();

                for (int i = 0; i < list.size(); i++) {
                    label.setFont(font);
                    label.setBounds(10, 10 + (i * 30), 300, 20);
                    label.setText((i + 1) + ". " + list.get(i));
                    f.add(label);
                }
                f.setVisible(true);

                break;
            case "추가":

                String todoInput = JOptionPane.showInputDialog("추가할 일을 적어주세요.");
                list.add(todoInput);

                break;
            case "수정":

                while (true) {
                    int num = Integer.parseInt(JOptionPane.showInputDialog("수정할 일의 번호를 입력하세요."));
                    if (num > 0 && num <= list.size()) {
                        String todoRewrite = JOptionPane.showInputDialog("수정할 일을 입력해주세요.");
                        list.set(num - 1, todoRewrite);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "해당 번호는 비어있습니다. 다시 입력해주세요.");
                    }
                }

            case "삭제":
                while (true) {
                    int num = Integer.parseInt(JOptionPane.showInputDialog("삭제할 일의 번호를 입력하세요."));
                    if (num > 0 && num <= list.size()) {
                        list.remove(num - 1);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "해당 번호는 비어있습니다. 다시 입력해주세요.");
                    }
                }
            default:
                JOptionPane.showMessageDialog(null, "잘못된 접근입니다.");
                break;
        }
    }

}
