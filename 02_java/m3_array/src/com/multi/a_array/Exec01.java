package com.multi.a_array;

public class Exec01 {
    public static void main(String[] args) {
        int[] nArr = {1, 2, 3, 4};
//        int[] :타입
//        nArr:
//        주소
//        배열데이터 {1, 2, 3, 4}

        System.out.println(nArr);

        int[] nArr2 = new int[1000];    // 저장할 데이터의 크기를 알고 있고, 값을 모르는 상태.
        System.out.println(nArr2);
        System.out.println(nArr2.toString());
        System.out.println(nArr2[0]);

        double[] height = {123.4, 234.2, 124.5};
        double[] space = new double[500];
        char[] gender = {'남', '여', '남'};
        String[] space2 = new String[333];

        String[] tour = {"제주도", "부산", "일본", "싱가폴", "시애틀"};

        for (int i = 0; i < tour.length; i++) {
            System.out.print(tour[i] + " ");
        }
        System.out.println();

        for (String s : tour) {
            System.out.println(s);
        }
    }
}
