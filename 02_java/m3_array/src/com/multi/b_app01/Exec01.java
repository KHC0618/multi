package com.multi.b_app01;

import javax.swing.*;

public class Exec01 {
    public static void main(String[] args) {
        int[] jumsu = new int[5];
        int sum = 0;
        for (int i = 0; i < jumsu.length; i++) {
            String data = JOptionPane.showInputDialog("점수 입력");

            jumsu[i] = Integer.parseInt(data);

            System.out.println(i + " --> " + jumsu[i]);
        }
        for (int i : jumsu) {
            sum += i;
        }
        System.out.println("점수의 총합은 : " + sum);
    }
}
