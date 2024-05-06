package com.multi.a_inheritance;

public class Employee {

    public String name;     // 같은 + 다른 패키지 아무데서나 접근 가능
    String address;         // 같은 패키지에서만 접근 가능
    protected int salary;   // 같은 패키지 + 다른 패키지의 상속 할 경우만 사용 가능
    private int rrn;        // 해당 클래스에서만 사용 가능

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRrn() {
        return rrn;
    }

    public void setRrn(int rrn) {
        this.rrn = rrn;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", rrn=" + rrn +
                '}';
    }

}
