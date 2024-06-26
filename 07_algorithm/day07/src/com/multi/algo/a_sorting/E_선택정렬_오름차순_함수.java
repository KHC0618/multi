package com.multi.algo.a_sorting;

import java.util.Arrays;

public class E_선택정렬_오름차순_함수 {

	public static void swap(int[] arr, int i, int min) {
		//구현
		int tmp = arr[i];
		arr[i] = arr[min];
		arr[min] = tmp;
	}
	
	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, i, min);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 1, 2, 6 };
		System.out.println(Arrays.toString(arr));
		
		selectionSort(arr);
	}
	
	
}
