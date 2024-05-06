package com.multi.a_classmake;

public class Tv {
    private int ch;
    private int vol;
    private boolean onOff;


    public int getCh() {
        return ch;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    public void onOff() {
        this.onOff = !this.onOff;
        if(this.onOff) {
            System.out.println("켜지다.");
        } else {
            System.out.println("꺼지다.");
        }
    }

    @Override
    public String toString() {
        return "Tv{" +
                "ch=" + ch +
                ", vol=" + vol +
                ", onOff=" + onOff +
                '}';
    }

}
