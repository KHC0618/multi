package com.multi.b_operator;

public class Exec01 {
    public static void main(String[] args) {    // main 혹은 psvm : 자동생성 방법 2가지
        System.out.println(100 + 200);
        int n1 = 200;
        int n2 = 100;
        int n3 = n1 + n2;
        System.out.println(n3);

        byte n4 = (byte) 200;
        System.out.println(n4);

        byte n5 = 100;
        byte n6 = (byte) (n1 + n2);
    }
}
