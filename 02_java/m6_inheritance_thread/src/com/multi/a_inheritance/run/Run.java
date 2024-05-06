package com.multi.a_inheritance.run;

import com.multi.a_inheritance.Manager;
import com.multi.a_inheritance.SuperMan;
import com.multi.a_inheritance.WonderWoman;

public class Run {

    public static void main(String[] args) {
        Manager m = new Manager();
        m.setName("홍길동");
        System.out.println(m);

        SuperMan superMan = new SuperMan("박규", 31, 1000, true);
        System.out.println(superMan);
        superMan.eat();
        superMan.run();
        superMan.sleep();
        superMan.space();

        WonderWoman wonderWoman = new WonderWoman("제니", 23, "밥", true);
        System.out.println(wonderWoman);
        wonderWoman.eat();
        wonderWoman.sleep();

    }

}
