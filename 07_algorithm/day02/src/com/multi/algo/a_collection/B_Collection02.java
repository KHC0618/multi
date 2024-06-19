package com.multi.algo.a_collection;

import java.util.*;

public class B_Collection02 {
    public static void main(String[] args) {
        Set<String> travel = new HashSet<>();
        travel.add("일본");
        travel.add("미국");
        travel.add("베트남");
        travel.add("이탈리아");
        travel.add("독일");
        System.out.println(travel);

        Map<String, String> home = new HashMap<>();
        home.put("안방", "TV");
        home.put("거실", "쇼파");
        home.put("부엌", "냉장고");
        home.put("현관", "신발");
        System.out.println(home);
        System.out.println("현관에는 무엇이 있나요? >> " + home.get("현관"));
        home.put("거실", "책상");
        System.out.println(home);

        List<String> todoList = new ArrayList<>();
        todoList.add("기상");
        todoList.add("씻기");
        todoList.add("수업");
        todoList.add("과제");
        todoList.add("밥먹기");
        System.out.println(todoList);
        System.out.println("첫 번째 할 일 : " + todoList.get(0));
        System.out.println("마지막 할 일 : " + todoList.get(todoList.size() - 1));
        todoList.set(1, "청소");
        System.out.println(todoList);
    }
}
