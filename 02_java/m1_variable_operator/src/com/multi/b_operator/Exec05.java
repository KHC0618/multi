package com.multi.b_operator;

public class Exec05 {
    public static void main(String[] args) {

        int id = 1111;
        int pw = 2222;

        int loginId = 1111;
        int loginPw = 2000;

        if (id == loginId && pw == loginPw) {
            System.out.println("로그인 완료.");
        } else {
            System.out.println("로그인 실패.");
        }

        int num = 10;
        System.out.println("&& 연산 전의 num 값 : " + num);

        boolean result1 = (num < 5) && (++num > 0);

        System.out.println("result1 : " + result1);
        System.out.println("&& 연산후의 num값 : " + num);
    }
}
