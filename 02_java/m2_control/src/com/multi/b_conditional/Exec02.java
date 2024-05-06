package com.multi.b_conditional;

public class Exec02 {
    public static void main(String[] args) {
        String data = "OK";

        if (data.equals("OK")) {
            System.out.println("긍정");
        } else if (data.equals("NO")) {
            System.out.println("부정");
        } else {
            System.out.println("잘못 된 입력입니다.");
        }
    }
}
