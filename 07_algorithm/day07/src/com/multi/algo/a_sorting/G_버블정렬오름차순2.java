package com.multi.algo.a_sorting;

import java.util.Arrays;

public class G_버블정렬오름차순2 {

	public static void main(String[] args) {
		long n = 642135;
		String s = String.valueOf(n);
		char[] array = s.toCharArray();
		char temp = ' '; // 교환용 임시 변수

		//구현
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(array)); 
	}

}
