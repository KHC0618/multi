package com.multi.practice;

public class Practice0418_5 {
    public static void main(String[] args) {
        for (int i = 4; i < 10; i += 2) {
            for (int j = 0; j < (10 - i); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < (10 - i) * 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 20; i >= 0; i -= 2) {
            for (int j = 1; j <= 20 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
