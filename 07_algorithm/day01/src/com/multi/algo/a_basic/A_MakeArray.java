package com.multi.algo.a_basic;

import java.util.Arrays;

public class A_MakeArray {
    public static void main(String[] args) {
        // 1. 이미 값을 알고 있는 경우
        int[] ages = { 60, 50, 30, 20, 10 };

        System.out.println(ages);

        for(int i = 0; i < ages.length; i++) {
            System.out.print(ages[i] + " ");
        }
        System.out.println();

        for (int x : ages) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Arrays.toString
        System.out.println(Arrays.toString(ages));

        // 2. 값을 모르는 경우
        double[] weight = new double[5];

        weight[0] = 30.2;
        weight[1] = 42.6;
        weight[2] = 64.1;
        weight[3] = 53.9;
        weight[4] = 83.8;

    }

}
