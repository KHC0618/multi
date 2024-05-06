package com.multi.practice;

public class Cafe {
    public static void main(String[] args) {
        Calculator2 cal = new Calculator2();
        int coffeeSum = cal.sum(5, 2000);
        int milkTeaSum = cal.sum(2, 3000);
        int total = cal.total(coffeeSum, milkTeaSum);
        System.out.println("커피의 가격 : " + coffeeSum);
        System.out.println("밀크티의 가격 : " + milkTeaSum);
        System.out.println("두 음료의 총 가격 : " + total);
        System.out.println("1인당 결제금액 : " + cal.div(total, 7));
    }
}
