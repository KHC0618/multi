package com.multi.a_classmake;

public class Dog {
    // 색, 종
    private String color;
    private String field;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void wagTail() {
        System.out.println("강아지가 꼬리를 흔든다.");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "color='" + color + '\'' +
                ", field='" + field + '\'' +
                '}';
    }

    public void bark() {
        System.out.println("강아지가 짖는다.");
    }

//    @Override // 재정의
//    public String toString() {
//        return "color : " + color + ", field : " + field;
//    }
}
