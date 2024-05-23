package com.enjoythecode.shapeservice.app;

import com.enjoythecode.shapeservice.exception.ShapeNotFoundException;
import com.enjoythecode.shapeservice.model.*;
import com.enjoythecode.shapeservice.service.ShapeService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Initialize the ShapeFactory
        ShapeFactory shapeFactory = new ShapeFactory();

        // Initialize the ShapeService
        ShapeService shapeService = new ShapeService();

        //Create shapes using the ShapeFactory
        Square sq1 = shapeFactory.createSquare(10);
        Square sq2 = shapeFactory.createSquare(10);

        //Verify that the cache is working (sq1 and sq2 should be the same instance)
        System.out.println("(sq1 == sq2) = " + (sq1 == sq2));

        //Create more shapes
        Rectangle r1 = shapeFactory.createRectangle(8, 5);
        Rectangle r2 = shapeFactory.createRectangle(6, 5);
        Circle c1 = shapeFactory.createCircle(5);

        //Add shapes to a list
        List<Shape> shapeList = List.of(sq1, r1, r2, c1);
        //Print all shapes from the list
        shapeList.forEach(System.out::println);

        try {
            // Find and print the shape with the largest area
            System.out.println("Shape with largest area = " + shapeService.findShapeWithLargestArea(shapeList));
        } catch (ShapeNotFoundException e) {
            e.printStackTrace();
        }

    }
}