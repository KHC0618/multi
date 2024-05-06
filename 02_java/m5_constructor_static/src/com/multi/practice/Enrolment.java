package com.multi.practice;

public class Enrolment {
    private String subject;
    private String time;
    private String name;

    public Enrolment() {

    }

    public Enrolment(String subject, String time, String name) {
        this.subject = subject;
        this.time = time;
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Enrolment{" +
                "subject='" + subject + '\'' +
                ", time=" + time +
                ", name='" + name + '\'' +
                '}';
    }
}
