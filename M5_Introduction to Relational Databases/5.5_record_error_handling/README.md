# We Do: Record Store Service - Validations & Error Handling

Starter code: [activities/05-we-record-error-handling/starter](./activities/02-we-error-handling/starter)

Solved code: [activities/05-we-record-error-handling/solved](./activities/02-we-error-handling/solved)

In this code-along, we will return to the Record Store project to learn how to handle JSR 303 validation errors within a `@RestControllerAdvice` component.

Follow along with the instructor throughout the exercise.

## Instructions

1. Open the Record Store project.

2. You are going to implement an error handler for the JSR 303 validation errors that can be thrown from the controller.

3. Create a new class called `com.company.models.CustomErrorResponse`.

4. Open `CustomErrorResponse` and implement the following:

    ```java
    package com.company.recordstoreapi.models;


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

5. Create a class called `controller.ControllerExceptionHandler`.

6. Implement the shell of the class first.

   - This is exactly like the shell you implemented for the Echo Range service!

7. Next, include the method-level annotations:

   - `@ExceptionHandler`: This method will handle `MethodArgumentNotValidExceptions`. This is the exception thrown when JSR 303 validation fails.

   - `@ResponseStatus`: This method will return a 422 Unprocessable Entity status. This means that the request was syntactically correct (in other words, it is well-formed HTTP) but that the service can't process it because it doesn't meet some business rule.

8. Now create the shell of the method:

   - We will return `ResponseEntity<CustomErrorResponse>` from this method. This object will get converted to JSON by the Jackson `ObjectMapper`, just like the return types of the methods in the controller.

   - The name of the method is arbitrary. Use a descriptive name.

   - The one input parameter is the exception that we want this method to handle. The Spring Framework will automatically hand that to the method.

9. Finally, implement the body of the method:

   - The `MethodArgumentNotValidException` holds the specific validation errors in a `BindingResult` object.

   - Each of the errors are held in a `FieldError` object. Here we get the list of `FieldError` objects.

   - Create an empty `ArrayList` of `CustomErrorResponse` objects that will be populated with the list of JSR 303 errors returned to the caller.

   - Translate the `FieldError` objects into `CustomErrorResponse` objects and add each of those objects to the `errorResponseList` that will be returned to the caller.

   - Finally, create a `ResponseEntity<CustomErrorResponse>` object that will include the `errorResponseList` and the `HttpStatus` code to be returned. This process is identical to that of the previous example.

10. Compile and run the service. Hit the endpoint with both a browser and with Insomnia, and purposely generate errors by removing required fields from the request. Additionally, send the date with more or less than four digits.
  
    - Now, when errors are triggered, instead of only seeing the errors in the application console log, we should note a descriptive, informative response message in the format of the `CustomErrorResponse`. Additionally, because the `CustomErrorResponse` objects are returned in a list, the list will include all errors in the response if there are multiple errors. For example:

        ```java
        [
            {
                "errorMsg": "You must supply a value for album.",
                "status": 422,
                "errorCode": "422 UNPROCESSABLE_ENTITY",
                "timestamp": "2020-12-09 07:55:18"
            },
            {
                "errorMsg": "You must supply a value for artist.",
                "status": 422,
                "errorCode": "422 UNPROCESSABLE_ENTITY",
                "timestamp": "2020-12-09 07:55:18"
            },
            {
                "errorMsg": "Year must be exactly 4 digits.",
                "status": 422,
                "errorCode": "422 UNPROCESSABLE_ENTITY",
                "timestamp": "2020-12-09 07:55:18"
            }
        ]
        ```

---

© 2022 2U. All Rights Reserved.
