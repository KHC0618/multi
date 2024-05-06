package com.multi.b_app01;

import java.util.Arrays;

public class Exec08 {
    public static void main(String[] args) {
        String s1 = " 011-245-1234 ";
        String s = s1.trim(); //공백제거

        String first = s.substring(0, 3); //011
        String second = s.substring(4, 7); //245
        System.out.println(first + " " + second);
        //3. 문자열의 비교
        switch (first) {
            case "011":
                System.out.println("SK");
                break;
            case "019":
                System.out.println("LG");
                break;
            default:
                System.out.println("APPLE");
                break;
        }
        //4. 문자열의 길이
        if (second.length() >= 4) {
            System.out.println("최신폰");
        } else {
            System.out.println("올드폰");
        }
        String s2 = "감자,고구마,양파";
        String[] arrayS2 = s2.split(",");
        System.out.println(Arrays.toString(arrayS2));
        String[] arrayS = s.split("-");
        System.out.println(Arrays.toString(arrayS));
    }
}
