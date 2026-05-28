package io.github.nathanjrussell;

public final class ShapeUtility {

    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double circleCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double circlePerimeter(double radius) {
        return circleCircumference(radius);
    }

    public static double circleDiameter(double radius) {
        return 2 * radius;
    }

    public static double getRectangleArea(double width, double height) {
        return width * height;
    }

    public static double getRectanglePerimeter(double width, double height) {
        return 2 * (width + height);
    }

    public static double getSquareArea(double side) {
        return side * side;
    }

    public static double getSquarePerimeter(double side) {
        return getRectanglePerimeter(side, side);
    }
}
