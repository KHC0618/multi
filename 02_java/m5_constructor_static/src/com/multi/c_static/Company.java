package com.multi.c_static;

public class Company {
    public static void main(String[] args) {
        Employee emp1 = new Employee("홍길동", 30, "남자");
        Employee emp2 = new Employee("박길동", 43, "남자");
        Employee emp3 = new Employee("제니", 28, "여자");
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        System.out.println("총 인원 : " + Employee.count + "명");
        System.out.println("평균 나이 : " + Employee.avgAge());
        System.out.println("평균 나이 : " + (double) Employee.sum / Employee.count);
    }
}
