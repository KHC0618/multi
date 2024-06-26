// 재귀에 대한 이해를 돕는 순수 재귀 메서드 - 함수에서 자기 자신을 다시 호출해 작업을 수행하는 방식
package com.multi.algo.d_recursion;
// https://pythontutor.com/visualize.html#mode=edit



// 동적계획법 (dp) :  복잡한문제를 여러개의 간단한 문제로 분리하여 부분의 문제를 해결해서 최종적으로 복잡한 문제의 답을 구하는방법

//동적계획법의 원리
//1. 큰문제를 작은문제로 나눌수있어야한다
//2. 작은 문제들이 반복돼 나타나고 사용되며 이 작은문제들의 결과값은 항상 같아야한다
//3. 모든 작은 문제들은 한번만 계산해 dp 테이블에 저장하고 추후 재사용할때는 이 dp 테이블을 이용한다 -> 메모이제이션기법

// 톱-다운방식(하향식), 바텀업(상향식) 방식으로 구현할수있다.


public class A_Recur {
	// --- 순수 재귀 메서드 ---//
	static void recur(int n) {
		if (n > 0) {

			recur(n - 1);
			System.out.println("recur(n - 1)호출 후 >>" + n);

			recur(n - 2);
		}
	}

	public static void main(String[] args) {
		int x = 5;
		recur(x);
	}
}
