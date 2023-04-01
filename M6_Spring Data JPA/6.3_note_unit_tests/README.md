# Note Unit Tests

In this activity, we'll use the H2 in-memory database for our unit tests for the `Note` repository. We'll also create additional tests for the `Note` repository.

## Instructions

1. Open the `simple-crm-api` project in IntelliJ.

2. Add a dependency to the `pom.xml` for the H2 in-memory database:

   ```xml
   <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
      <version>2.1.214</version>
      <scope>test</scope>
   </dependency>
   ```

3. Open the `appplication.properties` file in the `resources` folder under the `test` folder and comment out the database connection information for the test database:

   ```properties
   #spring.datasource.url=jdbc:mysql://localhost:3306/simple_crm_test?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true
   #spring.datasource.username=root
   #spring.datasource.password=password
   #spring.jpa.hibernate.ddl-auto=update
   #
   #spring.jpa.show-sql=true
   ```

4. Run the tests to verify that they pass.

5. Add new tests to the `NoteRepositoryTests` for the following:

   - getAllNotes

   - updateNote

   - deleteNote

6. Run the tests to verify that they pass.

---

© 2023 2U. All Rights Reserved.
