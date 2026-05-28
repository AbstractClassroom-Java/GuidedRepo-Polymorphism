# Polymorphism (Guided Repo)

## Version context

- **Current version:** `v0.7.0`

## Prior Version Context

- **Previous version:** `v0.6.0`
- **What it did:** introduced `TwoDShape` as an abstract class with abstract `area()` and `perimeter()` methods.
- **Why change:** as we add more shapes, we want (1) better reuse (Circle is a special Ellipse) and (2) better organization (polygons vs non-polygons).

---

## What the code looks like right now (v0.7.0)

Open:

- `src/main/java/io/github/nathanjrussell/shapes/Shape.java`
- `src/main/java/io/github/nathanjrussell/shapes/twod/TwoDShape.java`

Polygons:

- `src/main/java/io/github/nathanjrussell/shapes/twod/polygons/Polygon.java`
- `src/main/java/io/github/nathanjrussell/shapes/twod/polygons/Rectangle.java`
- `src/main/java/io/github/nathanjrussell/shapes/twod/polygons/Square.java`

Non-polygons:

- `src/main/java/io/github/nathanjrussell/shapes/twod/nonpolygons/NonPolygon.java`
- `src/main/java/io/github/nathanjrussell/shapes/twod/nonpolygons/Ellipse.java`
- `src/main/java/io/github/nathanjrussell/shapes/twod/nonpolygons/Circle.java`

And the demo:

- `src/main/java/io/github/nathanjrussell/Main.java`

---

## New/updated hierarchy

We now have an abstract class “spine” for shapes:

- `Shape` (abstract)
  - `TwoDShape` (abstract)
    - `Polygon` (abstract)
      - `Rectangle`
        - `Square`
    - `NonPolygon` (abstract)
      - `Ellipse`
        - `Circle`

The key idea is that each level adds structure and meaning.

---

## Circle is a special Ellipse

A circle can be modeled as an ellipse where the two radii are equal.

So in this version:

- `Circle extends Ellipse`

That allows `Circle` to reuse:

- the ellipse area formula
- the ellipse perimeter approximation

While still providing a circle-specific method:

- `radius()`

---

## Packages for organization (polygons vs non-polygons)

We split 2D shapes into subpackages:

- `io.github.nathanjrussell.shapes.twod.polygons`
- `io.github.nathanjrussell.shapes.twod.nonpolygons`

This keeps the directory structure aligned with the design.

---

## Polymorphism with `ArrayList<TwoDShape>`

Because everything ultimately extends `TwoDShape`, `Main` can build a single list:

- `ArrayList<TwoDShape>`

Then it can loop and safely call only what’s guaranteed by the `TwoDShape` type:

- `area()`
- `perimeter()`

Any more specific method (like `numSides`) would require a more specific reference type or a downcast.  Notice the nested if statement further refining twoDShape to Polygon to ensure it’s safe to call `numSides()`.

---

## Next step (preview of the next lecture)

As this hierarchy grows, notice something important:

- many of these abstract classes don’t provide default behavior
- they mainly exist to require certain methods and create a “type label” in the hierarchy

When a type exists primarily to define a contract (and not shared code/state), it may be a better fit for an **interface**.

Next version, we’ll discuss:

- when an abstract class is the right tool
- when an interface is the right tool
- how to mix them responsibly
