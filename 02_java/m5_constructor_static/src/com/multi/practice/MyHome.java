package com.multi.practice;

public class MyHome {
    public static void main(String[] args) {
        Daughter d1 = new Daughter("홍길순", "여");
        Daughter d2 = new Daughter("홍길진", "여");
        System.out.println(d1);
        System.out.println(d2);
        System.out.println("딸의 수는 " + Daughter.count + "명");
        System.out.println("현재 남은 아빠 지갑에 들어있는 돈 : " + Daughter.wallet + "원");
    }
}
