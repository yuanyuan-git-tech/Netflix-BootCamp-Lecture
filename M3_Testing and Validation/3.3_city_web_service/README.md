# Student Do: City Web Service

Starter folder: [starter/city-web-service](./starter/city-web-service)
Solved folder: [solved/city-web-service](./solved/city-web-service)

In this activity, you will write code for the city web service so that it passes the tests.

## Instructions

1. Open the main class `com.company.controllers.CityController`.

2. The application must store all data in memory. Add to your class a list containing several `City` objects that the application can use for its initial data.

3. Add the following capabilities to your API:

    * Add a city

        * URI: `/city`

        * Method: `POST`

        * Request Body: City

        * Response Body: City

    * Delete a city by name

        * URI: `/city/{name}`

        * Method: `DELETE`

        * Request Body: None

        * Response Body: None

    * Retrieve all the cities

        * URI: `/city`

        * Method: `GET`

        * Request Body: None

        * Response Body: City List

    * Retrieve one city by name

        * URI: `/city/{name}`

        * Method: `GET`

        * Request Body: None

        * Response Body: City

### Execute Test Cases

1. Run all of the tests in the test class `com.company.controllers.CityControllerTests` and verify that they all pass.

**Note:** When the tests all pass successfully your API is complete.

---

© 2023 2U. All Rights Reserved.
