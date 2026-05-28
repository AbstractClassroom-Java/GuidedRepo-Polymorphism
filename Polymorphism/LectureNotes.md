# Polymorphism (Guided Repo)

## Version context

- **Current version:** `v0.5.1`

## Prior Version Context

- **Previous version:** `v0.5.0`
- **What it did:** introduced a `io.github.nathanjrussell.shapes.twod` package to group the 2D shape classes and updated imports accordingly.
- **Why change:** now that inheritance exists (`Square extends Rectangle`), we can demonstrate how *reference type* affects which methods you can call.

---

## What the code looks like right now (v0.5.1)

Open:

- `src/main/java/io/github/nathanjrussell/shapes/twod/Rectangle.java`
- `src/main/java/io/github/nathanjrussell/shapes/twod/Square.java`
- `src/main/java/io/github/nathanjrussell/Main.java`

---

## Upcasting: a `Square` can be typed as a `Rectangle`

Because `Square extends Rectangle`, a `Square` **is a** `Rectangle`.

That means this is legal:

- `Rectangle typedAsRectangle = new Square(10.0);`

This is called **upcasting** (using a child object through a parent type).

### What you can call depends on the reference type

Even though the object is a `Square`, the variable is typed as `Rectangle`.

So:

- `typedAsRectangle.area()` works
- `typedAsRectangle.perimeter()` works

…but:

- `typedAsRectangle.side()` does **not** compile

Why?

- the compiler checks method availability based on the **declared type** (`Rectangle`)

This is one of the key ideas behind polymorphism: you can restrict what’s visible by choosing an appropriate supertype.

---

## Downcasting and runtime type checks

If you want to call `side()`, you need a variable typed as `Square`.

That sometimes leads people to do a **downcast**:

- `Square s = (Square) someRectangle;`

This compiles, but it’s only safe when the runtime object is *actually* a `Square`.

### What happens if it’s not really a `Square`?

If the runtime object is a plain `Rectangle`, Java throws a `ClassCastException`.

In `Main`, we demonstrate this and handle it:

- attempt to cast a `Rectangle` into a `Square`
- catch `ClassCastException` and print a message

---

## Segway: we need a shared 2D shape parent type

At this point, notice a pattern:

- `Circle`, `Rectangle`, and `Square` are all 2D shapes
- they all provide:
  - `area()`
  - `perimeter()`

But we still don’t have a single parent type that represents “any 2D shape”.

This is where an **abstract class** becomes useful.

---

## Abstract classes and abstract methods (what we’re building next)

### What is an abstract class?

An **abstract class** is a class that:

- can define fields and concrete methods (like normal)
- can define abstract methods (methods with no body)
- **cannot** be instantiated directly

So you can’t do:

- `new TwoDShape()`

…but you *can* do:

- `class Rectangle extends TwoDShape { ... }`

### Why use one here?

We want a single “2D shape” type that guarantees:

- every 2D shape has an `area()`
- every 2D shape has a `perimeter()`

Those are perfect candidates for **abstract methods**:

- `public abstract double area();`
- `public abstract double perimeter();`

Each concrete shape will be required to implement them.

This gives us a shared type for future code like:

- `List<TwoDShape> shapes = ...;`

---

## Next step (preview of the next lecture)

**Next step:** create an abstract class named `TwoDShape` in the 2D shapes package and refactor all 2D shapes to extend it.

- `TwoDShape` will declare `area()` and `perimeter()` as abstract methods.
- `Circle`, `Rectangle`, and `Square` will become subclasses of `TwoDShape`.

After that, we’ll be ready to grow the hierarchy further (Ellipse + polygon vs non-polygon) without losing organization.
