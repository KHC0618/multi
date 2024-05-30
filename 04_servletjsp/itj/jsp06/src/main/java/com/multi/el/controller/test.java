package com.multi.el.controller;

public class test {
    private interface Dog {
        void name();
    }

    public class Poodle implements Dog {
        public void name() {
            System.out.println("푸들");
        }
    }

    public static void main(String[] args) {
        test test = new test();
        Dog poodle = test.new Poodle();
        poodle.name();
    }
}
