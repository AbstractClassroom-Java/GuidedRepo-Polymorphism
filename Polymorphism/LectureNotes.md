# Polymorphism (Guided Repo)

## Version context

- **Current version:** `v0.4.0`

## Prior Version Context

- **Previous version:** `v0.3.0`
- **What it did:** introduced `Circle`, `Rectangle`, and `Square` as separate classes, each responsible for its own calculations.
- **What it was missing:** reuse between related types (a square is a special kind of rectangle).

---

## What the code looks like right now (v0.4.0)

Open these files:

- `src/main/java/io/github/nathanjrussell/Rectangle.java`
- `src/main/java/io/github/nathanjrussell/Square.java`
- `src/main/java/io/github/nathanjrussell/Main.java`

### What changed from v0.3.0

We refactored `Square` to **extend** `Rectangle`.

That means:

- `Square` now *inherits* `area()` and `perimeter()` from `Rectangle`.
- `Square` no longer needs its own `side` field.
- We removed duplicated formula code.

So instead of “Square re-implementing rectangle logic”, we model the relationship directly:

- a square **is a** rectangle where `width == height`.

---

## Inheritance and `super`

### What does `extends` mean?

When you write:

- `class Square extends Rectangle`

You are saying:

- `Square` is a **subclass** (child type)
- `Rectangle` is a **superclass** (parent type)

A `Square` automatically gets access to the public methods of `Rectangle`.

### The `super(...)` constructor call

In `Square(double side)`, we call:

- `super(side, side)`

That runs the `Rectangle` constructor to set up the rectangle state (width/height).

#### Important rule

In Java, a constructor’s call to `super(...)` must be the **first statement** in the constructor.

Why?

- the parent part of the object must be initialized before the child can safely do more work

If you don’t write `super(...)`, Java will try to insert `super()` automatically.
That only works if the superclass has a no-argument constructor.

---

## Why this refactor helps

- Less duplicated code.
- Clearer relationship between shapes.
- Lets us talk about reuse, coupling, and modeling decisions.

At the same time, inheritance introduces new design questions:

- What behaviors should be inherited?
- Can every `Square` be used anywhere a `Rectangle` is expected?
- What happens if rectangles later gain setters like `setWidth()` and `setHeight()`?

We’ll keep those questions in mind as we continue.

---

## Next step (preview of the next lecture)

We now have several classes that are clearly **2D shapes** (`Circle`, `Rectangle`, `Square`).

Next we’ll create a package (folder) for them, for example:

- `io.github.nathanjrussell.shapes.twod`

Purpose:

- improve organization
- reduce clutter in the root package
- use packages/directories as a kind of “encapsulation boundary” to help manage scope as the project grows
