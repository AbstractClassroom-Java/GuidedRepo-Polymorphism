package io.github.nathanjrussell.shapes.twod.polygons;

public class Square implements Polygon {

    private final double side;

    public Square(double side) {
        this.side = side;
    }

    public double side() {
        return side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }

    @Override
    public int numSides() {
        return 4;
    }
}
