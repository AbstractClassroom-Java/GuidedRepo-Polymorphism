package io.github.nathanjrussell;

public class Main {

    public static void main(String[] args) {

        double radius = 5.5;
        System.out.println(ShapeUtility.circleArea(radius));
        System.out.println(ShapeUtility.circleCircumference(radius));
        System.out.println(ShapeUtility.circlePerimeter(radius));
        System.out.println(ShapeUtility.circleDiameter(radius));

        double width = 4.0;
        double height = 6.0;
        System.out.println(ShapeUtility.getRectangleArea(width, height));
        System.out.println(ShapeUtility.getRectanglePerimeter(width, height));

        double side = 3.0;
        System.out.println(ShapeUtility.getSquareArea(side));
        System.out.println(ShapeUtility.getSquarePerimeter(side));
    }
}