# Polymorphism (Guided Repo)

## Version context

- **Current version:** `v0.5.0`

## Prior Version Context

- **Previous version:** `v0.4.0`
- **What it did:** refactored `Square` to extend `Rectangle`, introducing inheritance and the `super(...)` constructor call.
- **Why change:** we now have multiple related classes that represent **2D shapes**, and we want the codebase to reflect that organization.

---

## What the code looks like right now (v0.5.0)

### New package for 2D shapes

The 2D shape classes now live in a dedicated package:

- `io.github.nathanjrussell.shapes.twod`

Files to open:

- `src/main/java/io/github/nathanjrussell/shapes/twod/Circle.java`
- `src/main/java/io/github/nathanjrussell/shapes/twod/Rectangle.java`
- `src/main/java/io/github/nathanjrussell/shapes/twod/Square.java`

And the entry point:

- `src/main/java/io/github/nathanjrussell/Main.java`

---

## Packages in Java (directories + namespaces)

A Java **package** is mainly a *namespace*.

In practice, it’s also reflected by directories:

- package `io.github.nathanjrussell.shapes.twod`
- directory `io/github/nathanjrussell/shapes/twod/`

This directory structure helps you organize code and (optionally) limit access using package-private scope.

### Every class must declare its package

When a class is inside a package, it must declare it at the top of the file:

- `package io.github.nathanjrussell.shapes.twod;`

If the package declaration doesn’t match the folder structure, imports and compilation will break.

### Imports update

Because the shapes moved packages, `Main` now imports them:

- `import io.github.nathanjrussell.shapes.twod.Circle;`
- `import io.github.nathanjrussell.shapes.twod.Rectangle;`
- `import io.github.nathanjrussell.shapes.twod.Square;`

All three of the imports could be replaced with a single wildcard import:
- `import io.github.nathanjrussell.shapes.twod.*;`

However, it’s generally considered better practice to import specific classes rather than using wildcards, as it improves readability and helps avoid naming conflicts.

---

## A pattern worth noticing

All of our 2D shapes provide the same behaviors:

- `area()`
- `perimeter()`

Right now, each class defines those methods on its own (or inherits them).

This is pointing us toward a shared parent type.

---

## Next step (preview of the next lecture)

Next, we’ll create a shared base type for all 2D shapes:

- an **abstract class** that every 2D shape will extend

That abstract class will define the common “shape contract” (area/perimeter), while still preventing direct instantiation.

This is a key bridge toward full polymorphism later.
