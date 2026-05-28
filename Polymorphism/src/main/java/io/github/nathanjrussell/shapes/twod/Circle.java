package io.github.nathanjrussell.shapes.twod;

public class Circle extends TwoDShape {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double radius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
