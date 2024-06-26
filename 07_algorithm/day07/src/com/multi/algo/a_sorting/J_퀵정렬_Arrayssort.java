
package com.multi.algo.a_sorting;

import java.util.Arrays;

//Arrays.sort에 의한 정렬(퀵 정렬) - 시험볼때 Arrays.sort 사용하면됨
class J_퀵정렬_Arrayssort {
	public static void main(String[] args) {

		int[] x = { 1, 5, 6, 8, 3, 2, 7, 9, 10, 11 };
		Arrays.sort(x); // 배열 x를 정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < x.length; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}
}
