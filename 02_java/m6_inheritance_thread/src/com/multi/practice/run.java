package com.multi.practice;

public class run {

    public static void main(String[] args) {
        Person person = new Person("홍길동", 87.0, 188.2);
        Dog dog = new Dog("바둑이", 25.3, 120.7, "대형");
        Birds bird = new Birds("벌새", "소형");

        System.out.println(person);
        person.showInfo();
        person.makeSound();
        System.out.println();

        System.out.println(dog);
        dog.showInfo();
        dog.makeSound();
        System.out.println();

        System.out.println(bird);
        bird.showInfo();
        bird.makeSound();
    }
}
