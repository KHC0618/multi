package com.multi.a_inheritance;

import java.util.ArrayList;

public class Me {
    public static void main(String[] args) {
        ArrayList<Object> arrL = new ArrayList<>();

        arrL.add("홍길동");
        arrL.add(100);
        arrL.add(0.7);
        arrL.add(true);
        arrL.add("남");

        System.out.println("나의 이름은 " + arrL.get(0) + "입니다.");
        System.out.println("나의 내년 나이는 " + ((int) arrL.get(1) + 1) + "세입니다.");
        System.out.println("나의 시력이 조금 더 좋아지면 " + String.format("%.1f", ((double) arrL.get(2) + 0.2)) + "가 됩니다.");
        if ((boolean) arrL.get(3)) {
            System.out.println("나는 아침을 먹었습니다.");
        } else {
            System.out.println("나는 아침을 안먹었습니다.");
        }
        System.out.println("나는 " + arrL.get(4) + "입니다.");
    }
}
