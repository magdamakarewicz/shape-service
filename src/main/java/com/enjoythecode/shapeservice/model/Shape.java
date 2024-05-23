package com.enjoythecode.shapeservice.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public abstract class Shape {

    private String type;

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

}
