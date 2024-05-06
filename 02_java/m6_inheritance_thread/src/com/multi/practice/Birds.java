package com.multi.practice;

public class Birds extends Animal {
    private String size;

    public Birds(String name, String size) {
        super(name);
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
        System.out.println("동시에 " + getName() + "은(는) 조류 입니다.");
        System.out.println(getName() + "의 크기는 " + size + "입니다.");
    }

    @Override
    public String toString() {
        return "Birds{" +
                "name='" + getName() + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
