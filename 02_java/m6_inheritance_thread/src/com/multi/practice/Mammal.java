package com.multi.practice;

public class Mammal extends Animal {
    private double weight;
    private double height;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Mammal(String name, double weight, double height) {
        super(name);
        this.weight = weight;
        this.height = height;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("동시에 " + getName() + "은(는) 포유류 입니다.");
    }

    @Override
    public String toString() {
        return "Mammal{" +
                "name='" + getName() + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
