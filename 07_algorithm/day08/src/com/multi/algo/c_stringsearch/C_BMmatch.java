// 보이어-무어법으로 문자열 검색


//보이어-무어 알고리즘의 작동은 KMP 알고리즘과 유사하게 불필요한 비교는 건너뛰고 유의미한 비교만 진행하겠다는 것
//KMP 알고리즘의 경우에는 접두사와 접미사가 같은 최대길이를 저장하는 배열을 만들어 앞에서부터 검사를 진행하였다면,
//보이어-무어 알고리즘은 문자열을 검색할때 주로 뒤에서 부터 확인

//
//나쁜문자이동(bad character) - 문자열과 패턴이 불일치 하도록 패턴이동 (나쁜 문자(불일치하는 문자) 오른쪽에 있는것, 불일치한것이 2개이상인경우)
//착한 접미부이동(good suffix) - 문자열에서 찾은 나쁜문자 위치보다 패턴의 문자가 뒤쪽에 위치한경우는 활용 불가
//		                    - 오른쪽에서 이동하면서 나쁜문자를 찾을때까지 확인, 일치하는 부분을 찾한 접미부라고함, 이렇게 찾은 접미부 위치로 문자열을 이동하여 일치확인
//							- 착한접미부와 일치하는 문자열이 있는경우는 착한접미부로 이동
//		                                                없는경우는 착한접미부 왼쪽부터 버려가면서 확인
//                                                        그래도 없으면 다시 문자열길이만큼 그뒤로 전체이동해서 확인


package com.multi.algo.c_stringsearch;
class C_BMmatch {
static int bmMatch(String txt, String pat) {
	int pt; // txt를 따라가는 커서
	int pp; // pat를 따라가는 커서
	int txtLen = txt.length(); // txt의 문자 개수
	int patLen = pat.length(); // pat의 문자 개수
	int[] skip = new int[Character.MAX_VALUE + 1]; // 건너뛰기 표(skip 테이블)
	// skip 테이블 작성
		for (pt = 0; pt <= Character.MAX_VALUE; pt++)
			skip[pt] = patLen;
		for (pt = 0; pt < patLen - 1; pt++)
			skip[pat.charAt(pt)] = patLen - pt - 1; // pt == patLen - 1
	// 검색
		while (pt < txtLen) {
		pp = patLen - 1; // pat의 마지막 문자에 주목
		while (txt.charAt(pt) == pat.charAt(pp)) {
			if (pp == 0)
				return pt; // 검색 성공
			pp--; 	pt--;
		}
		pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
	}
		return -1; // 검색 실패
	}

	public static void main(String[] args) {
		String s1 = "i am a student.";
		String s2 = "student";
		int idx = bmMatch(s1, s2);
		if (idx == -1) {
			System.out.println("텍스트 안에 패턴이 없습니다.");
		} else {
			int len = 0;
			for (int i = 0; i < idx; i++) {
				len += s1.substring(i, i + 1).getBytes().length;
			}
			len += s2.length();

			System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
			System.out.println("텍스트: " + s1);
			System.out.printf(String.format("패  턴: %%%ds\n", len), s2);
		}
	}
}

