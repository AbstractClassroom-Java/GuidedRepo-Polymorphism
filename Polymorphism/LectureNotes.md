# Polymorphism (Guided Repo)

## Version context

- **Current version:** `v0.2.0`

## Prior Version Context

- **Previous version:** `v0.1.0` (starting point)
- **What it did:** `Main` contained both the program entry point *and* a collection of geometry helper methods.
- **Why change:** `Main` was doing two jobs, which hurt readability.

---

## What the code looks like right now (v0.2.0)

Open these files:

- `src/main/java/io/github/nathanjrussell/Main.java`
- `src/main/java/io/github/nathanjrussell/ShapeUtility.java`

### What changed from v0.1.0

We created a `ShapeUtility` class and moved the geometry functions into it.

- The methods are still **pure functions** (they rely only on their input parameters).
- The methods are now **static utility methods**, grouped by purpose.
- `Main` is now focused on being the entry point and printing results.

This is a small but important refactor:

- it reduces clutter in `Main`
- it makes it obvious which code is “business logic” vs “math helpers”
- it prepares us for the next big step: **encapsulation**

---

## Why are the methods `static`?

In Java, the `static` keyword means the method belongs to the **class itself**, not to a specific object (instance).

That’s why you call these methods like this:

- `ShapeUtility.circleArea(radius)`

…and not like this:

- `new ShapeUtility().circleArea(radius)`

### Why that makes sense *in this version*

All the methods in `ShapeUtility` are static because:

1. **There’s no object state to store**
   - `ShapeUtility` doesn’t need fields like `radius`, `width`, `height`, etc.
   - Every result is computed entirely from the parameters passed in.

2. **They’re intentionally pure functions**
   - A pure function doesn’t depend on `this`.
   - Making them `static` communicates: “this method doesn’t use instance data.”

3. **It makes the call sites simple**
   - From `Main`, you can directly call the math you need without creating objects.

4. **It clarifies responsibility**
   - `Main` runs the program.
   - `ShapeUtility` holds reusable math.

### The tradeoff

Static utility methods are a good *organizational step*, but they aren’t yet object-oriented design:

- The data (`radius`, `width`, `height`, `side`) still lives outside the behavior.
- You can’t treat different shapes as a single “thing” (no `Shape` type yet).

That’s exactly why the next step is moving to objects.

---

### A pattern worth noticing

Even after the refactor, you should still notice the design pressure:

- circle calculations repeatedly use `radius`
- rectangle calculations repeatedly use `width` and `height`
- square calculations repeatedly use `side`

That repetition hints that **the data wants to live with the behavior**.

---

## Next step (preview of the next lecture)

In the next lecture/checkpoint, we’ll start moving away from utilities and toward objects:

- Introduce shape classes like `Circle`, `Rectangle`, `Square`.
- Each class will store its own state (ex: a `Circle` stores `radius`).
- We’ll move methods like `area()` / `perimeter()` onto those objects.

This will be our first real step toward **polymorphism**, where we can treat many different shapes through one common type.
