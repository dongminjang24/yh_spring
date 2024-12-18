package com.java_basic.generic.test.ex3.unit;

public class UnitUtilTest {
    public static void main(String[] args) {
        Marine m1 = new Marine("마린1", 40);
        Marine m2 = new Marine("마린2", 50);
        Marine marine = UnitUtil.maxHp(m1, m2);
        System.out.println("resultMarine " +  marine);

        Zealot z1 = new Zealot("질럿1", 100);
        Zealot z2 = new Zealot("질럿2", 150);
        Zealot zealot = UnitUtil.maxHp(z1, z2);
        System.out.println("resultZealot " +  zealot);
    }
}