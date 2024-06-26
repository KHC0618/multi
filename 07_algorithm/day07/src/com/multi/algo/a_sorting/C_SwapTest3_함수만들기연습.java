package com.multi.algo.a_sorting;

import java.util.Arrays;

public class C_SwapTest3_함수만들기연습 {

	public static void print(String[] str) {
		System.out.println(Arrays.toString(str));

	}
	
	public static void swap(String[] str, int idx1, int idx2) {
		// 구현
		String temp = str[idx1];
		str[idx1] = str[idx2];
		str[idx2] = temp;
	}
	public static void main(String[] args) {
		String[] str = {"햄버거", "샌드위치", "커피"};
		print(str);
		//"str배열"에 있는 것 중에서 "0번째 위치"와 "1번째 위치"를 바꾸어라.
		// 구현
		swap(str, 0, 1);
		print(str);
	}
}
