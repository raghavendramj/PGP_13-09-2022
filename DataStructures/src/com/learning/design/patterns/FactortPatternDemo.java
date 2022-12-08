package com.learning.design.patterns;


//Factory Pattern
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("This is from Circle!");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("This is from Rectangle!");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("This is from Square!");
    }
}

class ShapeFactory {
    public Shape getShape(String shapeType) {

        Shape currentShape;
        switch (shapeType) {
            case "circle":
                currentShape = new Circle();
                break;
            case "rectangle":
                currentShape = new Rectangle();
                break;
            case "square":
                currentShape = new Square();
                break;
            default:
                currentShape = null;
                break;
        }
        return currentShape;
    }
}

//Client
public class FactortPatternDemo {

    public static void main(String[] args) {

        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.getShape("circle");
        Shape rectangle = factory.getShape("rectangle");
        Shape square = factory.getShape("square");

        circle.draw();
        rectangle.draw();
        square.draw();
    }
}
