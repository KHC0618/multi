package com.multi.b_classuse;

import com.multi.a_classmake.Calculator;
import com.multi.a_classmake.Dog;
import com.multi.a_classmake.Phone;
import com.multi.a_classmake.Tv;

public class MyroomProject {
    public static void main(String[] args) {
        Phone p1 = new Phone();
        p1.makeCall();
        p1.setSize(-100);

        System.out.println(p1.getSize());
//        p1.size = -100;
//        p1.speaker = "애플사";
//
//        System.out.println(p1.size);
//        System.out.println(p1.speaker);


        // 전화기 1대 추가
        Phone p2 = new Phone();
        p2.takePhoto();
        p2.setSize(150);
        System.out.println(p2.getSize());
        p2.setSpeaker("애플사");
        System.out.println(p2.getSpeaker());

        Dog dog = new Dog();
        dog.setColor("황색");
        dog.setField("진돗개");
        dog.wagTail();
        dog.bark();
        System.out.println(dog.getColor());
        System.out.println(dog.getField());

        System.out.println(dog.toString());

        Tv tv = new Tv();

        tv.setCh(12);
        tv.setVol(80);
        tv.onOff();
        tv.onOff();
        System.out.println(tv.toString());

        Calculator cal = new Calculator();
        cal.add();
    }
}
