package com.multi.algo.e_programmers;

import java.util.Arrays;
import java.util.Scanner;
//https://www.acmicpc.net/problem/1920
public class D_수찾기_백준{ //이진검색
	public static void main(String[] args) {
		String input = "5\n4 1 5 2 3\n5\n1 3 7 9 5";
		   //전체목록 5개, 정수 입력, 5개 칮고싶고, 값입력
		Scanner in = new Scanner(input);
		int N = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		// 배열을 낮은 순 정렬되어있어야 한다.
		Arrays.sort(arr);
		int M = in.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			// 찾고자 하는 값이 있는 경우 1, 없는 경우 0을 출력하라는다. //제공되는 메소드써도됨
			if (binarySearch(arr, in.nextInt()) >= 0) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}
	public static int binarySearch(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length - 1; // 탐색 범위의 오른쪽 끝 인덱스
		// lo가 hi보다 커지기 전까지 반복한다.
		while (lo <= hi) {
			int mid = (lo + hi) / 2; // 중간 위치를 구한다.
			// key값이 중간 위치의 값보다 작을 경우
			if (key < arr[mid]) {
				hi = mid - 1;
			} else if (key > arr[mid]) { // key값이 중간 위치의 값보다 클 경우
				lo = mid + 1;
			} else { // key값과 중간 위치의 값이 같을 경우
				return mid; // 검색 성공
			}
		}
		// 찾고자 하는 값이 존재하지 않을 경우
		return -1;
	}
}
