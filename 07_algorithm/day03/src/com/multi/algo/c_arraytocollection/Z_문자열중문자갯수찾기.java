package com.multi.algo.c_arraytocollection;

import java.util.Scanner;


///입력받은 문자열에서 특정 문자가 몇 번 나타나는지 세어 그 결과를 출력

public class Z_문자열중문자갯수찾기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] total = in.next().toUpperCase().toCharArray();//abcabc
        char find = in.next().toUpperCase().charAt(0); //c

        int count = 0;

        System.out.println(total);
        System.out.println(find);

        for (int i = 0; i < total.length; i++) {
            if (total[i] == find) {
                count++;
            }
        }


        System.out.println(count);//2
        in.close();
    }
}
