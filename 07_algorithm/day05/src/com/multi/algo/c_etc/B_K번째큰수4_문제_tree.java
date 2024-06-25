package com.multi.algo.c_etc;

import java.util.TreeSet;

public class B_K번째큰수4_문제_tree {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int k = sc.nextInt(); //k번째 작은 수, 3
//		TreeSet<Integer> tree = new TreeSet<Integer>();
//		
//		while(true) {
//			int data = sc.nextInt();
//			if( data == 0) {
//				break;
//			}else {
//				tree.add(data);
//			}
//		}
//		System.out.println(tree);
//		
//		Object[] arr = tree.toArray();
//		System.out.println("첫 번째 작은 수 : " + arr[0]);
//		System.out.println("두 번째 작은 수 : " + arr[1]);
//		System.out.println(k + "번째 작은 수 : " + arr[k - 1]);
		
		int k = 3;
		int arr[] = {22, 22, 44, 11, 11, 33, 55, 66, 20, 10, 30, 55};
		TreeSet<Integer> tree = new TreeSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			tree.add(arr[i]);
		}
		System.out.println(tree);
		System.out.println(tree.size());
		System.out.println(tree.first());//제일작은거 
		System.out.println(tree.last());//제일큰수 
		System.out.println(tree.lower(20));
		System.out.println(tree.higher(20));
		Object[] arr2 = tree.toArray();
		System.out.println(arr2[arr2.length-k]);
	}

}
