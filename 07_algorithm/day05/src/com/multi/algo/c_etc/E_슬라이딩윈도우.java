package com.multi.algo.c_etc;

import java.util.HashMap;
/* 슬라이딩 윈도우는 배열이나 문자열 같은 데이터 구조를 일정한 크기의 ＇윈도우＇ 또는 ＇창＇을 이동시켜가며 주어진 문제를 해결하는 기법
 * 이 윈도우는 데이터의 특정 범위를 가리키며, 시작점과 끝점이 함께 오른쪽으로(또는 필요에 따라 왼쪽으로) 이동하면서 문제의 조건을 만족하는지를 확인 ,
 * 아나그램은 두 문자열이 서로 같은 문자를 동일한 횟수만큼 포함하고 있지만, 순서가 다를 수 있는관계 , adbabda 과 aaabbdd  는 아나그램
 *
 *  즉, 슬라이딩 윈도우는 문제의 해결을 위해 데이터를 순차적으로 탐색하는 방법이며, 아나그램은 두 문자열 간의 특정 관계를 나타냄
 */
public class E_슬라이딩윈도우 {
//abccd
    //ab

        public static void main(String[] args) {
            HashMap<Character, Integer> map1 = new HashMap<>();
            HashMap<Character, Integer> map2 = null;

            // Scanner sc = new Scanner(System.in);

            String data = "adbabda";
            String ana = "abd";

            char[] data2 = data.toCharArray();
            char[] ana2 = ana.toCharArray();

            // 찾을값을   hashmap 에 넣음
            for (int i = 0; i < ana2.length; i++) {
                map1.put(ana2[i], map1.getOrDefault(ana2[i], 0) + 1);
            }

            System.out.println("map1 -->" + map1);

            System.out.println("data2.length -->" +data2.length);

            int count = 0;// 아나그램 총 개수를 저장할 변수

            for (int i = 0; i < data2.length - 1; i++) {
                map2 = new HashMap<>();
                // 해당 시작점에서의 아나그램 수


                // 시작과 끝 인덱스 계산
                int start = i;
                int end = i + map1.size() - 1;// 위 아나그램 체크할  map 길이 - 1 (인텍스로 구함, 그럼아래 포문에서는  <= , 사이즈로 하면 <)
                if (end >= data2.length - 1)
                    end = data2.length - 1;

                System.out.println(start + " to " + end);
                for (int j = start; j <= end; j++) {
                    map2.put(data2[j], map2.getOrDefault(data2[j], 0) + 1);
                }

                System.out.println("map2 -->" + map2);

                if (map1.equals(map2)) {// if m1.entrySet().equals(m2.entrySet() 비교 해줌 커서올려보면
                    count++; // 일치하면 카운트 증가
                }

                // 해당 시작점에서의 아나그램 수 출력
                System.out.println("----------count>> " + count);
            }
    }

}
