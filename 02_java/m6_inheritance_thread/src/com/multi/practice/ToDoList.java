package com.multi.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList todoList = new ArrayList();

    public ArrayList getTodoList() {
        return todoList;
    }

    public void setTodoList(ArrayList todoList) {
        this.todoList = todoList;
    }

    Scanner sc = new Scanner(System.in);

    public void insertSelectNumber(int select) {
        switch (select) {
            case 2:
                todoList.add(sc.nextLine());
                break;
            case 3:
                int select2 = sc.nextInt();
                sc.nextLine();
                if (select2 > 0 && select2 <= todoList.size()) {
                    todoList.set(select2 - 1, sc.nextLine());
                } else {
                    System.out.println("해당 번호는 비어있습니다.");
                }
                break;
            case 4:
                int select3 = sc.nextInt();
                sc.nextLine();
                if (select3 > 0 && select3 <= todoList.size()) {
                    todoList.remove(select3 - 1);
                } else {
                    System.out.println("해당 번호는 비어있습니다.");
                }
                break;
            default:
                System.out.println("잘못 된 접근입니다.");
                break;
        }
    }
}
