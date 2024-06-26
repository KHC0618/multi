package com.multi.algo.a_sorting;

import java.util.Arrays;
//https://ko.wikipedia.org/wiki/%EB%B2%84%EB%B8%94_%EC%A0%95%EB%A0%AC
//버블 정렬은 기본적으로 배열의 두 수(
//		a.b를 선택한 뒤, 만약 그 두 수가 정렬되었다면 놔두고 아니라면 두 수를 바꾸는 방식으로 진행된다.
//		오름차순으로 정렬할 때는 a<b, 내림차순이라면 a>b여야 정렬된 것으로 판단한다. 이를 배열의 처음부터 끝까지 반복한다.


public class F_버블정렬오름차순 {

	public static void main(String[] args) {
		int[] array = { 6, 4, 2, 1, 3, 5 };
		// 4, 6, 2, 1, 3, 5
		// 4, 2, 6, 1, 3, 5
		// 4, 2, 1, 6, 3, 5
		// 4, 2, 1, 3, 6, 5
		// 4, 2, 1, 3, 5, 6

		// 2, 4, 1, 3, 5, 6
		// 2, 1, 4, 3, 5, 6
		// 2, 1, 3, 4, 5, 6
		// 2, 1, 3, 4, 5, 6

		// 1, 2, 3, 4, 5, 6
		int temp = 0; // 교환용 임시 변수

		// 배열의 길이 -1 (마지막 숫자 제외)
		//정렬개수가 정렬할 때마다 줄어든다 --> 그래서, 가장 많은 개수부터 시작
		for (int i = array.length - 1; i >= 0; i--) { // i = 5 → 4 → 3 → 2 → 1 → 0
			for (int j = 0; j < i; j++) { // i = 5 : j = 0 → 1 → 2 → 3 → 4
				if (array[j] > array[j + 1]) {  //앞에꺼가 뒤에꺼 보다 큰지 확인//첨에 4하고 6 비교  / 6하고 2 비교 / ..j 가 1식 증가하면서 비교
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					System.out.println(Arrays.toString(array));
				}

			}
		}
		System.out.println();
		System.out.println(Arrays.toString(array)); 
	}

}
