package com.multi.algo.d_string;

public class B_DiffString {
    public static void main(String[] args) {
        String s = "정길동";
        String s2 = "정길동";

        System.out.println(s);
        System.out.println(s2);
        System.out.println(s.equals(s2));
        System.out.println(s == s2);

        s = "김길동";
        System.out.println(s.equals(s2));
        System.out.println(s == s2);

        StringBuilder builder = new StringBuilder();

        builder.append("송길동");
        System.out.println(builder);
    }
}
