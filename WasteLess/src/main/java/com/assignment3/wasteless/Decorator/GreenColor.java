package com.assignment3.wasteless.Decorator;

public class GreenColor implements Color {

    String color;

    @Override
    public String setColor(String color) {
        this.color = color;
        return color;
    }
}
