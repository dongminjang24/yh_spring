package com.java_basic.collection.array;


public class MyArrayListV2Main {
    public static void main(String[] args) {
        MyArrayListV2 list = new MyArrayListV2(2);
        System.out.println("=====데이터 추가====");
        System.out.println(list);
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");
        System.out.println(list);
        System.out.println("== 범위 초과 ==");
        list.add("d");
        System.out.println( list);
        list.add("e");
        System.out.println( list);
        list.add("f");
        System.out.println( list);

    }
}