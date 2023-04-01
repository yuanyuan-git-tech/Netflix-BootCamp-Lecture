# Record Collection

In this activity, you'll practice using Spring Data JPA by building a REST API to manage a record collection.

## Instructions

1. Open DBeaver and connect to MySQL.

2. Run the [01-record_collection_schema.sql](./starter/01-record_collection_schema.sql) script to create the `record_collection` database.

3. Run the [02-record_collection_test_schema.sql](./starter/02-record_collection_test_schema.sql) script to create the `record_collection_test` database.

4. Navigate to the [Spring Initializr website](http://start.spring.io).

5. Create a new project as follows:

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

6. Add the following dependencies:

   - `Spring Web [WEB]`

   - `Spring Data JPA [SQL]`

   - `MySQL Driver [SQL]`

7. Click Generate Project, and download to a location of your choice.

8. Unzip the project file.

9. Open the project in IntelliJ.

10. Open the `pom.xml` file.

11. Add the following dependency in the `<dependencies> </dependencies>` section of the `pom.xml` file:

      ```xml
      <dependency>
         <groupId>junit</groupId>
         <artifactId>junit</artifactId>
         <version>4.13</version>
         <scope>test</scope>
      </dependency>   
      ```

12. Add the springdoc-openapi-ui dependency in the `<dependencies> </dependencies>` section of the `pom.xml` file:

    ```xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-ui</artifactId>
        <version>1.6.8</version>
    </dependency>
    ```

13. Open the `application.properties` in the `main/resources` folder and add the following configuration for the MySQL connection:

      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/record_collection?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
      spring.datasource.username=root
      spring.datasource.password=password

      spring.jpa.hibernate.ddl-auto=none

      spring.jpa.show-sql=true
      ```

14. Add a `resources` package under the `test` folder and include an `application.properties` file to use for testing with the following code:

      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/record_collection_test?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
      spring.datasource.username=root
      spring.datasource.password=password
      ```

---

© 2023 2U. All Rights Reserved.
