# Student Do: TDD in Teams

Starter folder: [starter/utility-api](./starter/utility-api)

Solved folder: [solved/utility-api](./solved/utility-api)

In this activity, you will work together with a partner to develop code via Test Driven Development.

In the case that there is an odd number of learners, one of the student groups can contain three members.

## Instructions

1. Open the starter project in IntelliJ.  This project contains the division code from the previous activity.

2. With Test Driven Development in mind, work together with your partner in back and forth fashion to create test cases and implementation code for the following:

    A) Determine if a given integer value is a "perfect square", which is the square value of an integer.  For example 49 (7 x 7) and 64 (8 x 8) are perfect squares, while integers such as 50, 51 and 52 are not.

    Use the following code as your starting point:

    ```java
    @RequestMapping(value = "/calculator/isperfectsquare/{value}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public boolean isperfectsquare(@PathVariable int value) {

        return false;
    }
    ```

    >HINT: the method `Math.sqrt()` and the modulus operator will help with this code.

    B) Given an integer, return its factorial value.  A factorial is the product of an integer and all of the positive integers less than that integer.  For example, the factorial of 4 is 12 (4 x 3 x 2 x 1), and the factorial of 5 is 60 (5 x 4 x 3 x 2 x 1).

    Use the following code as your starting point:

    ```java
    @RequestMapping(value = "/calculator/factorial/{value}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public int factorial(@PathVariable int value) {

        return 0;
    }
    ```

---

© 2023 2U. All Rights Reserved.
