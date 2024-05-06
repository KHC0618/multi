package com.multi.b_conditional;

public class Exec01 {
    public static void main(String[] args) {
        int jumsu = 88;
        String result = "";

        if(jumsu >= 90) {
            result = "A학점";
        } else if (jumsu >= 85) {
            result = "B+학점";
        } else if (jumsu >= 80) {
            result = "B학점";
        } else {
            result = "C학점";
        }

        System.out.println("당신의 점수는 " + result + "입니다.");
    }
}
