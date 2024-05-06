package com.multi.c_loop;

import javax.swing.*;

public class Exec02 {
    public static void main(String[] args) {

        while(true) {
            System.out.println("계속 돕니다 ");
            String choice = JOptionPane.showInputDialog("계속 하실래요? y)yes or n)no");

            if (choice.equals("n") || choice.equals("no")){
                System.out.println("프로그램을 종료합니다.");
//                exit와 return은 main함수가 끝나기 때문에 반복문의 바깥에 있는 코드가 실행되지 않음. java: unreachable statement 에러가 뜬다.
//                System.exit(0);
//                return;
//                break;
            }
        }
//        System.out.println("반복문의 바깥");
    }
}
