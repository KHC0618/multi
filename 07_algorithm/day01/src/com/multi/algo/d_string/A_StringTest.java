package com.multi.algo.d_string;

import java.util.Arrays;

public class A_StringTest {
    public static void main(String[] args) {
        String s5 = "[ 10, 20, 30, 40, 50 ]";
        System.out.println(s5);
        // 1. [] 제거, 공백 제거
        s5 = s5.replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        // 2. split을 활용해서 자르고
        String[] num = s5.split(",");
        // 3. 출력 10, 20, 30 출력
        for(int i = 0; i < 3; i++) {
            System.out.println(num[i]);
        }
        System.out.println(Arrays.toString(num)); // 전체 출력

        int sum = 0;
        for(String x : num) {
            int x2 = Integer.parseInt(x);
            sum = sum + x2;
        }
        System.out.println(sum);
    }
}
