package com.multi.b_conditional;

import javax.swing.*;

public class Exec07 {
    public static void main(String[] args) {
        int target = 88;
        int no = 0;
        int count = 0;

        while (true) {
            String data = JOptionPane.showInputDialog("숫자를 입력하세요.");
            int data2 = Integer.parseInt(data);

            count++;
            if(data2 == target) {
                System.out.println("축하합니다. 정답입니다!");
                break;
            } else {
                System.out.println("정답이 아닙니다.");
                no++;
                if (data2 > target) {
                    System.out.println("너무 큽니다.");
                } else {
                    System.out.println("너무 작습니다.");
                }
            }
        }

        System.out.println("총 시도 횟수 : " + count + "회");
        System.out.println("틀린 횟수 : " + no + "회");
    }
}
