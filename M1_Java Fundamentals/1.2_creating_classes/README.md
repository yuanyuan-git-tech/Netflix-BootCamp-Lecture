# Creating Classes

## 1. Creating Classes

In this activity, you will create and use classes in a Java program.

Follow along with the instructor throughout the exercise.

### 1.1 Instructions

1. Open IntelliJ and create a new project with the command-line app template called `class-review`.

2. Create a new Java class file named `Person` using the following code:

    ```java
    public class Person {
        public String name;
        public void sayHello() {
            System.out.println("Hello, I am " + this.name);
        }
    }
    ```

3. Create a simple `Main` class using a `main` method to instantiate and use the object, as follows:

    ```java
    public class Main {
        public static void main(String[] args) {
            Person jim = new Person();
            jim.name = "Jim";
            Person callie = new Person();
            callie.name = "Callie";
            jim.sayHello();
            callie.sayHello();
        }
    }
    ```

4. Add an empty constructor using the following code:

    ```java
        public class Person {
            public String name;

            Person() {}

            public void sayHello() {
                System.out.println("Hello, I am " + this.name);
            }
        }
    ```

5. Update `Person` with the following constructor:

    ```java
        public class Person {
            public String name;
            Person(String name) {
                this.name = name;
            }
            public void sayHello() {
                System.out.println("Hello, I am " + this.name);
            }
        }
    ```

6. Update the `main` method to create and use new `Person` objects, as follows:

    ```java
        public class Main {
            public static void main(String[] args) {
                Person jim = new Person("Jim");
                Person callie = new Person("Callie");
                jim.sayHello();
                callie.sayHello();
            }
        }
    ```

7. Update the `Person` class to include getters and setters for `name`, as follows:

    ```java
    public class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void sayHello() {
            System.out.println("Hello, I am " + this.name);
        }
    }
    ```

8. Update `Person` to include a `createdDate` property, as follows:

    ```java
    import java.util.Date;

    public class Person {
        private String name;
        private Date createdDate;

        public Person(String name) {
            this.name = name;
            this.createdDate = new Date();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getCreatedDate() {
            return createdDate;
        }

        public void sayHello() {
            System.out.println("Hello, I am " + this.name);
        }
    }
    ```

9. Finally, update the `main` function to print out the created dates for Jim and Callie, as follows:

    ```java
    public class Main {
        public static void main(String[] args) {
            Person jim = new Person("Jim");
            Person callie = new Person("Callie");
            jim.sayHello();
            callie.sayHello();
            System.out.println(jim.getCreatedDate());
            System.out.println(callie.getCreatedDate());
        }
    }
    ```

---

© 2023 2U. All Rights Reserved.
