package com.multi.a_inheritance;

public class WonderWoman extends Woman {
    private boolean isSwim;

    public WonderWoman(String name, int age, String food, boolean isSwim) {
        super(name, age, food);
        this.isSwim = isSwim;
    }

    public boolean getSwim() {
        return isSwim;
    }

    public void setSwim(boolean isSwim) {
        this.isSwim = isSwim;
    }

    @Override
    public String toString() {
        return "WonderWoman{" +
                "swim=" + isSwim +
                ", food=" + getFood() +
                ", name=" + getName() +
                ", age=" + getAge() +
                '}';
    }
}
