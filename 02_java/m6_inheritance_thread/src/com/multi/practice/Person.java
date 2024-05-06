package com.multi.practice;

public class Person extends Mammal {

    public Person(String name, double weight, double height) {
        super(name, weight, height);
    }

    public void makeSound() {
        System.out.println("사람은 소리를 안 냅니다.");
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("동시에 " + getName() + "은(는) 사람 입니다.");
    }
}
