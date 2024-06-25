package com.multi.algo.b_nonlinear;

import java.util.*;

public class B_Set반복자이터레이터2 {

	public static void main(String[] args) {
		//일주일간 받았던 용돈(월~일)
		//1000, 2000, 3000, 2000, 4000, 2000, 3000
		int[] list = { 1000, 2000, 3000, 2000, 4000, 2000, 3000 };

		//일주일간 받았던 용돈 중에서 
		//얼마씩 받았는지 하나씩 전체 프린트
		//1000, 2000, 3000, 4000
		Set<Integer> set = new HashSet<>();
		for (int i : list) {
			set.add(i);
		}
		int[] list2 = new int[set.size()];
		Iterator<Integer> iterator = set.iterator();
		for (int i = 0; i < set.size(); i++) {
			list2[i] = iterator.next();
		}
		Arrays.sort(list2);
		System.out.println(Arrays.toString(list2));
	}
}
