package io.github.nathanjrussell.shapes.twod;

public class Circle {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double radius() {
        return radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
