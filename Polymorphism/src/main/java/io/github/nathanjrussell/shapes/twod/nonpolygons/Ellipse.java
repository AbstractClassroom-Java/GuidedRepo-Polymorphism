package io.github.nathanjrussell.shapes.twod.nonpolygons;

public class Ellipse implements NonPolygon {

    private final double a;
    private final double b;

    public Ellipse(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double a() {
        return a;
    }

    public double b() {
        return b;
    }

    @Override
    public double area() {
        return Math.PI * a * b;
    }

    @Override
    public double perimeter() {
        double h = Math.pow(a - b, 2) / Math.pow(a + b, 2);
        return Math.PI * (a + b) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }
}
