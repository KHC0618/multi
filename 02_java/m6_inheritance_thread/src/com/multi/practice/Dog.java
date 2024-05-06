package com.multi.practice;

public class Dog extends Mammal {
    private String size;

    public Dog(String name, double weight, double height, String size) {
        super(name, weight, height);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("동시에 " + getName() + "은(는) 개 입니다.");
        System.out.println(getName() + "의 크기는 " + size + "입니다.");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + getName() + '\'' +
                ", weight=" + getHeight() +
                ", height=" + getWeight() +
                ", size='" + size + '\'' +
                '}';
    }
}
