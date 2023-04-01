# Student Do: City Web Service Tests

Solved folder: [solved/city-web-service](./solved/city-web-service)

In this activity, you will create the starter project for a city web service and implement tests for the city web service.

## Instructions

1. Open the [Spring Initializr](https://start.spring.io/).

2. Select the following options:

    - Project: `Maven`

    - Language: `Java`

    - Spring Boot: `2.7.7 (SNAPSHOT)`

    - Project Metadata:

      - Group: `com.company`

      - Artifact: `city-web-service`

         > **Note:** Setting the Artifact value will automatically update the values for Name and Package Name.

      - Package name: `com.company.citywebservice`

      - Packaging: `Jar`

      - Java: `8`

3. For Dependencies add:

    - `Spring Web`

    - `Validation`

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

7. Add the springdoc-openapi-ui dependency in the `<dependencies> </dependencies>` section of the `pom.xml` file:

    ```xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-ui</artifactId>
        <version>1.6.8</version>
    </dependency>
    ```

7. To load the changes into the project, select Load Maven Changes or press Ctrl+Shift+O.

### Create the City Model

1. Add the class `com.company.models.City` to the project. This class will represent the data for each city in your application.

2. Add to the class a getter and setter method for each of the following:

    * Name

    * State

    * Population

    * Whether or not the city is a state capital

### Create the City Controller

1. Add the main class `com.company.controllers.CityController` to the project. This class will serve as the basis for your city web service.

### Implement Test Cases

**Note:** Following a TDD approach, in this activity you will build tests for the API. In the next activity, you will implement the API to pass these tests.

The city web service will use the following API:

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

1. Add the test class `com.company.controllers.CityControllerTests` to the project. This class will serve as the basis for your city web service tests.

2. Using MockMVC, add tests for the following:

    * `shouldReturnNewCityOnValidPostRequest`
    * `shouldDeleteByCityAndReturn204StatusCode`
    * `shouldReturnAllCitiesInCollection`
    * `shouldReturnCityByName`

**Note:** The tests will all fail at this point. In the next activity you will write code for the city web service to pass these tests.

---

© 2023 2U. All Rights Reserved.
