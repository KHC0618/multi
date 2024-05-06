package com.multi.b_collection;

import java.util.HashSet;
import java.util.Random;

public class Exec02 {
    public static void main(String[] args) {
        Random r = new Random();
        HashSet lotto = new HashSet();
        for (int i = 0; i < 6; i++) {
            int num = r.nextInt(45) + 1;
            System.out.println(num);
            if (lotto.contains(num)) {
                i--;
            } else {
                lotto.add(num);
            }
        }
        System.out.println(lotto);
    }
}
