package com.multi.b_app01;

import javax.swing.*;
import java.util.Arrays;

public class Exec05 {
    public static void main(String[] args) {
        String[] names = {"블랙핑크", "유재석", "아이유", "이효리", "비"};
        int[] count = {0, 0, 0, 0, 0};

        for (int i = 0; i < 10; i++) {
            String choice = JOptionPane.showInputDialog("투표할 사람 번호 입력 0)블랙핑크, 1)유재석, 2)아이유, 3)이효리, 4)비");
            int ch2 = Integer.parseInt(choice);
            if (ch2 < 0 || ch2 > 4) {
                i--;
            } else {
                count[ch2]++;
                System.out.println("i 값 : " + i);
            }
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(i + "번은 " + count[i] + "표를 받았습니다.");
        }

        int max = count[0];
        for (int i = 0; i < count.length; i++) {
            if(count[i] > max) {
                max = count[i];
            }
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i] == max) {
                System.out.println("최다 득표자는 " + max + "표를 받은 " + names[i] + "님 입니다.");
            }
        }
        System.out.println(Arrays.toString(count));
        // 최대 투표 수를 찾습니다.
        int max1 = Arrays.stream(count).max().orElse(-1);
        System.out.println(max1);
    }
}
