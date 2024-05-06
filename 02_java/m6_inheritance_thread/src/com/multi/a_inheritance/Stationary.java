package com.multi.a_inheritance;

public class Stationary {
    private int price;
    private String company;

    public Stationary(int price, String company) {
        this.price = price;
        this.company = company;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void buy() {
        System.out.println("이 물건의 가격은 " + price + "원 입니다.");
    }

    @Override
    public String toString() {
        return "Stationary{" +
                "price=" + price +
                ", company='" + company + '\'' +
                '}';
    }
}
