package com.example.springplayground;

public class Calculate {
    private String operation;
    private String x;
    private String y;

    public String getOperation() {

        return operation;
    }

    public Calculate(String operation) {
        if (operation == null) this.operation = "add";
        else this.operation = operation;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public Calculate setX(String x) {
        this.x = x;
        return this;
    }

    public Calculate setY(String y) {
        this.y = y;
        return this;
    }
}
