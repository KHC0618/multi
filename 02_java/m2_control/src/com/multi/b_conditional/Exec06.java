package com.multi.b_conditional;

public class Exec06 {
    public static void main(String[] args) {
        // 12 1 2 / 3 4 5 / 6 7 8 / 9 10 11
        int month = 4;

        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("겨울입니다.");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("봄입니다.");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름입니다.");
                break;
            default:
                System.out.println("가을입니다.");
                break;
        }

        String no = "A100EX";

        switch (no.charAt(0)) {
            case 'A':
                System.out.println("기획부입니다.");
                break;
            case 'B':
                System.out.println("총무부입니다.");
                break;
            case 'C':
                System.out.println("개발부입니다.");
                break;
            default:
                System.out.println("해당 부서가 없습니다.");
                break;
        }

        String ssn = "880115-1056512";

        switch (ssn.charAt(7)) {
            case '1': case '3':
                System.out.println("남자입니다.");
                break;
            case '2': case '4':
                System.out.println("여자입니다.");
                break;
            default:
                System.out.println("주민등록번호를 다시 입력해주세요.");
                break;
        }
    }
}
