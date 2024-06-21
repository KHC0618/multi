package com.multi.algo.c_arraytocollection;


///문자열에서 긴단어 출력하기

public class ZA_문자열긴단어출력 {
    public static void main(String[] args) {
        String s = "i am a java programmer! i am a body.";

        String[] sList = s.split(" ");

        int length = 0;

        String result = "";

        for (int i = 0; i < sList.length; i++) {
            int temp = sList[i].length();
            if (length < temp) {
                result = sList[i];
                length = temp;
            }
        }

        System.out.println(result);
    }

}
