# We Do: Hello, Spring Boot

Solved code: [./solved/hello)](./solved/hello)

In this activity, you will learn how to create a Spring Boot web application using Spring Intializr and how to create a simple REST endpoint using Spring Boot.

Follow along with the instructor throughout the activity.

## Instructions

1. Open the [Spring Initializr](https://start.spring.io/).

2. Select the following options:

    - Project: `Maven`

    - Language: `Java`

    - Spring Boot: `2.7.7 (SNAPSHOT)`

    - Project Metadata:

      - Group: `com.company`

      - Artifact: `hello`

         > **Note:** Setting the Artifact value will automatically update the values for Name and Package Name.

      - Packaging: `Jar`

      - Java: `8`

3. For Dependencies add the `Spring Web` dependency.

4. Click the `Generate` button to generate the project.

5. Unzip the project file that is generated and open it in IntelliJ.

6. Open the `pom.xml` file and add the following dependency in the `<dependencies> </dependencies>` section of the `pom.xml` file:

    ```xml
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13</version>
        <scope>test</scope>
    </dependency>
    ```

Now explore the project structure by following these steps:

1. Expand all the folders.

2. Click through the folder structure, and note the following:

   - This is just a regular Maven project structure!

   - `pom.xml` is a normal POM file.

   - The `src` folder is divided into a `main` folder and a `test` folder:

      - Inside `main`, note the following:

        - The `java` folder contains the Java source for the project.

        - The `resources` folder contains three main things:

          - Configuration (`application.properties`)

          - Static files (such as CSS, JavaScript, and image files) to be served up in the static folder

          - Thymeleaf templates

      - The `test` folder contains the unit tests for the project.

Run the project. At this time, you just want to check that everything compiles and runs. The application won't do anything except display an error page.

Follow these steps:

1. Run the project in IntelliJ.

    - Navigate to the `HelloController` class and open it, then click on the green arrow on Line 7 and select **Run HelloApplication.main()**.

2. Navigate to `localhost:8080` in the browser. The Spring Boot WhiteLabel Error Page should be displayed.

Next, you'll examine the inner workings of the application to discover what the Java file is doing.

Follow these steps:

1. Open `HelloApplication.java`.

2. Examine the `@SpringBootApplication` annotation, which turns on auto-configuration and component scanning for the application.

3. Examine `SpringApplication.run`, which bootstraps the application.

Finally, at this point you'll make the application do something exciting&mdash;implement a simple REST endpoint!

Follow these steps:

1. Create a new Java class called `com.company.hello.controller.HelloController`, with the following code:

   ```java
   package com.company.hello.controller;

   import org.springframework.web.bind.annotation.*;
      
      @RestController
      public class HelloController {
      
         @RequestMapping(value="/", method=RequestMethod.GET)
         String sayHello() {
               return "hello";
         }
      }
   ```

2. Rebuild and rerun the application.

3. Navigate to `localhost:8080` in the browser. This time, the word `"Hello"` should be printed to the page!

---

© 2023 2U. All Rights Reserved.
