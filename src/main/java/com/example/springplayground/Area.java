package com.example.springplayground;

public class Area {
    private String type;
    private int radius = 0;
    private int height = 0;
    private int width = 0;
    private float result = 0;

    public String getType() {
        return type;
    }

    public Area setType(String type) {
        this.type = type;
        return this;
    }

    public int getRadius() {
        return radius;
    }

    public Area setRadius(int radius) {
        this.radius = radius;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Area setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public Area setWidth(int width) {
        this.width = width;
        return this;
    }

    public float getResult() {
        return result;
    }

    public Area setResult(float result) {
        this.result = result;
        return this;
    }

    public String getCircleArea() {
        return String.format("%.5f",Math.PI * Math.pow(this.radius,2));

    }

    public String getRectArea() {
        return Integer.toString(this.height*this.width);
    }
}
