package com.multi.practice;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println(name + "이(가) 소리를 냅니다.");
    }

    public void showInfo() {
        System.out.println(name + "은(는) 동물 입니다.");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
