package com.uni.data.a_sorting;

import java.util.Arrays;

public class D_선택정렬오름차순 {//선택 정렬은 정렬되지 않은 데이터들에 대해 가장 작은 데이터를 찾아 가장 앞의 데이터와 교환해나가는 방식
//https://ko.wikipedia.org/wiki/%EC%84%A0%ED%83%9D_%EC%A0%95%EB%A0%AC
//for i = 0 to n:
//	a[i]부터 a[n - 1]까지 차례로 비교하여 가장 작은 값이 a[j]에 있다고 하자.
//			a[i]와 a[j]의 값을 서로 맞바꾼다.

	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 1, 2, 6 };
		int n = arr.length; //6
		for (int i = 0; i < n - 1; i++) { //인덱스 5 (n-1)까지 확인해야 아래 for 문에서 6(n)과 비교!
			int min = i; // 바꿔줄 위치 인덱스
			//맨앞자리에 최소값을 찾아 넣어야하는데
			//맨앞자리는 반복하면서 앞으로 한칸 이동한다.
			//정렬된 나머지 오른쪽 부분에서 제일 맨앞자리를 지정해야한다.
			System.out.println("i: " + i);
			// 가장 작은 값을 찾는 반복문
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min])
					min = j; // 더 작은 값으로 인덱스 바꿔줌
			}
			System.out.println("min: " + min);
			System.out.println(Arrays.toString(arr));
			// 배열 값을 인덱스 위치의 값과 바꿔줌 // 스왑부분, 함수로 따로 빼도 됨
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
			System.out.println(Arrays.toString(arr));
		}
		System.out.println();
		System.out.println(Arrays.toString(arr));
	
	
	

	}
}
