package com.multi.b_app01;

import java.util.Random;

public class Exec02 {
    public static void main(String[] args) {
        // 1. 공간 6개 만들기
        int[] arrInt = new int[6];

        // 2. Random()
        Random r = new Random();

        // 3. 공간만큼 돌면서 랜덤한 값을 그 공간에 담아준다.
        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = r.nextInt(45) + 1;
        }

        // 4. 출력
        for(int i : arrInt) {
            System.out.println(i + " ");
        }
    }
}
