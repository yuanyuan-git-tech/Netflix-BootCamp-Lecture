# Student Do: City Web Service Part 2

Starter folder: [starter/city-web-service](./starter/city-web-service)
Solved folder: [solved/city-web-service](./solved/city-web-service)

In this activity, you will write code for the city web service so that it passes all of the tests.

## Instructions

1. Add a main class named `com.company.controllers.ControllerExceptionHandler` and handle the following exceptions:

    * MethodArgumentNotValidException should return an HttpStatus of UNPROCESSABLE_ENTITY

    * IllegalArgumentException should return an HttpStatus of UNPROCESSABLE_ENTITY

    * NotFoundException should return an HttpStatus of NOT_FOUND

2. Open the main class named `com.company.controllers.CityController` and update the following:

    * trying to delete a city that doesn't exist should throw a NotFoundException of "City not found."

    * trying to get a city that doesn't exist should throw a NotFoundException of "City not found."

### Execute Test Cases

1. Run all of the tests in the test class `com.company.controllers.CityControllerTests` and verify that they all pass.

**Note:** When the tests all pass successfully your API is complete.

---

© 2023 2U. All Rights Reserved.
