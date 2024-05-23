package com.enjoythecode.shapeservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Square extends Shape {

    private double side;

    public Square(double side) {
        super("square");
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    public double calculatePerimeter() {
        return 0;
    }

}
