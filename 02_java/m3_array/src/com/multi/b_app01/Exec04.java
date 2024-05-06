package com.multi.b_app01;

public class Exec04 {
    public static void main(String[] args) {
        // 가족 : 아버지 어머니  형   나    동생
        // 나이 :  100   90    50   20    10
        // 키   : 177.5 160.2 170 160.3 140.2

        String[] family = {"아버지", "어머니", "형", "나", "동생"};
        int[] age = {100, 90, 50, 20, 10};
        double[] height = {177.5, 160.2, 170, 160.3, 140.2};
        for (int i = 0; i < family.length; i++) {
            System.out.println(family[i] + "\t" + age[i] + "\t" + height[i]);
        }
    }
}
