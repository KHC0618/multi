package com.multi.algo.b_app;

import java.util.Arrays;
import java.util.Random;

public class B_SortMinMaxArray {
    public static void main(String[] args) {
        // 배열 정렬 후 최대 최소 구하기
        Random random = new Random();
        int[] ranInt = new int[1000];

        for (int i = 0; i < ranInt.length; i++) {
            ranInt[i] = random.nextInt(999) + 1;
        }
        System.out.println(Arrays.toString(ranInt));

        Arrays.sort(ranInt);
        // 정렬 후
        System.out.println(Arrays.toString(ranInt));

        // 최소값
        System.out.println("최소값 : " + ranInt[0]);

        // 최대값
        System.out.println("최대값 : " + ranInt[ranInt.length - 1]);
    }
}
