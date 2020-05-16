package com.assignment3.wasteless.Decorator;

public abstract class ColorDecorator implements Color {

    protected Color decoratedColor;

    public ColorDecorator(Color decoratedColor) {
        this.decoratedColor = decoratedColor;
    }

    public String setColor(String color) {
        return decoratedColor.setColor(color);
    }
}
