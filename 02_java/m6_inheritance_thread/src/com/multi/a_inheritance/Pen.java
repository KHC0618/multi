package com.multi.a_inheritance;

public class Pen extends Stationary {
    private final String TYPE = "볼펜";
    private double think;

    public Pen(int price, String company, double think) {
        super(price, company);
        this.think = think;
    }

    public double getThink() {
        return think;
    }

    public void setThink(int think) {
        this.think = think;
    }

    public void write() {
        System.out.println("볼펜으로 글을 썼습니다.");
    }

    public void type() {
        System.out.println("이 물건의 종류는 " + TYPE + "입니다.");
    }

    @Override
    public String toString() {
        return "Pen{" +
                "think=" + think +
                ", price=" + getPrice() +
                ", company='" + getCompany() + '\'' +
                '}';
    }
}
