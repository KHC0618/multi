package com.multi.a_sequential;

import javax.swing.*;

public class Exec02 {
    public static void main(String[] args) {
        String hour = JOptionPane.showInputDialog("지금 몇 시 인가요?");
        System.out.println(hour);

        JOptionPane.showMessageDialog(null, hour + "시 입니다.");

        if(hour.isEmpty()) {
            System.out.println("시간을 숫자 0 ~ 24로 입력해주세요.");
            return;
        }
        int hour2 = Integer.parseInt(hour);
        System.out.println(hour2);
        if (hour2 < 16) { //조건에는 비교연산자를 쓰고, 비교연산자의 결과는 논리!
            //true
            JOptionPane.showMessageDialog(null, "아직 집에 갈 시간이 멀었군요.");
        } else { //false
            JOptionPane.showMessageDialog(null, "집에 갈 시간이 얼마 안남았군요.");
        } //묶어주는 의미(포함)
    }
}
