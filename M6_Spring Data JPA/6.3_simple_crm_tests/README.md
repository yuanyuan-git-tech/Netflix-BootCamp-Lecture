# Simple CRM Tests

In this activity, we'll add unit tests for the `Note` repository.

## Instructions

1. Open the `simple-crm-api` project in IntelliJ.

2. Add a `resources` package under the `test` folder and include an `application.properties` file to use for testing with the following code:

   ```java
   spring.datasource.url=jdbc:mysql://localhost:3306/simple_crm_test?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true
   spring.datasource.username=root
   spring.datasource.password=password
   spring.jpa.hibernate.ddl-auto=update

   spring.jpa.show-sql=true
   ```

3. Add a `com.company.simplecrmapi.repository.NoteRepositoryTests` class to the `test` folder under the `com.company.simplecrmapi.repository` package, and include the following code:

   ```java
   package com.company.simplecrmapi.repository;

   import com.company.simplecrmapi.model.Customer;
   import com.company.simplecrmapi.model.Note;
   import org.junit.Before;
   import org.junit.Test;
   import org.junit.runner.RunWith;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.boot.test.context.SpringBootTest;
   import org.springframework.test.context.junit4.SpringRunner;

   import java.util.Optional;

   import static org.junit.Assert.*;

   @RunWith(SpringRunner.class)
   @SpringBootTest
   public class NoteRepositoryTests {

   }
   ```

   The following class-level annotations are used for testing Spring components:

      - `@RunWith`
      - `@SpringBootTest`

4. First, we'll add the two repositories we'll use for testing. Update the code to resemble the following:

   ```java
   @RunWith(SpringRunner.class)
   @SpringBootTest
   public class NoteRepositoryTests {

      @Autowired
      CustomerRepository customerRepo;

      @Autowired
      NoteRepository noteRepo;
   }
   ```

   - We'll use the `@Autowired` annotation with our repositories.

5. Add a `setUp` method that will run before each test with the following code:

   ```java
   @RunWith(SpringRunner.class)
   @SpringBootTest
   public class NoteRepositoryTests {

      @Autowired
      CustomerRepository customerRepo;

      @Autowired
      NoteRepository noteRepo;

      @Before
      public void setUp() throws Exception {
         noteRepo.deleteAll();
         customerRepo.deleteAll();
      }
   }
   ```

6. Add an `addNote` method with the following code:

   ```java
    @Test
    public void addNote() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");

        customerRepo.save(customer);

        //Act...
        Note note = new Note();
        note.setContent("This is a test note");
        note.setCustomerId(customer.getId());

        note = noteRepo.save(note);

        //Assert...
        Optional<Note> note1 = noteRepo.findById(note.getId());

        assertEquals(note1.get(), note);
    }
   ```

7. Run the tests to verify that they pass.

---

© 2023 2U. All Rights Reserved.
