package com.multi.practice;

import javax.swing.*;

public class Exam01 {
    public static void main(String[] args) {
        // Exam01
        String width = JOptionPane.showInputDialog("가로 길이");
        String height = JOptionPane.showInputDialog("세로 길이");

        int widthInt = Integer.parseInt(width);
        int heightInt = Integer.parseInt(height);

        System.out.println("사각형의 면적는 : " + widthInt * heightInt);

        // Exam02
        String height2 = JOptionPane.showInputDialog("키");

        Double heightDouble = Double.parseDouble(height2);
        Double weight = (heightDouble - 100) * 0.9;

        System.out.println("적정 몸무게는 : " + weight);

        // Exam03
        String tel = JOptionPane.showInputDialog("통신사 입력");
        String phone = JOptionPane.showInputDialog("전화번호 입력");
        String name = JOptionPane.showInputDialog("가입자 이름 입력");

        String sumString = name + "님은 " + tel + "에 " + phone;

        JOptionPane.showMessageDialog(null, sumString + "로 가입되셨습니다.");

        // 89 page
        String name2 = "홍길동";
        int age = 200;
        String address = "홍천";
        double weight2 = 88.8;
        boolean programmer = true;
        char color = 'y';

        System.out.println("친구의 이름은 " + name2 + "이고 나이는 " + age + "세이다.");
        System.out.println(address + "에 살고 있고 몸무게는 " + weight2 + "킬로이다.");
        System.out.println("좋아하는 색은 " + color + "가 들어가는 색이고, 프로그래머 여부는 " + programmer + "이다.");
    }
}
