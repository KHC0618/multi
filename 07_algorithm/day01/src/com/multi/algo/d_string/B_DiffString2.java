package com.multi.algo.d_string;

import java.util.Arrays;

public class B_DiffString2 {
    public static void main(String[] args) {
        String all = "국어, 영어, 수학, 컴퓨터";

        String[] all2 = all.split(",");

        System.out.println(all2.length);

        System.out.println(all2[1]);

        for (int i = 0; i < all2.length; i++) {
            if (all2[i].contains(" ")) {
                all2[i] = all2[i].trim();
            }
        }

        System.out.println(all2[1]);
        System.out.println("과목 수 >> " + all2.length);

        for(int i =0; i < all2.length; i++) {
            if(all2[i].equals("컴퓨터")) {
                System.out.println(i);
            }
        }

        int count = 0;

        for(int i = 0; i < all2.length; i++) {
            if (all2[i].length() < 3) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println("------------");

        System.out.println(Arrays.asList(all2).indexOf("컴퓨터"));
    }
}
