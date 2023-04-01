# We Do: Echo Range Service

Solved code: [activities/03-we-echo-range/solved](./solved/)

In this activity, you will use application code and exceptions to ensure that incoming values conform to the business rules of your application. You will create the Echo Range service with Spring Initializr and implement the REST controller and service endpoint.

Follow along with the instructor throughout the exercise.

## Instructions

1. The instructor will display the slide with the Echo Range service specification to discuss the endpoint.

2. Open the [Spring Initializr](https://start.spring.io/).

3. Select the following options:

    - Project: `Maven`

    - Language: `Java`

    - Spring Boot: `2.7.7 (SNAPSHOT)`

    - Project Metadata:

      - Group: `com.company`

      - Artifact: `echo-range-service`

         > **Note:** Setting the Artifact value will automatically update the values for Name and Package Name.

      - Packaging: `Jar`

      - Java: `8`

4. For Dependencies add:

    - `Spring Web`

    - `Validation`

5. Click the `Generate` button to generate the project.

6. Unzip the project file that is generated and open it in IntelliJ.

7. Open the `pom.xml` file and add the following dependency in the `<dependencies> </dependencies>` section of the `pom.xml` file:

    ```xml
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13</version>
        <scope>test</scope>
    </dependency>
    ```

8. Add the springdoc-openapi-ui dependency in the `<dependencies> </dependencies>` section of the `pom.xml` file:

    ```xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-ui</artifactId>
        <version>1.6.8</version>
    </dependency>
    ```

9. Create the `CustomErrorResponse` class:

    - Create a new class called `com.company.echorangeservice.models.CustomErrorResponse`.

    - Display your `CustomErrorResponse` and implement the following:

        ```java
        package com.company.echorangeservice.models;

        import com.fasterxml.jackson.annotation.JsonFormat;

        import java.time.LocalDateTime;

        public class CustomErrorResponse {

            String errorMsg;
            int status;
            String errorCode;
            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
            LocalDateTime timestamp;

            // Two-argument constructor
            public CustomErrorResponse(String errorCode, String errorMsg) {
                this.errorCode = errorCode;
                this.errorMsg = errorMsg;
            }

            public String getErrorMsg() {
                return errorMsg;
            }

            public void setErrorMsg(String errorMsg) {
                this.errorMsg = errorMsg;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getErrorCode() {
                return errorCode;
            }

            public void setErrorCode(String errorCode) {
                this.errorCode = errorCode;
            }

            public LocalDateTime getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(LocalDateTime timestamp) {
                this.timestamp = timestamp;
            }
        }
        ```

      - Note the following:

        - This `CustomErrorResponse` class will serve as a formatted error response object to provide a formatted and consistent way of relaying error response notifications to the caller.

        - This class is a simple [Java POJO](https://www.geeksforgeeks.org/pojo-vs-java-beans/#:~:text=POJO%20classes,re%2Dusability%20of%20a%20program.) created to control the look and feel of error communications sent back to the caller.

10. Create the `EchoRangeServiceController`:

     1. Create a new class called `com.company.echorangeservice.controller.EchoRangeServiceController`.

     2. The instructor will once again display the Echo Range Service Specification to discuss the endpoint.

     3. Open your `EchoRangeServiceController` and implement the following:

        ```java
        package com.company.echorangeservice.controller;

        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.*;


        @RestController
        public class EchoRangeServiceController {

            @RequestMapping(value = "/echo/{input}", method = RequestMethod.GET)
            @ResponseStatus(value = HttpStatus.OK)
            public int echo(@PathVariable int input) {
                if (input < 1 || input > 10) {
                    throw new IllegalArgumentException("Input must be between 1 and 10.");
                }

                return input;
            }
        }
        ```

Note the following:

- Compare and contrast this code to that of the Echo service you did previously:

  - `@RequestMapping` is the same.

  - You have added a `@ResponseStatus`.
  
  - `@PathVariable` is the same, except that you are asking the framework to convert input to an integer instead of a string.

- Review the method implementation:

  - You manually check to make sure the input is in the required range.

  - If it isn't, you throw an `IllegalArgumentException`.

  - As you'll learn, the Spring Framework does a good job communicating in the application server log that an `IllegalArgumentException` was thrown, and the text you specified is shown. However, the response back to the client is a vague 500 Internal Server Error.

Compile and run your service. Hit the endpoint with both a browser and with Insomnia. Try it with both in-range and out-of-range values.

---

© 2022 2U. All Rights Reserved.
