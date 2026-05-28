package io.github.nathanjrussell;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

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

    public static void main(String[] args) {

        double radius = 5.5;
        System.out.println(circleArea(radius));
        System.out.println(circleCircumference(radius));
        System.out.println(circlePerimeter(radius));
        System.out.println(circleDiameter(radius));

        double width = 4.0;
        double height = 6.0;
        System.out.println(getRectangleArea(width, height));
        System.out.println(getRectanglePerimeter(width, height));
        double side = 3.0;
        System.out.println(getSquareArea(side));
        System.out.println(getSquarePerimeter(side));
    }
}