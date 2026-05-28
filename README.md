# GuidedRepo: Polymorphism (Java)

This guided repo is a versioned walkthrough of core object-oriented ideas in Java:

- pure functions vs objects
- encapsulation (data + behavior)
- inheritance and `super(...)`
- packages for organization
- polymorphism via common types
- abstract classes vs interfaces

The runnable Maven project lives in `Polymorphism/`.

- Main lecture notes (in-repo): `Polymorphism/LectureNotes.md`
- Code: `Polymorphism/src/main/java/...`

---

## How to use this repo

Each checkpoint/version is meant to be viewed via git history (checkout a tag/commit, read the notes, run the code).

Suggested loop:

1. Checkout a version (ex: `git checkout v0.1.0`).
2. Read `LectureNotes.md` (found Polymorphism/LectureNotes.md)
3. Open the referenced files.
4. Run `Main` and observe output.

---

## Version List

This repo has the following versions:
- v0.1.0
- v0.2.0
- v0.3.0
- v0.4.0
- v0.5.0
- v0.5.1
- v0.6.0
- v0.7.0
- v0.8.0

## Version Log (high level)

Below is the intended progression. Each step lists *what changed* and *why it matters*.

#### `v0.1.0` — Starting point: procedural pure functions in `Main` class

- `Main` contains many “utility-like” geometry methods.
- Functions are largely **pure** (depend only on parameters).

**Motivation:** it works, but `Main` is doing too much and the design doesn’t scale.

#### `v0.2.0` — Extract helper functions to a utility class

- Geometry helpers move into a dedicated utility class.
- Methods remain `static` and pure.

**Motivation:** improve organization and readability before moving to objects.

#### `v0.3.0` — Encapsulation: create concrete shape classes

- Introduce concrete classes 
    * `Rectangle`
    * `Circle`
    * `Square`
- Each class has fields for dimensions and methods for `area()` and `perimeter()`.

**Motivation:** start placing behavior where it belongs: *on the object*.

#### `v0.4.0` — Inheritance: `Square extends Rectangle`

- Model “a square is a special rectangle”.
- Discuss constructor chaining and `super(...)` (must be first statement).

**Motivation:** reuse implementation and introduce class inheritance tradeoffs.

#### `v0.5.0` — Packages: group 2D shapes

- Introduce a package for 2D shapes.
- Reinforce that package names mirror directory structure.
- Every moved class must declare its `package` at the top.

**Motivation:** organization and scope management as the project grows.

#### `v0.5.1` — Reference type vs runtime type

- Demonstrate upcasting (child object typed as parent).
- Show compile-time method visibility depends on the *declared* type.
- Demonstrate downcasting and `ClassCastException`.

**Motivation:** understand the mechanics that power polymorphism.

#### `v0.6.0` — Abstract class: shared 2D contract

- Add `TwoDShape` as an abstract base type with abstract `area()` / `perimeter()`.
- Use collections like `ArrayList<TwoDShape>` to treat many shapes uniformly.

**Motivation:** enforce common behavior and enable polymorphic loops.

#### `v0.7.0` — Richer hierarchy + reuse: Ellipse, polygons vs non-polygons

- Add `Ellipse`, and model `Circle` as a special ellipse.
- Split shapes into polygon vs non-polygon packages.
- Add a more descriptive type hierarchy.

**Motivation:** taxonomy and reuse patterns that feel more like “real” OO systems.

#### `v0.8.0` — Interfaces: contracts without shared implementation (final versioned step)

- Replace several contract-only abstract classes with interfaces.
- Reinforce that:
  - interfaces can type objects (`List<TwoDShape> ...`)
  - interfaces can extend other interfaces
- Discuss when to choose an abstract class vs an interface.

**Motivation:** when you’re defining *requirements* (not shared state/behavior), interfaces are often the cleanest tool.

> **This is the last versioned change** in the guided repo. After `v0.8.0`, the goal is practice and extension.

---

## After the guided steps (practice ideas)

- Add a new polygon (ex: `RightTriangle`) and update as little code as possible.
- Add output formatting (`toString`) for shapes.
- Add unit tests for `area()` and `perimeter()`.
- Explore when composition beats inheritance.
- Add 3D shapes (ex: `Sphere`, `Cube`) and a new abstract type (`ThreeDShape`).

## Review Comments

- **Polymorphism** is the ability to treat different types uniformly via a common contract.
- **Abstract classes** can provide shared state and behavior.
- **Interfaces** are pure contracts (no state, no implementation) that can be implemented by any class. Interfaces can extend other interfaces, but they can’t extend classes.
- The choice between abstract class vs interface depends on whether you need shared state/behavior (abstract class) or just a contract (interface).
- In Java, a class can only extend one parent class (abstract or concrete), but it can implement multiple interfaces. This allows for more flexible type hierarchies when using interfaces.
- When you have a reference of a parent type (abstract class or interface), you can only call methods defined in that parent type, even if the actual object is a child type with more methods. This is because the compiler checks method availability based on the reference type, not the runtime type.
- Upcasting is when you assign a child object to a parent reference (ex: `TwoDShape shape = new Circle(...)`). This is implicit and safe. 
- Downcasting is when you try to cast a parent reference back to a child type (ex: `Circle circle = (Circle) shape`). This can throw a `ClassCastException` if the actual object isn’t of the expected child type. Always check with `instanceof` before downcasting to avoid exceptions.
- Using interfaces allows for more flexible and decoupled designs, as classes can implement multiple interfaces and aren’t tied to a specific class hierarchy. Abstract classes are better when you want to share code and state, but they limit you to single inheritance.