package com.multi.algo.c_arraytocollection;

public class B_CharInt로변환 {

	public static void main(String[] args) {
		//1. char --> int로 변경하는 방법
		//   '문자' - '0'
		char c = '0' - '0';
		System.out.println(c + 1); //1
		c = '1' - '0';
		System.out.println(c + 1); //2
		 c = '1'; //49, '0' = 48
		System.out.println(c + 1); //50
		System.out.println('5' - '0'); //5  53-48
		
		//2. char --> int로 변경하는 방법
		//Integer.parseInt(c + "")
		int i = Integer.parseInt(c + ""); // 문자열로 변환 -> int
		System.out.println(i + 1);



		// 숫자 -> 문자
		System.out.println((char)(5 + '0') ); //'5'
	}

}
