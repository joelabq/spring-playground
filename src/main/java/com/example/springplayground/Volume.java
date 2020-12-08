package com.example.springplayground;

public class Volume {
    private int length;
    private int width;
    private int height;

    public int getLength() {
        return length;
    }

    public Volume setLength(int length) {
        this.length = length;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public Volume setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Volume setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getVolume() {
        return this.length*this.width*this.height;
    }
}
