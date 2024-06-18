package com.multi.algo.a_basic;

import java.util.Arrays;
import java.util.Random;

public class B_Random1 { // 랜덤한 값 배열에 넣기
    public static void main(String[] args) {
        Random random = new Random();
        int[] ranInt = new int[10];

        for(int i = 0; i < ranInt.length; i++) {
            ranInt[i] = random.nextInt(10);
        }

        System.out.println(Arrays.toString(ranInt));
    }
}
