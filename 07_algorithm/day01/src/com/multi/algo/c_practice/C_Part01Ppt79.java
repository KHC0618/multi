package com.multi.algo.c_practice;

import java.util.Arrays;
import java.util.Scanner;

public class C_Part01Ppt79 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("전화번호 입력 >> ");
        String tel = scanner.nextLine();

        String[] telList = tel.replace(" ", "").split("-");

        String telCo = "";

        if (telList[0].equals("011")) {
            telCo = "SK";
        } else if (telList[0].equals("019")) {
            telCo = "LG";
        } else {
            telCo = "Apple";
        }
        System.out.println(telCo);

        if (telList[1].length() < 4) {
            System.out.println("올드폰");
        } else {
            System.out.println("최신폰");
        }

        int sum = 0;
        for (int i = 0; i < telList.length; i++) {
            sum += telList[i].length();
        }

        if (sum < 10) {
            System.out.println("유효하지 않은 전화번호");
        } else {
            System.out.println("유효한 전화번호");
        }

        System.out.println("--------------------------");

        String s = " '휴지', '블루볼펜', '지우개' +=- ";
        String[] sList = s.replace(" ", "")
                          .replace("'", "")
                          .replace("+=-", "")
                          .split(",");
        System.out.println(Arrays.toString(sList));

        String s1 = sList[1];
        if(s1.startsWith("블루")) {
            System.out.println("파란볼펜이군요!");
        } else {
            System.out.println("빨간볼펜이군요!");
        }

        int sLen = sList[0].length();
        String minS = sList[0];
        for (int i = 1; i < sList.length; i++) {
            if(sLen > sList[i].length()) {
                sLen = sList[i].length();
                minS = sList[i];
            }
        }
        System.out.println("가장 짧은 문자열 길이를 가지는 것은 : " + minS);

        int[] sLenList = new int[sList.length];
        int sumLen = 0;
        for(int i = 0; i < sLenList.length; i++) {
            sLenList[i] = sList[i].length();
        }
        for (int i = 0; i <sLenList.length; i++) {
            sumLen += sLenList[i];
        }
        System.out.println("단어들의 길이의 합은 : " + sumLen);
    }
}
