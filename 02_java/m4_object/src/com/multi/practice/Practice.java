package com.multi.practice;

public class Practice {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        int price = 7000;
        int count1 = 5;
        int count2 = 4;
        int result = 0;

        System.out.println("오늘 온 손님의 총 합은 " + cal.add(count1, count2) + "명입니다.");
        System.out.println("손님 수 차이는 " + cal.minus(count1, count2) + "명입니다.");
        System.out.println("오전 결제금액은 " + cal.mul(price, count1) + "원입니다.");
        System.out.println("오후 결제금액은 " + cal.mul(price, count2) + "원입니다.");
        result = cal.add(cal.mul(price, count1), cal.mul(price, count2));
        System.out.println("오늘 하루 총 결제금액은 " + result + "원입니다.");
        System.out.println("1인당 결제금액은 " + (int) cal.div(result, cal.add(count1, count2)) + "원입니다.");
    }
}
