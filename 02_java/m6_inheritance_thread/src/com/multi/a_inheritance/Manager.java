package com.multi.a_inheritance;

public class Manager extends Employee {
    private int bonus;

    public void test() {
        System.out.println("이름은 " + super.name);
        System.out.println("주소는 " + super.address);
        System.out.println("월급은 " + super.salary);

//        System.out.println("월급은 " + super.rnn);   private라서 접근할 수 없다.
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + this.bonus +
                ", name='" + super.name + '\'' +
                ", address='" + super.address + '\'' +
                ", salary=" + super.salary +
                '}';
    }
}
