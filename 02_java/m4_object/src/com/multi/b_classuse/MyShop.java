package com.multi.b_classuse;

import com.multi.a_classmake.Calculator2;

public class MyShop {
    public static void main(String[] args) {
        Calculator2 cal = new Calculator2();

        double result1 = cal.add(100, 30.1);
        double result2 = cal.add(100.1, 30);
        double result3 = cal.add(100.1, 30.1);

        System.out.println(cal.add(100, 200));
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        System.out.println("곱하기는 " + cal.mul(10, 20));

        System.out.println("빼기는 " + cal.minus(50, 20));

        System.out.println("나누기는 " + cal.div(30, 20));
    }
}
