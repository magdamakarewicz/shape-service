package com.enjoythecode.shapeservice.service;

import com.enjoythecode.shapeservice.exception.ShapeNotFoundException;
import com.enjoythecode.shapeservice.model.Shape;

import java.util.*;

public class ShapeService {

    public Shape findShapeWithLargestArea(List<Shape> shapes) throws ShapeNotFoundException {
        return Optional.ofNullable(shapes)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(Shape::calculateArea))
                .orElseThrow(() -> new ShapeNotFoundException("No shape found"));
    }

}