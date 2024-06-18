package com.multi.algo.b_app;

import java.util.Arrays;
import java.util.Random;

public class C_DiffArray {
    public static void main(String[] args) {
        Random r = new Random();

        int[] num1 = new int[1000];
        int[] num2 = new int[1000];

        for (int i = 0; i < num1.length; i++) {
            num1[i] = r.nextInt(1000); //0-999
            num2[i] = r.nextInt(1000); //0-999
        }
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));

        System.out.println(num1 + " " + num2);
        System.out.println(num1 == num2); //참조형변수를 ==(비교연산자)로 비교하면 주소!비교!

        System.out.println(Arrays.equals(num1, num2));

        int[] num3 = {1, 2};
        int[] num4 = {1, 2};
        System.out.println(num3 == num4); //주소 비교!
        System.out.println(Arrays.equals(num3, num4)); //배열의 값이 동일한지 비교!

        int[] n1 = {100, 20, 30};
//        int[] n2 = n1;  // 얕은 복사
        int[] n2 = n1.clone();  // 깊은 복사

        n2[0] = 90;
        System.out.println(Arrays.toString(n1));
        System.out.println(Arrays.toString(n2));
    }
}
