// 재귀 함수를 메모화로 구현
//Memoization 메모이제이션 : 동일한 계산을 반복해야 할 경우 한 번 계산한 결과를 메모리에 저장해 두었다가 꺼내 씀으로써
// 중복 계산을 방지할 수 있게 하는 기법



package com.multi.algo.d_recursion;

class F_Memoization1 {
	static String[] memo;

	//--- 메모화를 도입한 메서드 recur ---//
	static void recur(int n) {
		if (memo[n + 1] != null)
			System.out.print("메모값 출력>> " + memo[n + 1]);
			// 메모를 출력
		else {
			if (n > 0) {
				recur(n - 1);
				System.out.println("recur(n - 1)호출 후>>" + n);
				recur(n - 2);
				memo[n + 1] = memo[n] + n + "\n" + memo[n - 1];
				// 메모화
			} else {
				memo[n + 1] = "";     // 메모화 : recur(0)과 recur(-1)은 빈 문자열
			}
		}
		System.out.println("n>>" + n);

	}

	public static void main(String[] args) {
		int x = 3;

		memo = new String[x + 2];
		recur(x);
	}
}
