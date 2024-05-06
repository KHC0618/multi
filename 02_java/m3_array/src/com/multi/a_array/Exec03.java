package com.multi.a_array;

public class Exec03 {
    public static void main(String[] args) {
        String[] names = new String[2];
        names[0] = "로운";
        names[1] = "제니";
        for (String s : names) {
            System.out.println(s);
        }
        System.out.println("개수 : " + names.length + "개");

        String[] names2;
        names2 = new String[]{"ab", "b"};
        System.out.println(names2[0].length());

        int[] arrInt = new int[200];
        arrInt[0] = 1000;
        arrInt[1] = 2000;
        arrInt[2] = 3000;
        arrInt[199] = 5000;
        for (int i = 0; i < arrInt.length; i++) {
            System.out.println(arrInt[i] + " ");
        }

        double[] arrDouble = new double[300];
        arrDouble[0] = 10.1;
        arrDouble[1] = 20.2;
        arrDouble[2] = 30.2;
        arrDouble[299] = 50.5;
        for (double d : arrDouble) {
            System.out.println(d + " ");
        }

        String[] tour = {"제주도", "부산", "일본", "싱가폴", "시애틀"};
        for (int i = 0; i < tour.length; i++) {
            System.out.print(tour[i] + " ");
        }
        System.out.println();
        for (String s : tour) {
            System.out.print(s + " ");
        }
        System.out.println();

        char[] color = {'v', 'y', 'n', 'p', 's', 'l'};
        for (int i = 0; i < color.length; i++) {
            System.out.print(color[i] + " ");
        }
        System.out.println();
        for (char c : color) {
            System.out.print(c + " ");
        }
        System.out.println();

        double[] height = new double[5];
        height[0] = 123.4;
        height[1] = 176.1;
        height[2] = 188.3;
        height[3] = 162.2;
        height[4] = 158.1;
        for (int i = 0; i < height.length; i++) {
            System.out.print(height[i] + " ");
        }
        System.out.println();
        for (double d : height) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
}
