package io.github.nathanjrussell;

import io.github.nathanjrussell.shapes.twod.Circle;
import io.github.nathanjrussell.shapes.twod.Rectangle;
import io.github.nathanjrussell.shapes.twod.Square;
import io.github.nathanjrussell.shapes.twod.TwoDShape;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Circle circle = new Circle(5.5);
        System.out.println(circle.area());
        System.out.println(circle.perimeter());

        Rectangle rectangle = new Rectangle(4.0, 6.0);
        System.out.println(rectangle.area());
        System.out.println(rectangle.perimeter());

        Square square = new Square(3.0);
        System.out.println(square.area());
        System.out.println(square.perimeter());
        System.out.println(square.side());

        Rectangle typedAsRectangle = new Square(10.0);
        System.out.println(typedAsRectangle.area());
        System.out.println(typedAsRectangle.perimeter());
        System.out.println(((Square) typedAsRectangle).side());

        Rectangle notASquare = new Rectangle(2.0, 7.0);
        try {
            Square castedSquare = (Square) notASquare;
            System.out.println(castedSquare.side());
        } catch (ClassCastException e) {
            System.out.println("Tried to treat a Rectangle as a Square, but it wasn't a Square at runtime.");
        }

        ArrayList<TwoDShape> shapes = new ArrayList<>();
        shapes.add(new Circle(1.0));
        shapes.add(new Rectangle(2.0, 3.0));
        shapes.add(new Square(4.0));

        for (TwoDShape shape : shapes) {
            System.out.println("Area: " + shape.area());
            System.out.println("Perimeter: " + shape.perimeter());
        }
    }
}