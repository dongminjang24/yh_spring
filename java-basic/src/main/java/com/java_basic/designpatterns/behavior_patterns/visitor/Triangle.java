package com.java_basic.designpatterns.behavior_patterns.visitor;

public class Triangle implements Shape {

    @Override
    public void accept(Device device) {
        device.print(this);
    }
}