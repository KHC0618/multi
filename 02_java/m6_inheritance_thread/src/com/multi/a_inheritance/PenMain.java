package com.multi.a_inheritance;

public class PenMain {
    public static void main(String[] args) {
        Pen pen = new Pen(1000, "모나미", 0.3);
        System.out.println(pen);
        pen.type();
        System.out.println("이 볼펜의 두께는 " + pen.getThink() + " mm 입니다.");
        pen.buy();
        pen.write();
    }
}
