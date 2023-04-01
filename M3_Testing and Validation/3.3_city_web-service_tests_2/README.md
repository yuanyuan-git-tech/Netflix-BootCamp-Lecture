# Student Do: City Web Service Tests Part 2

Starter folder: [starter/city-web-service](./starter/city-web-service)
Solved folder: [solved/city-web-service](./solved/city-web-service)

In this activity, you will update the City model, create custom error messages, and implement test cases in the City Web Service.

## Instructions

### Update the City Model

1. Add the following validation to the `City` model class:

    * The `Name` field cannot be null or empty.

    * The `State` field cannot be null or empty.

    * The `Population` field must have a positive value.

### Create the Custom Error Response Model

1. Add a `com.company.citywebservice.models.CustomErrorResponse` class to the main project and implement the following fields:

    * String errorMsg;
    * int status;
    * String errorCode;
    * LocalDateTime timestamp;
        * The timestamp should use the "yyyy-MM-dd hh:mm:ss" format

### Create the Not Found Exception

1. Add a `com.company.citywebservice.exceptions.NotFoundException` class to the main project and implement the custom exception to use when a resource cannot be found.

### Implement Test Cases

1. Open the test class `com.company.controllers.CityControllerTests` and add new tests for the following:

    * shouldReturn422WhenPostingAnEmptyName

    * shouldReturn422WhenPostingAnEmptyState

    * shouldReturn422WhenPostingAPopulationLessThanOne

    * shouldReturn404WhenAttemptingToDeleteACityThatDoesNotExist

    * shouldReturn404StatusCodeIfCityNotFound

**Note:** The tests will all fail at this point. In the next activity you will write code for the city web service to pass these tests.

---

© 2023 2U. All Rights Reserved.
