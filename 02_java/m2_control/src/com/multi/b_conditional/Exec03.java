package com.multi.b_conditional;

import javax.swing.*;

public class Exec03 {
    public static void main(String[] args) {
        int ok = 0;
        int no = 0;
        int etc = 0;

        for (int i = 0; i < 5; i++) {
            String data = JOptionPane.showInputDialog("ok)긍정, no)부정, etc)기타");

            if (data.equals("ok") || data.equals("긍정")) {
                ok++;
            } else if (data.equals("no") || data.equals("부정")) {
                no++;
            } else {
                etc++;
            }

        }
        System.out.println("입력 받은 ok는 총 " + ok + "회 입니다.");
        System.out.println("입력 받은 no는 총 " + no + "회 입니다.");
        System.out.println("입력 받은 etc는 총 " + etc + "회 입니다.");

    }
}
