package com.java_basic.designpatterns.behavior_patterns.command.afeter;

import com.java_basic.designpatterns.behavior_patterns.command.before.Light;

public class LightOnCommand implements Command{

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        new LightOffCommand(light).execute();
    }
}
