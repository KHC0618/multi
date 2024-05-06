package com.multi.b_polymorphism;

import javax.swing.*;

public class ActionButton {
    private static int count;
    private static final int PRICE = 5000;

    public ActionButton(String food, JLabel center, JLabel result, JTextField t1) {
        count++;
        center.setIcon(new ImageIcon("images/" + food + ".png"));
        result.setText("결제금액 : " + (count * PRICE));
        t1.setText(count + "개");
    }
}
