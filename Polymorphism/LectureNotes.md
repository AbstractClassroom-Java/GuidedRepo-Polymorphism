# Polymorphism (Guided Repo)

## Version context

- **Current version:** `v0.6.0`

## Prior Version Context

- **Previous version:** `v0.5.1`
- **What it did:** demonstrated upcasting/downcasting with `Square` and `Rectangle`, showing that the reference type controls which methods are visible, and that unsafe downcasts can throw `ClassCastException`.
- **Why change:** all of our 2D shapes share common behaviors (`area`, `perimeter`), so we want a shared parent type that enforces that contract.

---

## What the code looks like right now (v0.6.0)

Open:

- `src/main/java/io/github/nathanjrussell/shapes/twod/TwoDShape.java`
- `src/main/java/io/github/nathanjrussell/shapes/twod/Circle.java`
- `src/main/java/io/github/nathanjrussell/shapes/twod/Rectangle.java`
- `src/main/java/io/github/nathanjrussell/shapes/twod/Square.java`

---

## New: `TwoDShape` (abstract class)

We added a single abstract base class for all 2D shapes:

- `TwoDShape`

### What an abstract class is

An **abstract class** is a class that:

- can have fields, constructors, and concrete methods (like a normal class)
- can also declare **abstract methods**
- cannot be instantiated directly

So this is not allowed:

- `new TwoDShape()`

But this is allowed:

- `class Rectangle extends TwoDShape { ... }`

### Abstract methods: `area()` and `perimeter()`

In `TwoDShape`, we declared:

- `public abstract double area();`
- `public abstract double perimeter();`

An **abstract method** has no body.
It’s a promise that every concrete subclass must provide an implementation.

That matches our domain perfectly:

- every 2D shape must be able to compute area
- every 2D shape must be able to compute perimeter

### What changed in the concrete shapes

- `Circle extends TwoDShape`
- `Rectangle extends TwoDShape`
- `Square extends Rectangle` (and still indirectly extends `TwoDShape`)

This sets up a single shared type so we can eventually write code like:

- `List<TwoDShape> shapes = ...;`

---

## Using `ArrayList<TwoDShape>` (polymorphism in a collection)

Now that we have a shared parent type, we can create a single list that holds multiple concrete shapes.

For example:

- `ArrayList<TwoDShape> shapes = new ArrayList<>();`

Then we can add any object that is-a `TwoDShape`:

- `shapes.add(new Circle(2.0));`
- `shapes.add(new Rectangle(4.0, 6.0));`
- `shapes.add(new Square(3.0));`

Why does this work?

- each of those classes **extends `TwoDShape`** (directly or indirectly)
- so Java can safely treat each of them as a `TwoDShape` when storing them in the list (upcasting)

### Important: the reference type controls what you can call

Inside a loop like:

- `for (TwoDShape shape : shapes) { ... }`

You can only call the methods guaranteed by the **declared type** (`TwoDShape`):

- `shape.area()`
- `shape.perimeter()`

You *cannot* call shape-specific methods without downcasting.
For example, this will not compile:

- `shape.radius()`
- `shape.width()`
- `shape.side()`

That’s a feature, not a bug:

- it keeps your loop generic
- and it’s exactly why putting shared behavior (`area`, `perimeter`) in the abstract parent class is so powerful

---

## Next step (preview of the next lecture)

Next iteration, we’ll expand the hierarchy and organization:

1. Add an `Ellipse` class
   - refactor `Circle` to extend `Ellipse`

2. Separate polygons from non-polygons
   - use packages to keep the taxonomy readable

3. Introduce a larger abstract class hierarchy
   - an abstract `Shape`
   - an abstract `TwoDShape`
   - an abstract `Polygon`
   - an abstract `NonPolygon`

This will make it easier to model new shapes while keeping code reuse and polymorphism clean.
