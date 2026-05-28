# Polymorphism (Guided Repo)

## Version context

- **Current version:** `v0.1.0`

## Prior Version Context
- **Previous version:** N/A (this is the starting point)

## What the code looks like right now (v0.1.0)

Open `src/main/java/io/github/nathanjrussell/Main.java`.

You’ll notice `Main` contains what *looks like* a pile of geometry utility functions:

- circle math: `circleArea(radius)`, `circlePerimeter(radius)`, etc.
- rectangle math: `getRectangleArea(width, height)`, `getRectanglePerimeter(width, height)`, etc.
- square math: `getSquareArea(side)`, `getSquarePerimeter(side)`, etc.

### A pattern worth noticing

Many of these functions:

- **reuse the same parameter(s)** (ex: multiple circle functions all take `radius`)
- **pure functions** (they rely only on their input parameters and return a result)

Pure functions are great for correctness and testing, but the way they’re currently organized is bad for readability and maintainability:

- `Main` is doing two jobs:
  1. being the program entry point (`public static void main`)
  2. being a general-purpose math library

That makes `Main` harder to read and maintain.

---

## Next step (preview of the next lecture)

In the next lecture/checkpoint, we’ll do a small refactor:

- Create a `ShapeUtility` class.
- Move the existing geometry methods out of `Main`.
- Keep them as `static` methods (still pure).

This change won’t introduce polymorphism yet.  It’s just a small organizational refactor to:

- clean up `Main`
- centralize shape math in one place
- set us up nicely to later **encapsulate data + behavior** into classes like `Circle`, `Rectangle`, etc.

---
