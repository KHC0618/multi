package com.multi.b_operator;

public class Exec07 {
    public static void main(String[] args) {
        int hot = 25;
        String food = (hot > 30) ? "아이스크림" : "아이스 아메리카노";

        System.out.println(food);

        if (hot > 30) {
            System.out.println("아이스크림");
        } else if (hot > 10) {
            System.out.println("아이스 아메리카노");
        } else {
            System.out.println("따뜻한 아메리카노");
        }
    }
}
