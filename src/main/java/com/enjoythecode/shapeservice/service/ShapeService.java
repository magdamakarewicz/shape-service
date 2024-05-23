package com.enjoythecode.shapeservice.service;

import com.enjoythecode.shapeservice.exception.ShapeNotFoundException;
import com.enjoythecode.shapeservice.exception.ShapeServiceException;
import com.enjoythecode.shapeservice.model.Shape;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
public class ShapeService {

    private ObjectMapper objectMapper;

    public Shape findShapeWithLargestArea(List<Shape> shapes) throws ShapeNotFoundException {
        return Optional.ofNullable(shapes)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(Shape::calculateArea))
                .orElseThrow(() -> new ShapeNotFoundException("No shape found"));
    }

    public Shape findShapeWithLargestPerimeterByType(List<Shape> shapes, Class<? extends Shape> shapeType)
            throws ShapeNotFoundException {
        return Optional.ofNullable(shapes)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getClass() == shapeType)
                .max(Comparator.comparingDouble(Shape::calculatePerimeter))
                .orElseThrow(() -> new ShapeNotFoundException("No shape found"));
    }

    public void exportShapesToJson(List<Shape> shapes, String filePath) throws ShapeServiceException {
        try (
                FileWriter fileWriter = new FileWriter(filePath)
        ) {
            objectMapper.writeValue(fileWriter, shapes);
        } catch (IOException e) {
            throw new ShapeServiceException("Failed to export shapes to JSON", e);
        }
    }

    public List<Shape> importShapesFromJson(String filePath) throws ShapeServiceException {
        try (
                FileReader fileReader = new FileReader(filePath)
        ) {
            return objectMapper.readValue(fileReader, new TypeReference<List<Shape>>() {
            });
        } catch (IOException e) {
            throw new ShapeServiceException("Failed to import shapes from JSON", e);
        }
    }

}