package com.multi.a_constructor;

public class Bank {
    public static void main(String[] args) {
        Account acc1 = new Account("김희철", "정기 적금", 1000000);
        System.out.println(acc1);

        Account acc2 = new Account("김희철", "정기 적금", 1000000);
        System.out.println(acc2);

        Account acc3 = new Account("김희철", "정기 적금");
        System.out.println(acc3);

        acc3.setMoney(500000);
        System.out.println(acc3);

        Account acc4 = new Account();
        System.out.println(acc4);
    }
}
