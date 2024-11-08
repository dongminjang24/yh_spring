package com.java_basic.generic.ex1;

public class BoxMain01 {
    public static void main(String[] args) {
        IntegerBox integerBox = new IntegerBox();
        integerBox.set(10); // auto-boxing
        Integer integer = integerBox.get();
        System.out.println(integer);

        StringBox stringBox = new StringBox();
        stringBox.set("Hello");
        String string = stringBox.get();
        System.out.println(string);


    }
}
