package com.multi.algo.a_collection;

import java.util.*;

public class A_Collection01 {
    public static void main(String[] args) {
        // 1. 중복 허용 X,
        HashSet<String> team = new HashSet<>();
        team.add("디자이너");
        team.add("프로그래머");
        team.add("프로그래머");
        team.add("DB관리자");
        System.out.println(team);

        // 2. 냉장고(순서 + First Input First Output, FIFO, 선입선출)
        // Queue구조, ==> LinkedList
        LinkedList<String> refrigerator = new LinkedList<>();
        refrigerator.add("상한 우유");
        refrigerator.add("싱싱 우유");
        System.out.println(refrigerator);
        refrigerator.pop();
        System.out.println(refrigerator);

        List<String> ski = new ArrayList<>();
        ski.add("박스키");
        ski.add("송스키");
        ski.add("김스키");
        ski.add("정스키");
        System.out.println(ski);
        ski.remove(1);
        System.out.println(ski);

        Map<Integer, String> phone = new HashMap<>();
        phone.put(1, "엄마");
        phone.put(2, "아빠");
        phone.put(3, "친구");
        phone.put(4, "동생");
        System.out.println(phone.get(2));
        phone.getOrDefault(5, "asdf");
        System.out.println(phone.getOrDefault(3, "asdf"));
    }
}
