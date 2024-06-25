package com.multi.algo.c_aaa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A_스택과큐정리문제 {
    public static void main(String[] args) {
        String[] food = {"apple", "apple", "apple", "banana", "banana", "melon", "melon", "berry"};
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < food.length; i++) {
            list.add(food[i]);
            if (list.get(i).equals(food[i])) {
                set.add(food[i]);
            }
        }

        System.out.println(set);
    }
}
