package com.multi.practice;

import javax.swing.*;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        String width = JOptionPane.showInputDialog("가로 길이");
        String height = JOptionPane.showInputDialog("가로 길이");

        double widthD = Double.parseDouble(width);
        double heightD = Double.parseDouble(height);

        double square = widthD * heightD;

        JOptionPane.showMessageDialog(null, "사각형의 넓이는 " + square);

        Scanner sc = new Scanner(System.in);
        System.out.print("숫자1 입력 : ");
        int num1 = sc.nextInt();
        sc.nextLine();
        System.out.print("숫자2 입력 : ");
        int num2 = sc.nextInt();
        sc.nextLine();

        System.out.println("두 수의 합 : " + (num1 + num2));
        System.out.println("두 수의 차 : " + (num1 - num2));
        System.out.println("두 수의 곱 : " + (num1 * num2));
        System.out.println("두 수의 분 : " + ((double) num1 / num2));

        String temp = JOptionPane.showInputDialog("현재 온도");


        double tempD = Double.parseDouble(temp);

        String msg = (tempD >= 25) ? "너무 더워요." : "괜찮아요.";
        System.out.println(msg);

        //---------------------------------------------------------------------------------//

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

        //---------------------------------------------------------------------------------//

        int pre = 0;
        int post = 0;

        while (true) {
            System.out.print("숫자1 입력 : ");
            int num3 = sc.nextInt();
            sc.nextLine();
            System.out.print("숫자2 입력 : ");
            int num4 = sc.nextInt();
            sc.nextLine();

            if (num3 > num4) {
                System.out.println("숫자1이 더 큽니다.");
                pre++;
            } else if (num3 < num4) {
                System.out.println("숫자2가 더 큽니다.");
                post++;
            } else {
                System.out.println("두 수가 동일하거나, 잘못 된 입력입니다.");
            }
            System.out.print("더 하시겠습니까? ( y / n ) : ");
            String more = sc.next();

            if (more.equals("n")) {
                System.out.println("숫자 비교를 종료합니다.");
                break;
            }
        }
        System.out.println("숫자1이 큰 경우는 " + pre + "회, 숫자2가 큰 경우는 " + post + "회 입니다.");

        //---------------------------------------------------------------------------------//

        System.out.print("숫자1 입력 : ");
        int num5 = sc.nextInt();
        sc.nextLine();
        System.out.print("숫자2 입력 : ");
        int num6 = sc.nextInt();
        sc.nextLine();

        if (num5 > num6) {
            System.out.println("숫자1이 더 큽니다.");
        } else if (num5 < num6) {
            System.out.println("숫자2가 더 큽니다.");
        } else {
            System.out.println("두 수가 동일하거나, 잘못 된 입력입니다.");
        }
        System.out.println("숫자1 : " + num5);
        System.out.println("숫자2 : " + num6);

        System.out.print("당신이 좋아하는 과목은 >> ");
        String subject = sc.nextLine();

        switch (subject) {
            case "java":
            case "Java":
            case "JAVA":
            case "자바":
                System.out.println("JSP로 점프");
                break;
            case "python":
            case "Python":
            case "PYTHON":
            case "파이썬":
                System.out.println("장고로 점프");
                break;
            default:
                System.out.println("무조건 열심히!!");
                break;
        }

        //---------------------------------------------------------------------------------//

        Date date = new Date();
        int hour = date.getHours();

        if (hour < 11) {
            System.out.println("굿모닝");
        } else if (hour < 15) {
            System.out.println("굿애프터눈");
        } else if (hour < 19) {
            System.out.println("굿이브닝");
        } else {
            System.out.println("굿나잇");
        }


        int month = date.getMonth() + 1;

        switch (month) {
            case 2:
                System.out.println("28일까지");
                break;
            case 4:
            case 6:
            case 7:
            case 11:
                System.out.println("30일까지");
                break;
            default:
                System.out.println("31일까지");
                break;
        }

        //---------------------------------------------------------------------------------//

        int year = date.getYear() + 1900;   // getYear은 현재 연도에서 1900이 빠진 값을 반환하므로 현재 연도를 구하려면 +1900을 해야함.
        if (year >= 2000) {
            System.out.println("밀레니엄 세대시군요.");
        } else {
            System.out.println("밀레니엄 세대가 아니시군요.");
        }

        int day = date.getDay();
        switch (day) {
            case 0:
            case 6:
                System.out.println("쉬~~~~~~~~~~자");
                break;
            default:
                System.out.println("열~~심히 공부하자");
                break;
        }

        int month2 = date.getMonth() + 1;

        switch (month2) {
            case 2:
                System.out.println("28일까지");
                break;
            case 4:
            case 6:
            case 7:
            case 11:
                System.out.println("30일까지");
                break;
            default:
                System.out.println("31일까지");
                break;
        }

        //---------------------------------------------------------------------------------//

        System.out.print("몸무게 입력 : ");
        double weight = sc.nextDouble();
        sc.nextLine();
        System.out.print("신장 입력 : ");
        double height2 = sc.nextDouble();
        sc.nextLine();

        double bmi = weight / (height2 * height2);

        System.out.println("bmi는 " + bmi + "입니다.");


        int point = 3000;
        System.out.print("추가 포인트 : ");
        double addPoint = sc.nextDouble();
        sc.nextLine();

        System.out.println("최종 포인트는 " + (point + addPoint));
    }
}
