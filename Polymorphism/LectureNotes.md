# Polymorphism (Guided Repo)

## Version context

- **Current version:** `v0.3.1`

## Prior Version Context

- **Previous version:** `v0.3.0`
- **What it did:** introduced `Circle`, `Rectangle`, and `Square` with `area()` and `perimeter()` instance methods.
- **Why change:** we’re simplifying the repo so it focuses on object encapsulation without introducing utility/helper classes.

---

## What the code looks like right now (v0.3.1)

Open these files:

- `src/main/java/io/github/nathanjrussell/Circle.java`
- `src/main/java/io/github/nathanjrussell/Rectangle.java`
- `src/main/java/io/github/nathanjrussell/Square.java`
- `src/main/java/io/github/nathanjrussell/Main.java`

### What changed from v0.3.0

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