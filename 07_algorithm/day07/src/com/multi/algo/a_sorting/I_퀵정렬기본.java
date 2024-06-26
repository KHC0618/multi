
package com.multi.algo.a_sorting;
//https://ko.wikipedia.org/wiki/%ED%80%B5_%EC%A0%95%EB%A0%AC


//리스트 가운데서 하나의 원소를 고른다. 이렇게 고른 원소를 피벗이라고 한다.
//피벗 앞에는 피벗보다 값이 작은 모든 원소들이 오고, 피벗 뒤에는 피벗보다 값이 큰 모든 원소들이 오도록 피벗을 기준으로 리스트를 둘로 나눈다.
// 이렇게 리스트를 둘로 나누는 것을 분할이라고 한다. 분할을 마친 뒤에 피벗은 더 이상 움직이지 않는다.
//분할된 두 개의 작은 리스트에 대해 재귀(Recursion)적으로 이 과정을 반복한다. 재귀는 리스트의 크기가 0이나 1이 될 때까지 반복된다.
class I_퀵정렬기본 {
    //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  
        a[idx1] = a[idx2];  
        a[idx2] = t;
    }

    //--- 퀵 정렬(배열의 분할 과정을 표시)---//
    static void quickSort(int[] a, int left, int right) {
        int pl = left;                      // 왼쪽 커서
        int pr = right;                     // 오른쪽 커서
        int x = a[(pl + pr) / 2];           // 피벗(가운데 요소)
        System.out.println("가운데요소 " + x );

        System.out.printf("a[%d]～a[%d] : {", left, right);
        for (int i = left; i < right; i++)
            System.out.printf("%d , ", a[i]);
        System.out.printf("%d}\n", a[right]);

        System.out.println();
        do {
            while (a[pl] < x) pl++;//왼쪽에서 피벗 방향으로 증가하면서
            while (a[pr] > x) pr--;// 오른쪽에서 피벗방향으로 감소하면서

            System.out.println("pl  :  " + pl + "     pr  :  " + pr);

            if (pl <= pr)// 만약에  왼쪽 인덱스가 더 커지면  빠져나가야한다.

            swap(a, pl++, pr--);


        } while (pl <= pr);

        if (left < pr)  quickSort(a, left, pr);
        if (pl < right) quickSort(a, pl, right);
    }

    public static void main(String[] args) {
    	int[] x = { 1, 5, 6, 8, 3, 2, 7, 9, 10, 11 };

        quickSort(x, 0, x.length-1);            // 배열 x를 퀵정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < x.length-1; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}
