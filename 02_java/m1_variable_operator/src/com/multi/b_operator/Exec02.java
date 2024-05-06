package com.multi.b_operator;

import javax.swing.*;

public class Exec02 {
    public static void main(String[] args) {    // main 혹은 psvm : 자동생성 방법 2가지
        // 입력 2개 받아서
        // +, -, *, /, %
        String num1 = JOptionPane.showInputDialog("첫 번째 숫자 입력");
        String num2 = JOptionPane.showInputDialog("두 번째 숫자 입력");

        int numInt1 = Integer.parseInt(num1);
        int numInt2 = Integer.parseInt(num2);

        System.out.println(numInt1 + numInt2);
        System.out.println(numInt1 - numInt2);
        System.out.println(numInt1 * numInt2);
        System.out.println(numInt1 / numInt2);
        System.out.println(numInt1 % numInt2);

        // n2에 담기는 수 포함해서 0부터 출력해보기
        for (int i = 0; i <= numInt2; i++) {
            System.out.println("출력 : " + i);
        }

        //1. 데이터: 입력
        String p1 = JOptionPane.showInputDialog("시작값");
        String p2 = JOptionPane.showInputDialog("종료값");

        int intP1 = Integer.parseInt(p1);
        int intP2 = Integer.parseInt(p2);

        //1. 데이터: 입력
        String n3 = JOptionPane.showInputDialog("반복할 숫자");
        String n4 = JOptionPane.showInputDialog("반복할 문자");

        for (int i = intP1; i <= intP2; i++) {
            System.out.println("반복할 숫자 : " + n3 + ", 반복할 문자 : " + n4);
        }

    }
}
