package com.multi.algo.b_app;

import java.util.Arrays;
import java.util.Random;

public class A_MinArray { // 배열의 최소값 구하기
    public static void main(String[] args) {
//        int[] s = {90, 80, 20, 60, 70};
//        System.out.println(Arrays.stream(s).min());
//
//
//        int min = s[0];
//        for (int i = 1; i < s.length; i++) {
//            if(s[i] < min) {
//                min = s[i];
//            }
//        }
//        System.out.println(min);

        // 랜덤한 값 1000개를 발생시켜 배열에 넣어
        // 1. 최소값을 구하고, 순서도 수정!//0~999범위값!
        // 2. 최대값을 구해보세요.
        // 3. 최대값의 개수는??

        Random random = new Random();
        int[] ranInt = new int[1000];

        for(int i = 0; i < ranInt.length; i++) {
            ranInt[i] = random.nextInt(999) + 1;
        }
        int min = ranInt[0];
        for(int i = 1; i < ranInt.length; i++) {
            if(ranInt[i] < min) {
                min = ranInt[i];
            }
        }
        Arrays.sort(ranInt);
        System.out.println("최소값 : " + min);

        int max = ranInt[0];
        for(int i = 1; i < ranInt.length; i++) {
            if(ranInt[i] > max) {
                max = ranInt[i];
            }
        }
        System.out.println("최대값 : " + max);

        int count = 0;
        for(int i = 0; i < ranInt.length; i++) {
            if(ranInt[i] == max) {
                count++;
            }
        }
        System.out.println("최대값의 갯수 : " + count + "개");

        Arrays.sort(ranInt);
        System.out.println(Arrays.toString(ranInt));

    }
}
