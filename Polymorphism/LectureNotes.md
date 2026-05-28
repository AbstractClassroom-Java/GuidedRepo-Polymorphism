# Polymorphism (Guided Repo)

## Version context

- **Current version:** `v0.8.0`

## Prior Version Context

- **Previous version:** `v0.7.0`
- **What it did:** built an abstract-class hierarchy (`Shape` → `TwoDShape` → `Polygon` / `NonPolygon`) and improved reuse/organization (Ellipse + packages).
- **Why change:** many of our abstract classes were acting mostly like “requirements” (contracts) without providing shared state or default behavior.

---

## What the code looks like right now (v0.8.0)

Open these types:

- `src/main/java/io/github/nathanjrussell/shapes/Shape.java`
- `src/main/java/io/github/nathanjrussell/shapes/twod/TwoDShape.java`
- `src/main/java/io/github/nathanjrussell/shapes/twod/polygons/Polygon.java`
- `src/main/java/io/github/nathanjrussell/shapes/twod/nonpolygons/NonPolygon.java`

And some implementations:

- `.../polygons/Rectangle.java`
- `.../polygons/Square.java`
- `.../nonpolygons/Ellipse.java`
- `.../nonpolygons/Circle.java`

---

## Refactor: abstract classes → interfaces

In this version, we replaced several abstract classes with **interfaces**:

- `Shape` is now an interface
- `TwoDShape` is now an interface
- `Polygon` is now an interface
- `NonPolygon` is now an interface

These interfaces form a type hierarchy:

- `TwoDShape extends Shape`
- `Polygon extends TwoDShape`
- `NonPolygon extends TwoDShape`

### Interfaces can type objects

Even though interfaces aren’t classes, you can still use them as variable types and collection element types.

For example, `Main` can use:

- `ArrayList<TwoDShape>`

…and store any object that implements `TwoDShape`.

### Interfaces can extend other interfaces

Just like classes can form an inheritance chain, interfaces can form a contract chain:

- `Polygon` is a `TwoDShape`
- so every polygon must also fulfill the `TwoDShape` contract (`area`, `perimeter`)

---

## When to use an abstract class vs an interface

### Abstract class is a good fit when:

- you need to share **state** (fields) across subclasses
- you want to provide **default behavior** (implemented methods)
- you want to enforce a common constructor story

### Interface is a good fit when:

- you mainly want to require a set of methods (a contract)
- you don’t need shared state or shared logic
- you want a type that a class can implement alongside other inheritance

In our shapes example, the “base types” were mostly contracts:

- “any 2D shape must have area/perimeter”
- “any polygon must report a number of sides”

That maps very naturally to interfaces.

---

## What changed in the concrete types

Because interfaces don’t provide constructor/field reuse, some relationships changed:

- `Rectangle implements Polygon`
- `Square implements Polygon` (instead of extending `Rectangle` here)
- `Ellipse implements NonPolygon`
- `Circle implements NonPolygon`

To keep reuse without class inheritance, `Circle` now reuses ellipse math via **composition** (it wraps an `Ellipse` internally).

---

## Final note: last versioned change

This is the last versioned change in this guided repo.

From here, the goal is practice:

- add new shapes
- decide when you want inheritance vs composition
- decide when you want interfaces vs abstract classes
- keep `Main` generic by programming to the interface (`TwoDShape`, `Polygon`, etc.)
