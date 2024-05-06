package com.multi.b_operator;

public class Exec03 {
    public static void main(String[] args) {    // main 혹은 psvm : 자동생성 방법 2가지

        int x = 200;
        int y = 100;

        //자바에서는 int끼리의 계산은 무조건 int!
        int sum = x + y;
        System.out.println("두 수의 합은 : " + sum);

        double div = (double) y / x;
        System.out.println("두 수의 나눗셈은 : " + div);
        // 자바에서는 하나라도 double이면 무조건 double!   -> 더 큰 자료형이면
        // 하나만 정수를 실수로 강제로 변환해서 계산 시 사용할 수 있다.
        // 강제로 타입을 바꾸는 것: 타입변환(형변환)

        double div1 = (double) (y / x);
        System.out.println("두 수의 나눗셈은 : " + div1);
    }
}
