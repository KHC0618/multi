package com.multi.algo.c_arraytocollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A_배열과컬렉션변환 {
    public static void main(String[] args) {
        int[] s = { 5, 2, 1, 9, 11, 15, 17 };

        System.out.println(Arrays.toString(s));

        Arrays.sort(s);

        System.out.println(Arrays.toString(s));

        intPrint(s);

        String[] s2 = {"aaa", "bbb", "ccc", "aaa"};

        stringPrint(s2);

        // --> List로 변형하면, 조금더 다양한 처리들을
        //     for문 사용하지않고 할 수 있음.
        // index를 변형시키는 add/remove를 제외한 다른 작업은
        // asList()이용해서 List로 변환하여 사용함.
        // add/remove되지 않는 제약이 있음. // 배열을 리스트 처럼 다루긴 하지만, 내부적으로는 배열을 가리키고 있다
        List<String> list = Arrays.asList(s2);
        System.out.println(list);

        // list.remove(1);
        System.out.println(list.contains("aaa"));

        // ccc 위치
        System.out.println(list.indexOf("ccc"));
        // aaa의 마지막 위치
        System.out.println(list.lastIndexOf("aaa"));
        // ddd 삽입, 삽입 불가
        // 2번의 내용을 ggg로 변경
        list.set(2, "ggg");
        System.out.println(list);

        // 제약이 없는 ArrayList를 다시 만들어 주면 된다.
        List<String> list3 = new ArrayList<>(Arrays.asList(s2));
        list3.add("hahaha");
        list3.remove("bbb");
        System.out.println(list3);

        System.out.println("--------------");
        // int[]은 asList() X
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int x : s) {
            list2.add(x);
        }

        // 컬렉션 정렬 사용
        System.out.println(list2);
        Collections.reverse(list2);
        System.out.println(list2);
        Collections.sort(list2);
        System.out.println(list2);

        System.out.println("--------------");
        String[] s3 = list.toArray(new String[0]);
        stringPrint(s3);

        String[] s4 = new String[list.size()];
        for (int i = 0; i < s4.length; i++) {
            s4[i] = list.get(i);
        }
        stringPrint(s4);
        PrintAll.print(s4);
    }

    public static void intPrint(int[] n) {
        System.out.println(Arrays.toString(n));
    }

    public static void stringPrint(String[] s) {
        System.out.println(Arrays.toString(s));
    }
}
