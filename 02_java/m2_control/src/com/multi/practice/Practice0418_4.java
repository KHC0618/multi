package com.multi.practice;

import java.util.Random;
import java.util.Scanner;

public class Practice0418_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int count = 0;
        int win = 0;

        while (true) {
            int ranNum = random.nextInt(3);
            System.out.println("0)가위, 1)바위, 2)보 (숫자로 입력해주세요.) >> ");
            int me = sc.nextInt();
            sc.nextLine();

            count++;
            System.out.println("컴퓨터 : " + ranNum + ", 나 : " + me);

            if (ranNum == 0) {
                switch (me) {
                    case 0:
                        System.out.println("비겼습니다.");
                        break;
                    case 1:
                        System.out.println("이겼습니다.");
                        win++;
                        break;
                    case 2:
                        System.out.println("졌습니다.");
                        break;
                }
            } else if (ranNum == 1) {
                switch (me) {
                    case 0:
                        System.out.println("졌습니다.");
                        break;
                    case 1:
                        System.out.println("비겼습니다.");
                        break;
                    case 2:
                        System.out.println("이겼습니다.");
                        win++;
                        break;
                }
            } else {
                switch (me) {
                    case 0:
                        System.out.println("이겼습니다.");
                        win++;
                        break;
                    case 1:
                        System.out.println("졌습니다.");
                        break;
                    case 2:
                        System.out.println("비겼습니다.");
                        break;
                }
            }
            System.out.print("더 하시겠습니까? ( y / n ) : ");
            String more = sc.next();
            sc.nextLine();

            if (more.equals("n")) {
                System.out.println("가위바위보 게임을 종료합니다.");
                break;
            }
        }
        System.out.println("전체 " + count + "번의 게임에서 " + win + "번 이겼습니다.");
    }
}
