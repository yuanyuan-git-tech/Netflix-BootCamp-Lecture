# Methods

## 1. Methods

In this activity, you will practice creating and using methods in a Java program.

Follow along with the instructor throughout the exercise.

### 1.1 Instructions

1. Create a new `Command Line App` Java project named `methods`.

2. Create a new `add` method using the following code:

    ```java
    static int add(int x, int y) {
        return x + y;
    }
    ```

3. Add code to the `main` method to call the `add` function. The final code should resemble the following example:

    ```java
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = add(a, b);
        System.out.println(c);
    }
    ```

4. Next, add a new method to find the greater value of two `ints`, as follows:

    ```java
    static int greaterValue(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = add(a, b);
        System.out.println(c);
        int greaterValue = greaterValue(a, b);
        System.out.println(greaterValue);
    }
    ```

5. Next, make a new method for printing so that you don't need to type `System.out.println` so often&mdash;as shown in the following example:

    ```java
    static void println(String out) {
        System.out.println(out);
    }
    ```

6. Update `main` to the following:

    ```java
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = add(a, b);
        println("a + b:");
        println(c);

        int greaterValue = greaterValue(a, b);
        println("a > b:");
        println(greaterValue);
    }
    ```

7. Point out that `println(c)` now has a red line under `c` and `greaterValue`. IntelliJ is letting you know that there is an error here. The new `println` method expects a `String`, and you are passing an `int`.

    Update `main` to use `String.valueOf`. The final code should resemble the following:

    ```java
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = add(a, b);
        println("a + b:");
        println(String.valueOf(c));

        int greaterValue = greaterValue(a, b);
        println("a > b:");
        println(String.valueOf(greaterValue));
    }
    ```

8. Create an `add` method that adds two `floats`, as follows:

    ```java
    static float add(float x, float y) {
        return x + y;
    }
    ```

    And update the `main` method to call the new `add` method, as follows:

    ```java
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = add(a, b);
        println("a + b:");
        println(String.valueOf(c));

        int greaterValue = greaterValue(a, b);
        println("a > b:");
        println(String.valueOf(greaterValue));

        float x = 2.5f;
        float y = 7.5f;
        float z = add(x, y);
        println("x + y:");
        println(String.valueOf(z));
    }
    ```

9. Refactor the code so that `String.valueOf` is inside the `println` method, as follows:

    ```java
    static void println(Object out) {
        System.out.println(String.valueOf(out));
    }
    ```

10. Update the `main` method to use the new `println`, as follows:

    ```java
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = add(a, b);
        println("a + b:");
        println(c);

        int greaterValue = greaterValue(a, b);
        println("a > b:");
        println(greaterValue);

        float x = 2.5f;
        float y = 7.5f;
        float z = add(x, y);
        println("x + y:");
        println(z);
    }
    ```

11. Write a `printAll` variadic function that takes in an any number of `Objects`. Then loop over the input values and print them, as shown in the following example:

    ```java
        static void printAll(Object... out) {
        for (int i = 0; i < out.length; i++) {
            println(out[i]);
        }
        }
    ```

12. Update your `main` method to use `printAll`, and print `c` and `z`, as follows:

    ```java
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = add(a, b);
        println("a + b:");
        println(c);

        int greaterValue = greaterValue(a, b);
        println("a > b:");
        println(greaterValue);

        float x = 2.5f;
        float y = 7.5f;
        float z = add(x, y);
        println("x + y:");
        println(z);

        println("Print both c and z:");
        printAll(c, z);
    }
    ```

13. Update `main` to pass an array to the `printAll` function. The code in `main` should resemble the following:

    ```java
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = add(a, b);
        println("a + b:");
        println(c);

        int greaterValue = greaterValue(a, b);
        println("a > b:");
        println(greaterValue);

        float x = 2.5f;
        float y = 7.5f;
        float z = add(x, y);
        println("x + y:");
        println(z);

        println("Print both c and z:");
        printAll(c, z);

        String[] strings = { "One", "Two", "Three" };
        println("Print each string in the array:");
        printAll(strings);
    }
    ```

14. Use looping inside the `printAll` function:

    ```java
    static void printAll(Object... out) {
    //    for (int i = 0; i < out.length; i++) {
    //        println(out[i]);
    //    }
        for (Object o : out) { //this loop does the same thing as the commented out one
            println(o);
        }
    }
    ```

---

© 2023 2U. All Rights Reserved.