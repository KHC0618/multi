package com.multi.algo.c_etc;

import java.util.ArrayList;
import java.util.Collections;

public class A_Collections주요함수 {

	public static void main(String[] args) {
		int[] s = { 3, 3, 6, 7, 8, 11, 34, 90, 102 };
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < s.length; i++) {
			list.add(s[i]);
		}
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(Collections.min(list));
		System.out.println(Collections.max(list));
		Collections.sort(list);
		System.out.println(list.get(2));
		System.out.println(Collections.frequency(list, 3));
		System.out.println(!list.contains(6));
		System.out.println(list.indexOf(6));
		Collections.reverse(list); //역순!
		System.out.println(list);
		list.clear();
	}

}

        
//        // 리스트의 모든 요소 출력
//        System.out.println(list);
//        // 리스트의 크기(요소 수) 출력
//        System.out.println(list.size());
//        // 리스트 내 최소값 출력
//        System.out.println(Collections.min(list));
//        // 리스트 내 최대값 출력
//        System.out.println(Collections.max(list));
//        // 리스트를 오름차순으로 정렬
//        Collections.sort(list);
//        // 정렬된 리스트에서 인덱스 2의 요소 (세 번째 요소) 출력
//        System.out.println(list.get(2));
//        // 리스트 내에서 값 3의 빈도수(등장 횟수) 출력
//        System.out.println(Collections.frequency(list, 3));
//        // 리스트 내에 값 6이 존재하지 않는지 확인 (존재하므로 false 반환)
//        System.out.println(!list.contains(6));
//        // 값 6의 리스트 내에서의 인덱스 출력
//        System.out.println(list.indexOf(6));
//        // 리스트를 역순으로 정렬
//        Collections.reverse(list);
//        // 역순으로 정렬된 리스트 출력
//        System.out.println(list);
//        // 리스트의 모든 요소 제거 (리스트 비우기)
//        list.clear();


