package io.github.nathanjrussell;

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
    }
}