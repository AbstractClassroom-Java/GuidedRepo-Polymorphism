package io.github.nathanjrussell.shapes.twod.nonpolygons;

public class Circle extends Ellipse {

    public Circle(double radius) {
        super(radius, radius);
    }

    public double radius() {
        return a();
    }
}
