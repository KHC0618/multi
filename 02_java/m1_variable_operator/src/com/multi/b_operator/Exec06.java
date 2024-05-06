package com.multi.b_operator;

import javax.swing.*;

public class Exec06 {
    public static void main(String[] args) {
        String id = "root";
        String pw = "pass";

        String id2 = JOptionPane.showInputDialog("로그인 ID");
        String pw2 = JOptionPane.showInputDialog("로그인 PW");

        if (id.equals(id2) && pw.equals(pw2)) {
            System.out.println("로그인 성공.");
        } else {
            System.out.println("로그인 실패.");
        }
    }
}
