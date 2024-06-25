package com.multi.algo.b_nonlinear;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class C_TreeSetTest {

	public static void main(String[] args) {
		//TreeSet<Integer> tree = new TreeSet<Integer>(); //오름차순 
		TreeSet<Integer> tree = new TreeSet<Integer>(Collections.reverseOrder()); //내림차순 
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) { //4 5 3 1 2
			tree.add(sc.nextInt());
		}
		System.out.println(tree);
		Object[] arr = tree.toArray();
		System.out.println(arr[arr.length - 1]);
		sc.close();

	}

}

