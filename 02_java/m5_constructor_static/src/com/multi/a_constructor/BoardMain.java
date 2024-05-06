package com.multi.a_constructor;

public class BoardMain {
    public static void main(String[] args) {
        Board board1 = new Board(1, "test1", "testText1", "홍길동");
        System.out.println(board1);

        Board board2 = new Board(2, "test2", "testText2", "정길동");
        System.out.println(board2);

        Board board3 = new Board(3, "test3", "testText3", "박길동");
        System.out.println(board3);
    }
}
