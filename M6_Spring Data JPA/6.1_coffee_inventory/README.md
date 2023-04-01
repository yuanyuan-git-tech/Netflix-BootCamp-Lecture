# Coffee Inventory

In this activity, learners will practice creating models and repositories.

## Instructions

1. Navigate to the [Spring Initializr webpage](http://start.spring.io).

2. Create a new project as follows:

    - Project: `Maven`

    - Language: `Java`

    - Spring Boot: `2.7.7 (SNAPSHOT)`

    - Project Metadata:

      - Group: `com.company`

      - Artifact: `city-web-service`

        >Setting the Artifact value will automatically update the values for Name and Package Name.

      - Package name: `com.company.citywebservice`

      - Packaging: `Jar`

      - Java: `8`

3. Add the following dependencies:

   - `Spring Web [WEB]`

   - `Spring Data JPA [SQL]`

   - `MySQL Driver [SQL]`

4. Click Generate Project and download to a location of your choice.

5. Unzip the project file.

6. Open the project in IntelliJ.

7. Open the `pom.xml` file.

8. Add the following dependency in the `<dependencies> </dependencies>` section of the `pom.xml` file:

   ```xml
   <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>4.13</version>
       <scope>test</scope>
   </dependency>   
   ```

9. Add the springdoc-openapi-ui dependency in the `<dependencies> </dependencies>` section of the `pom.xml` file:

    ```xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-ui</artifactId>
        <version>1.6.8</version>
    </dependency>
    ```

10. Open the `application.properties` in the `main/resources` folder and add the following configuration for the MySQL connection:

      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/simple_crm?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true
      spring.datasource.username=root
      spring.datasource.password=password

      spring.jpa.hibernate.ddl-auto=update

      spring.jpa.show-sql=true
      ```

11. Add a model class named `Coffee` with the following properties:

    - `Id`

    - `RoasterId`

    - `Name`

    - `Count`

    - `UnitPrice`

    - `Description`

    - `Type`

12. Add a model class named `Roaster` with the following properties:

    - `Id`

    - `Name`

    - `Street`

    - `City`

    - `State`

    - `Email`

    - `Note`

    - Set of `Coffee` objects

13. Create a repository for each model class. The repository must support all of the standard CRUD operations.

14. Create custom query methods to find the following:

    - Coffees by roaster

    - Coffees by type

    - Coffees by roaster and type

---

© 2023 2U. All Rights Reserved.
