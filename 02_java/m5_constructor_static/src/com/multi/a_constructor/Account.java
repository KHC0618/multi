package com.multi.a_constructor;

public class Account {
    private String name;    // 이름
    private String field;   // 계좌 종류
    private int money;      // 금액

    public Account() {

    }

    public Account(String name, String field) {
        this.name = name;
        this.field = field;
    }

    public Account(String name, String field, int money) {
//        this.name = name;
//        this.field = field;
        this(name, field);
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", field='" + field + '\'' +
                ", money=" + money +
                '}';
    }
}
