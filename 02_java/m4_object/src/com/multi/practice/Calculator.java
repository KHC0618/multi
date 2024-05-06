package com.multi.practice;

public class Calculator {
    private int price;
    private int count1;
    private int count2;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public int getCount2() {
        return count2;
    }

    public void setCount2(int count2) {
        this.count2 = count2;
    }

    public int add(int x, int y) {
        return x + y;
    }

    public int minus(int x, int y) {
        return x - y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public double div(int x, int y) {
        return (double) x / y;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "price=" + price +
                ", count1=" + count1 +
                ", count2=" + count2 +
                '}';
    }
}
