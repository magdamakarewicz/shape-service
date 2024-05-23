package com.enjoythecode.shapeservice.app;

import com.enjoythecode.shapeservice.exception.ShapeNotFoundException;
import com.enjoythecode.shapeservice.exception.ShapeServiceException;
import com.enjoythecode.shapeservice.model.*;
import com.enjoythecode.shapeservice.service.ShapeService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Initialize the ShapeFactory
        ShapeFactory shapeFactory = new ShapeFactory();

        // Configure ObjectMapper for JSON processing
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Initialize the ShapeService with the configured ObjectMapper
        ShapeService shapeService = new ShapeService(objectMapper);

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
            //Find and print the shape with the largest area
            System.out.println("Shape with largest area = " + shapeService.findShapeWithLargestArea(shapeList));
            //Find and print the shape with the largest perimeter of type Rectangle
            System.out.println("Shape with largest perimeter (Rectangle) = "
                    + shapeService.findShapeWithLargestPerimeterByType(shapeList, Rectangle.class));
        } catch (ShapeNotFoundException e) {
            e.printStackTrace();
        }

        try {
        //Export the list of shapes to JSON
        shapeService.exportShapesToJson(shapeList, "src/main/resources/shapelist.json");
        //Import shapes from the JSON file
        List<Shape> importedShapeList = shapeService.importShapesFromJson("src/main/resources/shapelist.json");
        //Print all imported shapes from the list
        importedShapeList.forEach(System.out::println);

        //Verify that the original list and the imported list are the same
        System.out.println("(shapeList.equals(importedShapeList)) = " + (shapeList.equals(importedShapeList)));
        } catch (ShapeServiceException e) {
            e.printStackTrace();
        }


    }
}
