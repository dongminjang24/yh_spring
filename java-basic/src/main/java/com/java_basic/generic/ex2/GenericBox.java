package com.java_basic.generic.ex2;

public class GenericBox<T> {
    private T value;

    public void set(T object) {
        this.value = object;
    }

    public T get() {
        return value;
    }
}
