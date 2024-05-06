package com.multi.practice;

public class Daughter {
    private String name;
    private String gender;
    public static int wallet = 10000;
    public static int count;

    public Daughter() {

    }

    public Daughter(String name, String gender) {
        count++;
        wallet -= 1000;
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Daughter{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
