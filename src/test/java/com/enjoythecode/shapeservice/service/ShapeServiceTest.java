package com.enjoythecode.shapeservice.service;

import com.enjoythecode.shapeservice.exception.ShapeNotFoundException;
import com.enjoythecode.shapeservice.model.Circle;
import com.enjoythecode.shapeservice.model.Rectangle;
import com.enjoythecode.shapeservice.model.Shape;
import com.enjoythecode.shapeservice.model.ShapeFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShapeServiceTest {

    ShapeFactory shapeFactory;
    ShapeService shapeService;
    List<Shape> shapeListForTest;

    @BeforeEach
    public void init() {
        shapeFactory = new ShapeFactory();
        shapeService = new ShapeService();

        shapeListForTest = new ArrayList<>();
        shapeListForTest.add(shapeFactory.createSquare(2));
        shapeListForTest.add(shapeFactory.createSquare(4));
        shapeListForTest.add(shapeFactory.createRectangle(4, 1));
        shapeListForTest.add(shapeFactory.createRectangle(4, 2));
        shapeListForTest.add(shapeFactory.createRectangle(2, 1));
        shapeListForTest.add(null);
    }

    @Test
    public void shouldReturnSquareWithSide4() throws ShapeNotFoundException {
        //when
        Shape shapeWithLargestArea = shapeService.findShapeWithLargestArea(shapeListForTest);

        //then
        assertSame(shapeListForTest.get(1), shapeWithLargestArea);
    }

    @Test
    public void shouldReturnRectangleWithWidth4AndHeight2() throws ShapeNotFoundException {
        //when
        Shape shapeWithLargestPerimeterByType =
                shapeService.findShapeWithLargestPerimeterByType(shapeListForTest, Rectangle.class);

        //then
        assertSame(shapeListForTest.get(3), shapeWithLargestPerimeterByType);
    }

    @Test
    public void shouldThrowShapeNotFoundExceptionWhenListIsNullForLargestAreaMethod() {
        //given
        List<Shape> shapeListForTest = null;

        //when
        Exception e = assertThrows(ShapeNotFoundException.class,
                () -> shapeService.findShapeWithLargestArea(shapeListForTest));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(ShapeNotFoundException.class);
        sa.assertThat(e).hasMessage("No shape found");
        sa.assertThat(e).hasNoCause();
        sa.assertAll();
    }

    @Test
    public void shouldThrowShapeNotFoundExceptionWhenListIsEmptyForLargestAreaMethod() {
        //given
        List<Shape> shapeListForTest = new ArrayList<>();

        //when
        Exception e = assertThrows(ShapeNotFoundException.class,
                () -> shapeService.findShapeWithLargestArea(shapeListForTest));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(ShapeNotFoundException.class);
        sa.assertThat(e).hasMessage("No shape found");
        sa.assertThat(e).hasNoCause();
        sa.assertAll();
    }

    @Test
    public void shouldThrowShapeNotFoundExceptionWhenListIsNullForLargestPerimeterMethod() {
        //given
        List<Shape> shapeListForTest = null;
        Class<? extends Shape> shapeTypeForTest = Rectangle.class;

        //when
        Exception e = assertThrows(ShapeNotFoundException.class,
                () -> shapeService.findShapeWithLargestPerimeterByType(shapeListForTest, shapeTypeForTest));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(ShapeNotFoundException.class);
        sa.assertThat(e).hasMessage("No shape found");
        sa.assertThat(e).hasNoCause();
        sa.assertAll();
    }

    @Test
    public void shouldThrowShapeNotFoundExceptionWhenListIsEmptyForLargestPerimeterMethod() {
        //given
        List<Shape> shapeListForTest = new ArrayList<>();
        Class<? extends Shape> shapeTypeForTest = Rectangle.class;

        //when
        Exception e = assertThrows(ShapeNotFoundException.class,
                () -> shapeService.findShapeWithLargestPerimeterByType(shapeListForTest, shapeTypeForTest));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(ShapeNotFoundException.class);
        sa.assertThat(e).hasMessage("No shape found");
        sa.assertThat(e).hasNoCause();
        sa.assertAll();
    }

    @Test
    public void shouldThrowShapeNotFoundExceptionWhenNoCircleTypeOnListForLargestPerimeterMethod() {
        //given
        Class<? extends Shape> shapeTypeForTest = Circle.class;

        //when
        Exception e = assertThrows(ShapeNotFoundException.class,
                () -> shapeService.findShapeWithLargestPerimeterByType(shapeListForTest, shapeTypeForTest));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(ShapeNotFoundException.class);
        sa.assertThat(e).hasMessage("No shape found");
        sa.assertThat(e).hasNoCause();
        sa.assertAll();
    }

}