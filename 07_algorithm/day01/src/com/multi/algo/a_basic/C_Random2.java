package com.multi.algo.a_basic;

import java.util.Arrays;
import java.util.Scanner;

public class C_Random2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int[] num = new int[3];
//
//        for (int i = 0; i < num.length; i++) {
//            System.out.print(i + "번째 정수형 입력 : ");
//            num[i] = scanner.nextInt();
//            scanner.nextLine();
//        }
//        System.out.println(Arrays.toString(num));

//        double[] doubles = new double[5];   //{11.1, 22.2, 33.3, 22.2, 55.5}
        double[] doubles = {11.1, 22.2, 33.3, 22.2, 55.5};
//        for (int i = 0; i < doubles.length; i++) {
//            System.out.print(i + "번째 실수형 입력 : ");
//            doubles[i] = scanner.nextDouble();
//            scanner.nextLine();
//        }

        System.out.println(Arrays.toString(doubles));

        int count = 0;
        for (int i = 0; i < doubles.length; i++) {
            if (doubles[i] == 33.3) {
                System.out.println("33.3의 위치는 : " + (i+1) + "번째");
            }

            if (doubles[i] == 22.2) {
                count++;
            }
        }
        System.out.println("22.2의 갯수는 : " + count + "개");

    }
}
