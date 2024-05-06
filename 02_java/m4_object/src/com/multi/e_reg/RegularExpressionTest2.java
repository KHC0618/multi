package com.multi.e_reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest2 {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^[0-9]*$"); 
		// 숫자로 시작하고 끝나는
		String str1 = "abcaa";
		String str2 = "123";
		String str3 = "";

		Matcher result1 = pattern.matcher(str1);
		Matcher result2 = pattern.matcher(str2);
		Matcher result3 = pattern.matcher(str3);

		System.out.println(result1.find());
		System.out.println(result2.find());
		System.out.println(result3.find());
	}
}