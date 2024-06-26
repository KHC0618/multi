// 팩토리얼 값을 재귀적으로 구함
//n까지의 모든 양의 정수의 곱
package com.multi.algo.d_recursion;

class A_Factorial {
    //--- 음이 아닌 정수 n의 팩토리얼 값을 반환 ---//
    static int factorial(int n) {
        if (n > 0)
            return n * factorial(n - 1);
        else
            return 1;


       // return (n > 0) ? n * factorial(n - 1) : 1; // 삼항연산
    }

    public static void main(String[] args) {
    	int x = 5;
        System.out.println(x + "!>> " + factorial(x));
    }
}
