# Student Do: Testing Object Equality

**Starter & Solved Folders:** [02-stu-test-obj-equality](./)

In this exercise, you will use test-driven development in conjunction with object equality to create a `Breeder` class.

## Instructions

Write tests to satisfy the following requirements, then implement the code to pass the tests:

1. Using the `Dog` class from before, create a `Breeder` class with the following functionality:

   - The method `breedDogs` should take in two dogs and return a new dog.

   - The returned dog should have the following attributes:

      - Its age should be `0`.

      - Its color should be a concatenation of the parent dogs' colors. For example, if Dog 1 is `Brown` and Dog 2 is `Grey`, the new dog should be `BrownGrey`.

      - The new dog's favorite toy should be the `favToy` of the first parent dog. For example, if Dog 1 likes a `Rope`, and Dog 2 likes a `Ball`, the new dog should like a `Rope`.

---

© 2022 2U. All Rights Reserved.
