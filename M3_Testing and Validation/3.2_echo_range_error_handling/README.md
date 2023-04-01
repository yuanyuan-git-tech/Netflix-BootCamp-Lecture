# We Do: Echo Range Service Continued - @RestControllerAdvice

Starter code: [activities/04-we-echo-range-error-handling/starter](./activities/04-we-echo-range-error-handling/starter)

Solved code: [activities/04-we-echo-range-error-handling/solved](./activities/04-we-echo-range-error-handling/solved)

In this activity, you will use the Echo Range service project to learn how to handle `IllegalArgumentException` occurrences within a `@RestControllerAdvice` component.

Follow along with the instructor throughout the exercise.

## Instructions

1. Open the Echo Range service project.

2. You're going to implement an error handler for the controller. Create a new class called `com.example.echorangeserve.controller.ControllerExceptionHandler`.

3. Implement the shell of the class first, as follows:

    - Add the `@RestControllerAdvice` annotation to the top of the class, indicating to the Spring Framework that this is an error handler for the controllers of this application.

4. Next, include the method-level annotations:

   - `@ExceptionHandler`: This method will handle `IllegalArgumentExceptions`.

   - `@ResponseStatus`: This method will return a 422 Unprocessable Entity status. This means that the request was syntactically correct (in other words, it is well-formed HTTP) but that the service can't process it because it doesn't meet some business rule.

5. Now create the shell of the method as follows:

    - We will return `ResponseEntity<CustomErrorResponse>` from this method. This object will get converted to JSON by the Jackson `ObjectMapper`, just like the return types of the methods in the controller.

    - The name of the method is arbitrary. Use a descriptive name.

    - The single input parameter is the exception that we want this method to handle. The Spring Framework will automatically hand this input to the method.

6. Finally, implement the body of the method:

    - First, create a new `CustomErrorResponse` object. The constructor takes two parameters:

      - The first parameter is the string definition of the HTTP status (in this example: `HttpStatus.UNPROCESSABLE_ENTITY.toString()`).

      - The second parameter is the message for the error. We use the message from the thrown exception `e.getMessage()`.

    - Next, use the object setter to set the value for status.

    - And complete the `CustomErrorResponse` object creation by setting the timestamp.

    - Next, create a new `ResponseEntity<CustomErrorResponse>` object. The constructor has two parameters:

        - The `CustomErrorResponse` object.

        - The `HttpStatus` we want to associate with the response.

7. Compile and run the service. Hit the endpoint with both a browser and with Insomnia. Try it with both in-range and out-of-range values.

    - Now when out-of-range values are sent, instead of a generic WhiteLabel Error response, you should note a descriptive, informative response message in the format of the `CustomErrorResponse`.

---

© 2022 2U. All Rights Reserved.
