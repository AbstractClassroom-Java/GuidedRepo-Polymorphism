package io.github.nathanjrussell;

import io.github.nathanjrussell.shapes.Shape;
import io.github.nathanjrussell.shapes.twod.TwoDShape;
import io.github.nathanjrussell.shapes.twod.nonpolygons.Circle;
import io.github.nathanjrussell.shapes.twod.polygons.Polygon;
import io.github.nathanjrussell.shapes.twod.polygons.Rectangle;
import io.github.nathanjrussell.shapes.twod.polygons.Square;

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

        Polygon typedAsPolygon = new Square(10.0);
        System.out.println(typedAsPolygon.area());
        System.out.println(typedAsPolygon.perimeter());
        System.out.println(typedAsPolygon.numSides());

        Polygon notASquare = new Rectangle(2.0, 7.0);
        try {
            Square castedSquare = (Square) notASquare;
            System.out.println(castedSquare.side());
        } catch (ClassCastException e) {
            System.out.println("Tried to treat a Rectangle as a Square, but it wasn't a Square at runtime.");
        }

        ArrayList<TwoDShape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(square);

        for (TwoDShape shape : shapes) {
            System.out.println(shape.area());
            System.out.println(shape.perimeter());
        }

        ArrayList<Shape> allShapes = new ArrayList<>();
        allShapes.add(circle);
        allShapes.add(rectangle);
        allShapes.add(square);

        // Enhanced for-loop over a list of the more general type (Shape).
        // We check `instanceof TwoDShape` because only 2D shapes have area/perimeter.
        for (Shape shape : allShapes) {
            if (shape instanceof TwoDShape) {
                TwoDShape twoDShape = (TwoDShape) shape;
                System.out.println(twoDShape.area());
                System.out.println(twoDShape.perimeter());
                if (twoDShape instanceof Polygon) {
                    Polygon polygon = (Polygon) twoDShape;
                    System.out.println(polygon.numSides());
                }
            }
        }
    }
}