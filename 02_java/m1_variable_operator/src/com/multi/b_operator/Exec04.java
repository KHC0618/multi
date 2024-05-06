package com.multi.b_operator;

public class Exec04 {
    public static void main(String[] args) {    // main 혹은 psvm : 자동생성 방법 2가지
        //비교연산자의 결과가 boolean(논리형!)

        // 비교연산자(==, !=, >, >=)
        // *** 비교 결과가 중요(논리형 데이터!! true/false)

        //기본형 데이터는 비교연산자를 가지고 비교 가능
        //기본형 데이터가 아니면 비교연산자를 가지고 비교 불가능

        int x = 200;
        int y = 100;
        System.out.println("일치? " + (x == y));
        System.out.println("불일치? " + (x != y));
        System.out.println("이상? " + (x >= y));
        System.out.println("초과? " + (x > y));

        String a = "이효리";
        String b = "이효리";
        String c = new String("이효리");
        // == 비교연산자는 고유한 해시코드를 비교하여 결과를 반환. (identityHashCode)
        // 리터럴로 문자열을
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);

    }
}
