package io.github.nathanjrussell.shapes.twod.nonpolygons;

public class Circle implements NonPolygon {

    private final double radius;
    private final Ellipse ellipse;

    public Circle(double radius) {
        this.radius = radius;
        this.ellipse = new Ellipse(radius, radius);
    }

    public double radius() {
        return radius;
    }

    @Override
    public double area() {
        return ellipse.area();
    }

    @Override
    public double perimeter() {
        return ellipse.perimeter();
    }
}
