package com.multi.b_app01;

import java.util.Random;

public class Exec03 {
    public static void main(String[] args) {
        // 1000개의 공간에 100까지의 숫자 중에 80보다 큰 값의 갯수 출력
        int[] arrInt = new int[1000];
        int count = 0;

        Random r = new Random();
        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = r.nextInt(100);
        }
        for (int i : arrInt) {
            if (i > 80) {
                count++;
            }
        }
        System.out.println("80보다 큰 값은 " + count + "개 입니다.");
    }
}
