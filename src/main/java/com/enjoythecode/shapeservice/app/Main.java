package com.enjoythecode.shapeservice.app;

import com.enjoythecode.shapeservice.model.ShapeFactory;
import com.enjoythecode.shapeservice.model.Square;

public class Main {
    public static void main(String[] args) {

        //Initialize the ShapeFactory
        ShapeFactory shapeFactory = new ShapeFactory();

        //Create shapes using the ShapeFactory
        Square sq1 = shapeFactory.createSquare(10);
        Square sq2 = shapeFactory.createSquare(10);

        //Verify that the cache is working (sq1 and sq2 should be the same instance)
        System.out.println("(sq1 == sq2) = " + (sq1 == sq2));

    }
}