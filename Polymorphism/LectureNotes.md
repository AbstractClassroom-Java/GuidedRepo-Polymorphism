# Polymorphism (Guided Repo)

## Version context

- **Current version:** `v0.3.0`

## Prior Version Context

- **Previous version:** `v0.2.0`
- **What it did:** introduced the `ShapeUtility` class to compute area and perimeter for all shapes.
- **What it was missing:** the idea that each shape should be responsible for its own area and perimeter calculations. The `ShapeUtility` class was a procedural approach that didn't leverage object-oriented principles.

---

## What the code looks like right now (v0.3.0)

Open these files:

- `src/main/java/io/github/nathanjrussell/Circle.java`
- `src/main/java/io/github/nathanjrussell/Rectangle.java`
- `src/main/java/io/github/nathanjrussell/Square.java`
- `src/main/java/io/github/nathanjrussell/Main.java`

### What changed from v0.2.0

- Shape math is now implemented directly inside each shape class.
- There is no `ShapeUtility`-style helper being used.

This keeps the focus on the core idea:

- each object owns its data
- each object computes results using its own data

### What `Main` does now

`Main` creates each shape and calls instance methods:

- `circle.area()`, `circle.perimeter()`
- `rectangle.area()`, `rectangle.perimeter()`
- `square.area()`, `square.perimeter()`



---

## Next step (preview of the next lecture)

Next, we’ll use the fact that “a square is a special case of a rectangle” to explore reuse. We’ll see how to use inheritance to avoid duplicating code between `Rectangle` and `Square`.