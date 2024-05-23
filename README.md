# Shape Service

## Overview
This project is a Java service for managing geometric shapes. It supports various operations like calculating the area and perimeter of different shapes, finding shapes with the largest area or perimeter, and importing/exporting shapes to/from JSON.

## Features
- Calculate area and perimeter of shapes (Square, Circle, Rectangle)
- Find the shape with the largest area
- Find the shape with the largest perimeter of a specific type
- Export shapes to JSON
- Import shapes from JSON
- Shape creation through a factory with caching

## Setup and Running the Project

### Prerequisites
- Java 11 or higher
- Maven 3.6.3 or higher

### Building the Project
To build the project, run the following command:
mvn clean install

### Running Tests and Code Coverage
JaCoCo is used for code coverage. To run the tests and generate a JaCoCo code coverage report, use:
mvn test
The report will be available in target/site/jacoco/index.html.

## Usage

### Running the Main Class
To run the `Main` class, execute the following command in the root of Maven project:
mvn exec:java -Dexec.mainClass="com.enjoythecode.shapeservice.app.Main"