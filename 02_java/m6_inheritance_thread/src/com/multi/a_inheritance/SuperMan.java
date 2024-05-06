package com.multi.a_inheritance;

public class SuperMan extends Man {
    private boolean isFly;

    public SuperMan(String name, int age, int power, boolean isFly) {
        super(name, age, power);
        this.isFly = isFly;
    }

    public void space() {
        System.out.println("우주를 날다");
        super.toString();   // 부모 메소드 호출 시에는 super.     내 자신의 메소드는 생략 or this.
    }

    @Override
    public void run() {
        System.out.println("안보일 정도로 빠르게 달린다.");
    }

    @Override
    public void sleep() {
        System.out.println("영웅은 잠 따위 자지 않는다네~");
    }

    @Override
    public String toString() {
        return "수퍼맨 [fly=" + isFly +
                ", power=" + getPower() +
                ", name=" + getName() +
                ", age=" + getAge() +
                "]";
    }
}
