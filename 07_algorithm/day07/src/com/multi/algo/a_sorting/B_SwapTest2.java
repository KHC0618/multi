package com.multi.algo.a_sorting;

import java.util.Arrays;


public class B_SwapTest2 {

	public static void print(int[] num) {
		System.out.println(Arrays.toString(num));

	}
	
	public static void swap(int[] num, int idx1, int idx2) {
		int temp = num[idx1]; //6
		num[idx1] = num[idx2]; //{ 9, 1, 2, 3, 5, 9 }
		num[idx2] = temp; //{ 6, 1, 2, 3, 5, 9 }
	}
	public static void main(String[] args) {
		int[] num = { 6, 1, 2, 3, 5, 9 };
		//6,9를 swap
		//swap자리를 바꿀때는 temp임시변수가 필요
		//덮어써지는 데이터가 사라지기 때문에
		//사라지기 전에 백업하는 a목적 
		//System.out.println(Arrays.toString(num));
		print(num);
//		int temp = num[0]; //6
//		num[0] = num[5]; //{ 9, 1, 2, 3, 5, 9 }
//		num[5] = temp; //{ 6, 1, 2, 3, 5, 9 }
		swap(num, 0, 5);
		//System.out.println(Arrays.toString(num));
		print(num);
	}
}
