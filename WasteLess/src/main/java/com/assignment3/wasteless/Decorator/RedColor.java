package com.assignment3.wasteless.Decorator;

public class RedColor implements Color {

    String redColor;

    @Override
    public String setColor(String color) {
        this.redColor = color;
        return color;
    }
}
