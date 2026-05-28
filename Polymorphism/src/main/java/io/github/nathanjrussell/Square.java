package io.github.nathanjrussell;

public class Square {

    private final double side;

    public Square(double side) {
        this.side = side;
    }

    public double side() {
        return side;
    }

    public double area() {
        return side * side;
    }

    public double perimeter() {
        return 4 * side;
    }
}
