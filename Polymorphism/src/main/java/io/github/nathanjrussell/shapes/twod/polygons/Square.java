package io.github.nathanjrussell.shapes.twod.polygons;

public class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    public double side() {
        return width();
    }
}
