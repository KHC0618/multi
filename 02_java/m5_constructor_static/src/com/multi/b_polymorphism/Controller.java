package com.multi.b_polymorphism;

public class Controller {

    private int food1 = 0;
    private int food2 = 0;
    private int food3 = 0;
    private int totalCount = 0;
    private final int PRICE1 = 7000;
    private final int PRICE2 = 5000;
    private final int PRICE3 = 6000;

    public int getFood1() {
        return food1;
    }

    public void setFood1(int num) {
        if (num == 4) {
            this.food1 = 0;
            return;
        }
        this.food1++;
    }

    public int getFood2() {
        return food2;
    }

    public void setFood2(int num) {
        if (num == 4) {
            this.food2 = 0;
            return;
        }
        this.food2++;
    }

    public int getFood3() {
        return food3;
    }

    public void setFood3(int num) {
        if (num == 4) {
            this.food3 = 0;
            return;
        }
        this.food3++;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount() {
        this.totalCount = food1 + food2 + food3;
    }

    public int totalFood1Sum() {
        return food1 * PRICE1;
    }

    public int totalFood2Sum() {
        return food2 * PRICE2;
    }

    public int totalFood3Sum() {
        return food3 * PRICE3;
    }

    public int totalSum() {
        return totalFood1Sum() + totalFood2Sum() + totalFood3Sum();
    }
}
